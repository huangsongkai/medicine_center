package com.medicineCenter.service;

import com.medicineCenter.interfaces.controller.NotEnoughException;
import com.medicineCenter.model.dataObject.*;
import com.medicineCenter.model.dto.AvoidanceDTO;
import com.medicineCenter.model.dto.ExpertsDTO;
import com.medicineCenter.service.avoidance.*;
import com.medicineCenter.util.LocationUtil;
import com.medicineCenter.util.MessageUtil;
import com.medicineCenter.util.RandomUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */
@Service
public class TaskUtilService {
    @Resource
    TaskCrudService taskCrudService;
    @Resource
    InspectionGroupCrudService inspectionGroupCrudService;
    @Resource
    ExpertsCrudService expertsCrudService;
    @Resource
    GroupExpertsCrudService groupExpertsCrudService;
    @Resource
    TaskLogCrudService taskLogCrudService;
    @Resource
    RandomPickerService randomPickerService;
//  规避原则
    @Resource
    ConfirmedExpertsAvoidance_1 confirmedExpertsAvoidance1;
    @Resource
    ConfirmedAdressAvoidance confirmedAdressAvoidance;
    @Resource
    ExpertsAddressAvoidance shrinkExperts;
    @Resource
    FreqAvoidance freqAvoidance;
    @Resource
    AlreadyReplacedExpertsAvoidance alreadyReplacedExpertsAvoidance;
    @Resource
    AddressAvoidance addressAvoidance;
    @Resource
    BacteriaAvoidance bacteriaAvoidance;
    @Resource
    TaskInspectionInfoCrudService taskInspectionInfoCrudService;
    @Resource
    TaskService taskService;




    /**
     * 通用方法
     * 替换一个专家
     * 根据taskId和expertsId查询出一条人员删除从新生成一个人员
     * @param taskId
     * @param expertsId
     * @param reason
     * @return
     */
    @Transactional
    public ExpertsDTO selectGroupOneDetail(String userName, int taskId, int expertsId, String reason, String department) throws NotEnoughException, ParseException {

        Task task = taskCrudService.get(taskId);
        //检查没结束的任务
        List<Experts> notEndExecutionexperts = new ArrayList<Experts>();
        List<Task> notEndExecution = taskCrudService.selectByEndExecutionTime(task.getSource());
        if (notEndExecution.size() != 0) {
            for (Task notEndExecutiontask : notEndExecution) {
                List<GroupExperts> notEndExecutiongroupExperts = groupExpertsCrudService.getByTaskId(notEndExecutiontask.getTaskId());
                for (GroupExperts groupExperts : notEndExecutiongroupExperts) {
                    notEndExecutionexperts.add(expertsCrudService.get(groupExperts.getExpertsId()));
                }

            }
        }
        List<Experts> returnExpertsList = new ArrayList<Experts>();
        TaskLog taskLog = new TaskLog();
        taskLog.setCreateUser(userName);  //放入操作人
        GroupExperts groupExperts1 = groupExpertsCrudService.selectByTaskIdAndExpertsId(taskId, expertsId);//查出要替换的是谁
        taskLog.setOrigExpertsId(expertsId);//在taskLog表中插入替换之前的人
        int deleteState = groupExpertsCrudService.delete(groupExperts1);//把要替换的删除掉
        taskLog.setReason(reason);
        Experts expert = expertsCrudService.get(expertsId);//查出替换的人的信息
        List<Experts> expertsList = expertsCrudService.selectExpertsForSource(expert.getSource());//根据要替换人的科室查询一个list
        List<InspectionGroup> inspectionList = inspectionGroupCrudService.selectByTaskId(taskId);
            String category = expert.getCategory();//是哪个组的成员
            String categoryTwo = expert.getCategoryTwo();//第二组成员变量
            for (Experts experts : expertsList) {
            if (experts.getCategory().equals(category) && experts.getCategoryTwo().equals(categoryTwo)){
                returnExpertsList.add(experts);
            }
        }

        returnExpertsList.removeAll(notEndExecutionexperts);

        List<InspectionGroup> inspectionList1 = inspectionGroupCrudService.selectByTaskId(taskId);
        AvoidanceDTO avoidanceDTO = new AvoidanceDTO();
        avoidanceDTO.setCandidateList(returnExpertsList);
        avoidanceDTO.setSource(expert.getSource());
        //avoidanceDTO.setExpertsId();candidateList
        avoidanceDTO.setTaskId(taskId);
        avoidanceDTO.setBacteria(expert.getBacteria());
        avoidanceDTO.setAttribution(task.getAttribution());
        List<String> excludeAddrsList = new ArrayList<String>();
        //把原来的专家删除掉避免重复------------
        List<Experts> removeExperts = new ArrayList<Experts>();
        List<GroupExperts> groupExperts = groupExpertsCrudService.ExpertsListForTaskId(taskId);//根据taskid查出这个任务现在都有谁
        for (GroupExperts groupExpert: groupExperts) {
            Experts expert1 = expertsCrudService.get(groupExpert.getExpertsId());//查出现有的专家有
            removeExperts.add(expert1);
        }
        excludeAddrsList.add(task.getAttribution());
        returnExpertsList.removeAll(removeExperts);
        //-----------------------------------

        //多个单位进行地域规避
        List<TaskInspectionInfo> TaskInspectionInfo = taskInspectionInfoCrudService.getTaskId(taskId);
        if (TaskInspectionInfo.size() != 0){
            for (TaskInspectionInfo taskInspectionInfo : TaskInspectionInfo) {
                excludeAddrsList.add(taskInspectionInfo.getAttribution());
            }
        }
        avoidanceDTO.setExcludeAddrs(excludeAddrsList);
        if ("一科".equals(task.getSource()) || "五科".equals(task.getSource()) || "六科".equals(task.getSource()) || "七科".equals(task.getSource())){

        }else{
            List<Avoidance> avoidanceList = genAvoidanceList(department);//获取规避原则进行规避.
            for (Avoidance avoidance : avoidanceList) {
                avoidanceDTO = avoidance.ShrinkExperts(avoidanceDTO);
            }
        }


        int randomNum = RandomUtil.genericOffset(avoidanceDTO.getCandidateList().size());//生成随机数
        //随机选出指定人员
        ExpertsDTO expertsDTO = new ExpertsDTO();
        Experts expert2 = avoidanceDTO.getCandidateList().get(randomNum);//选中的专家
        GroupExperts  groupExperts2 = new GroupExperts();
        groupExperts2.setExpertsId(expert2.getExpertsId());
        groupExperts2.setTaskId(taskId);
        groupExperts2.setState("待确认");
        groupExpertsCrudService.add(groupExperts2);
        taskLog.setNewExpertsId(expert2.getExpertsId());//在taskLog表中插入替换之后的人
        taskLog.setTaskId(taskId);//插入任务id
        taskLogCrudService.add(taskLog);//添加一条记录
        BeanUtils.copyProperties(expert2, expertsDTO );
        expertsDTO.setState("待确认");
        expertForMessage(taskId, expert2.getExpertsId());



        return expertsDTO;
    }

    /**
     * 在质量科确认专家列表之后,根据taskId查出要检查的单位和检查时间还有检查人的手机号
     * @param taskId
     * @return
     */
    @Transactional
    public int expertForMessage(int taskId , int  expertsId ) throws ParseException {
        Task task = taskCrudService.get(taskId);
        String inspectionUnit = task.getInspectionUnit();//被检单位
        String startExecutionTime = task.getStartExecutionTime();//检查时间
        String endExecutionTime = task.getEndExecutionTime();//检车结束时间
        Experts experts = expertsCrudService.get(expertsId);//查出替换的人员
        DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        List<GroupExperts> groupExperts = groupExpertsCrudService.getByTaskId(taskId);
        // TODO: 2016/11/30 查询出所有人进行短信通知 要钱
            // 电话号码字符串，中间用英文逗号间隔
            //StringBuffer mobileString=new StringBuffer(experts.getPhone());
            StringBuffer mobileString=new StringBuffer(experts.getPhone().trim().substring(0,11));
            StringBuffer contextString1=new StringBuffer("【审核查验中心】"+
                    experts.getName()+"检查员：\n"+
                    "您好! 黑龙江省食品药品审核查验中心拟邀请您于"+startExecutionTime+"至"+endExecutionTime+"期间参加"+inspectionUnit+"检查工作，检查工作地点："+task.getAttribution()+"。" +
                    "请您在收到信息后一个小时内电话给予回复是否能够参加本次检查。电话：0451-51983683，联系人：任春晓。\n" +
                    "如您能参加本次检查工作，请遵守以下三点要求：\n"+
                    "一、请严格按照您所在单位的有关规定履行请假手续。\n"+
                    "二、购买车票、住宿应严格使用公务卡结算，并将刷卡存根和消费票据一同寄到省中心。\n"+
                    "三、请您于"+startExecutionTime+" 8:00前到达指定工作地点。如需召开检查前工作动员会，另行通知。\n");

            //StringBuffer contextString=new StringBuffer("尊敬的"+experts.getName()+",请您在"+startExecutionTime+"到达"+inspectionUnit+" 进行检查");
            // 签名
            String sign="";
            // 追加发送时间，可为空，为空为及时发送
            String stime="";
            // 扩展码，必须为数字 可为空
            StringBuffer extno=new StringBuffer();
            try {
                    String messageState= MessageUtil.doPost(mobileString, contextString1, sign, stime, extno);//调用发送短信方法
            } catch (Exception e) {
                System.out.print("请检查短信功能是否欠费!!!!");
                e.printStackTrace();
            }

        return taskId;
    }


    /**
     * 调用isRedundant查询方法看人员重复不
     * @param num
     * @param expertsList
     * @param returnExpertsList
     * @param task
     * @return
     */
    public Experts isRedundantDetail(int num, List<Experts> expertsList , List<Experts> returnExpertsList, Task task, String department){
        int i = 0;
        while (i < num) {
            int randomNum = RandomUtil.genericOffset(expertsList.size());//生成随机数
            Experts expert = expertsList.get(randomNum);
            if ("two".equals(department)){
                if(isRedundantTwo(returnExpertsList, expert, task.getInspectionUnit())){//;//判断是不是重复
                    continue;
                }else {
                    i++;
                    return expertsList.get(randomNum);
                }
            }else if ("three".equals(department)){
                if(isRedundant(returnExpertsList, expert, task.getInspectionUnit())){//;//判断是不是重复
                    continue;
                }else {
                    i++;
                    return expertsList.get(randomNum);
                }
            }else if ("one".equals(department)){
                if(isRedundantTwo(returnExpertsList, expert, task.getInspectionUnit())){//;//判断是不是重复
                    continue;
                }else {
                    i++;
                    return expertsList.get(randomNum);
                }
            }
        }
        return null; //返回空的话 就是出问题了
    }

    /**
     * 根据需求生成全部专家,各科室通用
     * @param taskId
     * @param department
     * @return
     */

    public List<Experts> selectGroupDetail(int taskId, String bacteria, String department) throws Exception {
        List<Experts> returnExpertsList = new ArrayList<Experts>();
        Task task = taskCrudService.get(taskId);

        List<GroupExperts> groupExpertsList = groupExpertsCrudService.getByTaskId(taskId);
        if (groupExpertsList.size()!=0) {
            return  returnExpertsList;  //已经生成的返回空
        }else{
            task.setState("已生成");
            taskCrudService.update(task);
        }

        //检查没结束的任务
        List<Experts> notEndExecutionexperts = new ArrayList<Experts>();
        List<Task> notEndExecution = taskCrudService.selectByEndExecutionTime(task.getSource());
        if (notEndExecution.size() != 0) {
            for (Task notEndExecutiontask : notEndExecution) {
                List<GroupExperts> notEndExecutiongroupExperts = groupExpertsCrudService.getByTaskId(notEndExecutiontask.getTaskId());
                for (GroupExperts groupExperts : notEndExecutiongroupExperts) {
                    notEndExecutionexperts.add(expertsCrudService.get(groupExperts.getExpertsId()));
                }

            }
        }

        List<Experts> expertsList = expertsCrudService.selectExpertsForSource(task.getSource());
        List<InspectionGroup> inspectionList = inspectionGroupCrudService.selectByTaskId(taskId);
        for (InspectionGroup inspectionGroup : inspectionList) {
            String category = inspectionGroup.getCategory();//是哪个组的成员
            String categoryTwo = inspectionGroup.getCategoryTwo();//第二组成员变量
            Integer expertsNum = inspectionGroup.getNum();//需要的人数
            for (Experts experts : expertsList) {
                if (experts.getCategory().equals(category) && experts.getCategoryTwo().equals(categoryTwo)){
                    returnExpertsList.add(experts);
                }
         }
        }

        returnExpertsList.removeAll(notEndExecutionexperts);




        boolean checkState = checkExpertsList(returnExpertsList, inspectionList);
        if (!(checkState)){
            task.setState("处理中");
            taskCrudService.update(task);
            throw new NotEnoughException("专家人数不足");//人数不足抛出异常
        }

        AvoidanceDTO avoidanceDTO = new AvoidanceDTO();
        avoidanceDTO.setBacteria(task.getBacteria());
        avoidanceDTO.setCandidateList(returnExpertsList);
        avoidanceDTO.setSource(task.getSource());
        //avoidanceDTO.setExpertsId();candidateList
        avoidanceDTO.setTaskId(taskId);
        avoidanceDTO.setAttribution(task.getAttribution());
        List<String> excludeAddrsList = new ArrayList<String>();
        excludeAddrsList.add(task.getAttribution());
        //多个单位进行地域规避
        List<TaskInspectionInfo> TaskInspectionInfo = taskInspectionInfoCrudService.getTaskId(taskId);
        if (TaskInspectionInfo.size() != 0){
            for (TaskInspectionInfo taskInspectionInfo : TaskInspectionInfo) {
                excludeAddrsList.add(taskInspectionInfo.getAttribution());
            }
        }

        avoidanceDTO.setExcludeAddrs(excludeAddrsList);

        if ("一科".equals(task.getSource()) || "五科".equals(task.getSource()) || "六科".equals(task.getSource()) || "七科".equals(task.getSource())){

        }else{
            List<Avoidance> avoidanceList = genAvoidanceList(department);//获取规避原则进行规避.
            for (Avoidance avoidance : avoidanceList) {
                avoidanceDTO = avoidance.ShrinkExperts(avoidanceDTO);
            }
        }

        boolean checkState1 = checkExpertsList(avoidanceDTO.getCandidateList(), inspectionList);
        if (!(checkState1)){
            task.setState("处理中");
            taskCrudService.update(task);
            throw new NotEnoughException("专家人数不足"); //人数不足抛出异常
        }
        //随机选出指定人员
            List<Experts> expertList = randomPickerService.pickExpertsByAvoidanceDTO(avoidanceDTO.getCandidateList(), inspectionList);
        //把专家保存在表中
        for (Experts experts:expertList) {
            GroupExperts groupExperts = new GroupExperts();
            groupExperts.setExpertsId(experts.getExpertsId());
            groupExperts.setTaskId(taskId);
            groupExperts.setState("待确认");
            groupExpertsCrudService.add(groupExperts);
        }
        int messageReturn = taskService.expertsForMessage(taskId, 1);//发动短信
        return expertList;
    }

    /**
     * 判断人数够不够需求人数 足够的话返回true 不足够的话返回false
     * 判断人数信息,迭代分类 看看每个分类人数够不够
     * @param expertsList
     * @param inspectionGroup
     * @return
     */
    public boolean checkExpertsList(List<Experts> expertsList, List<InspectionGroup> inspectionGroup){
        List<Experts> checkList = new ArrayList<Experts>();
        for ( InspectionGroup inspectionGroup1 : inspectionGroup) {
            for (Experts  experts: expertsList) {
                if (experts.getCategory().equals(inspectionGroup1.getCategory()) && experts.getCategoryTwo().equals(inspectionGroup1.getCategoryTwo())){
                    checkList.add(experts);
                }
            }
            if (checkList.size() < inspectionGroup1.getNum()){
               return false;
            }
        }
        return true;
    }


//        List<InspectionGroup> inspectionList = inspectionGroupCrudService.selectByTaskId(taskId);




//        for (InspectionGroup inspectionGroup:inspectionList) {
//            String category = inspectionGroup.getCategory();//是哪个组的成员
//            String categoryTwo = inspectionGroup.getCategoryTwo();//第二组成员变量
//            Integer num = inspectionGroup.getNum();//需要的人数
//
//
//            if ("two".equals(department)) {
//
//                List<Experts> expertsList = expertsCrudService.selectByCategoryAndCategoryTwo(category, categoryTwo);
//                //创建一个规避原则列表
//                List<Avoidance> avoidanceList = new ArrayList<Avoidance>();
//                ConfirmedExpertsAvoidance_1 confirmedExpertsAvoidance1 = new ConfirmedExpertsAvoidance_1();
//
//
//                returnExpertsList.add(isRedundantDetail(num,  expertsList , returnExpertsList , task ,department));//调用查重方法进行查重
//            }else if ("three".equals(department)){
//                List<Experts> expertsList = expertsCrudService.selectByCategoryAndBacteria(category, bacteria);
//                returnExpertsList.add(isRedundantDetail(num,  expertsList , returnExpertsList , task ,department));//调用查重方法进行查重
//            }else if ("one".equals(department)){
//                List<Experts> expertsList = expertsCrudService.selectByCategoryAndCategoryTwo(category, categoryTwo);
//                returnExpertsList.add(isRedundantDetail(num,  expertsList , returnExpertsList , task ,department));//调用查重方法进行查重
//            }
//        }
//        for (Experts experts:returnExpertsList) {
//            GroupExperts groupExperts = new GroupExperts();
//            groupExperts.setExpertsId(experts.getExpertsId());
//            groupExperts.setTaskId(taskId);
//            groupExperts.setState("待确认");
//            groupExpertsCrudService.add(groupExperts);
//        }
//        return returnExpertsList;

    /**
     * 查询地址信息是否重复
     * @param attribution
     * @param addrs
     * @return
     */
    public boolean isIn(String attribution, List<String> addrs){
        for(String addr : addrs){
            if(attribution.equals(addr))
                return true;
        }
        return false;
    }

    /**
     * 生成规避原则列表
     * @return
     */
    public List<Avoidance> genAvoidanceList(String department){
        List<Avoidance> avoidanceList = new ArrayList<Avoidance>();
        if ("one".equals(department) || "five".equals(department)) {
            avoidanceList.add(alreadyReplacedExpertsAvoidance);
            return avoidanceList;
        }
        avoidanceList.add(alreadyReplacedExpertsAvoidance);//删除已经替换过的专家.
        avoidanceList.add(bacteriaAvoidance);//删除有菌的.
        avoidanceList.add(confirmedExpertsAvoidance1);
        avoidanceList.add(confirmedAdressAvoidance);
        avoidanceList.add(shrinkExperts);
        avoidanceList.add(freqAvoidance);
       // avoidanceList.add(addressAvoidance);

        return avoidanceList;
    }
    /**
     * 二科专用
     * 判断要返回的List中和新生成的对象当中有没有重复的
     * @param returnExpertsList
     * @param expert0
     * @param inspectionUnit
     * @return
     */
    public Boolean isRedundantTwo(List<Experts> returnExpertsList, Experts expert0, String inspectionUnit){
        String work0 = expert0.getWork();
        String address0 = LocationUtil.getOrgName(work0);
        String inspectionUnit0 = LocationUtil.getOrgName(inspectionUnit);
        System.out.println(LocationUtil.getOrgName(work0));
        for ( Experts expert1: returnExpertsList) {
            String work1 = expert1.getWork();
            String address1 = LocationUtil.getOrgName(work1);
            if(address0.equals(address1) || address0.equals(inspectionUnit0)){
                return  true;
            }
        }
        return  false;
    }
    /**
     * 三科专用
     * 判断要返回的List中和新生成的对象当中有没有重复的
     * @param returnExpertsList
     * @param expert0
     * @param inspectionUnit
     * @return
     */
    public Boolean isRedundant(List<Experts> returnExpertsList, Experts expert0, String inspectionUnit){
        String work0 = expert0.getWork();
        String address0 = LocationUtil.getBelongedCity(work0);
        if (work0.equals( LocationUtil.getBelongedCity(inspectionUnit))){
            return true;
        }
        for ( Experts expert1: returnExpertsList) {
            String work1 = expert1.getWork();
            String address1 = LocationUtil.getBelongedCity(work1);
            if(address0.equals(address1)){
                if(!work0.equals("省"))
                    return true;
                else if(expert0.getName().equals(expert1.getName())){
                    return  true;
                }
            }
        }
        return  false;
    }


}
