package com.medicineCenter.service;

import com.medicineCenter.dao.TaskMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.*;
import com.medicineCenter.model.dto.*;
import com.medicineCenter.util.MessageUtil;
import com.medicineCenter.util.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */

@Service
public class TaskService {
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
    TaskUtilService taskUtilService;
    @Resource
    TaskMapperExt taskMapperExt;

    @Resource
    TaskUpdateLogCrudService taskUpdateLogCrudService;
    @Resource
    TaskInspectionInfoCrudService taskInspectionInfoCrudService;
    @Resource
    TaskService taskService;

    @Transactional
    public Result add(TaskDTO taskDTO) {
        Task task = new Task();
        try {
            BeanUtils.copyProperties(task, taskDTO);//copy对象的属性
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        task.setState("处理中");
        //
        String inspectionName = "";//单位名字
        String attribution = "";//归属地
        for (TaskInspectionInfo taskInspectionInfo : taskDTO.getInspectionUnitList()) {
            if (taskDTO.getInspectionUnitList().size() == 1){
                inspectionName += taskInspectionInfo.getInspectionUnit();
                attribution += taskInspectionInfo.getAttribution();
            }else{
                inspectionName += taskInspectionInfo.getInspectionUnit()+",";
                attribution += taskInspectionInfo.getAttribution()+",";
            }
        }
        task.setInspectionUnit(inspectionName);
        task.setAttribution(attribution);
        Result taskin = taskCrudService.add(task);
        for (TaskInspectionInfo taskInspectionInfo : taskDTO.getInspectionUnitList()) {
            taskInspectionInfo.setTaskId(task.getTaskId());
            taskInspectionInfoCrudService.add(taskInspectionInfo);
        }

        if (taskDTO.getGroupList() != null) {
            for (InspectionGroup inspectionGroup : taskDTO.getGroupList()) {
                inspectionGroup.setTaskId(task.getTaskId());
                inspectionGroup.setCategoryTwo("无");
                inspectionGroupCrudService.add(inspectionGroup);
            }
            //添加一个检查组长想
            InspectionGroup inspectionGroup = new InspectionGroup();
            inspectionGroup.setCategory("检查组长");
            inspectionGroup.setCategoryTwo("无");
            inspectionGroup.setNum(taskDTO.getLeaderNum());
            inspectionGroup.setTaskId(task.getTaskId());
            inspectionGroupCrudService.add(inspectionGroup);
        }
        return taskin;
    }

    @Transactional
    public Result update(TaskDTO taskDTO) {
        Task task = new Task();
        try {
            BeanUtils.copyProperties(task, taskDTO);//copy对象的属性
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        task.setState("变更中");
        taskCrudService.update(task);
        if (taskDTO.getGroupList() != null) {
            for (InspectionGroup inspectionGroup : taskDTO.getGroupList()) {
                InspectionGroupExample inspectionGroupExample = new InspectionGroupExample();
                inspectionGroupExample.or().andTaskIdEqualTo(taskDTO.getTaskId());
                inspectionGroupCrudService.updateByExample(inspectionGroupExample, inspectionGroup);
            }
        }
        return null;
    }

    @Transactional
    public int DeleteOrUpdate(TaskDTO taskDTO) {
        Task task = taskCrudService.get(taskDTO.getTaskId());
        task.setState("已取消");
        int result = taskCrudService.update(task);
        return result;
    }

    public TaskDTO getTaskIdReturnTaskDTO(int id) {
        TaskDTO taskDTO = new TaskDTO();
        Task task = taskCrudService.get(id);
        try {
            BeanUtils.copyProperties(taskDTO, task);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        List<InspectionGroup> inspection = inspectionGroupCrudService.selectByTaskId(task.getTaskId());
        taskDTO.setGroupList(inspection);
        return taskDTO;
    }

    @Transactional
    public List<Experts> selectGroup(int taskId, String bacteria, String department) throws Exception {
        List<Experts> emptyExpertsList = new ArrayList<Experts>();
        return taskUtilService.selectGroupDetail(taskId, bacteria, department);
    }
    /**
     * 根据taskId和expertsId查询出一条人员删除从新生成一个人员
     *
     * @param taskId
     * @param expertsId
     * @param reason
     * @return
     */
    @Transactional
    public ExpertsDTO selectGroupOne(String userName, int taskId, int expertsId, String reason, String department) throws Exception {
        return taskUtilService.selectGroupOneDetail(userName, taskId, expertsId, reason, department);//出问题返回一个空
    }

    /**
     * 确定任务
     *
     * @param taskId
     */
    @Transactional
    public int determineTask(int taskId) throws ParseException {
        Task task = taskCrudService.get(taskId);
        task.setState("已完成");
        taskCrudService.updateGroupExpertsByState(taskId);
        int messageReturn = taskService.expertsForMessage(taskId, 0);//发动短信
        return taskCrudService.update(task);

    }


    //二科---------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * 二科任务保存
     *
     * @param taskTwoDTO
     */
    @Transactional
    public Result addTwo(TaskTwoDTO taskTwoDTO) {
        Task task = new Task();
        try {
            BeanUtils.copyProperties(task, taskTwoDTO);//copy对象的属性
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        task.setState("处理中");
        Result taskin = taskCrudService.add(task);
        addTaskTwoExpert("监管", taskTwoDTO.getJianguan(), task.getTaskId());
        addTaskTwoExpert("检验", taskTwoDTO.getJianyan(), task.getTaskId());
        addTaskTwoExpert("临床", taskTwoDTO.getLinchuang(), task.getTaskId());
        addTaskTwoExpert("组长", taskTwoDTO.getZuzhang(), task.getTaskId());
        return taskin;
    }
    /**
     * 四科任务保存
     * @param taskFourDTO
     */
    @Transactional
    public Result addFour(TaskFourDTO taskFourDTO) {
        Task task = new Task();
        try {
            BeanUtils.copyProperties(task, taskFourDTO);//copy对象的属性
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        task.setState("处理中");
        String inspectionName = "";//单位名字
        String attribution = "";//归属地
        for (TaskInspectionInfo taskInspectionInfo : taskFourDTO.getInspectionUnitList()) {
            if (taskFourDTO.getInspectionUnitList().size() == 1){
                inspectionName += taskInspectionInfo.getInspectionUnit();
                attribution += taskInspectionInfo.getAttribution();
            }else{
                inspectionName += taskInspectionInfo.getInspectionUnit()+",";
                attribution += taskInspectionInfo.getAttribution()+",";
            }
        }
        task.setInspectionUnit(inspectionName);
        task.setAttribution(attribution);
        Result taskin = taskCrudService.add(task);
        for (TaskInspectionInfo taskInspectionInfo : taskFourDTO.getInspectionUnitList()) {
            taskInspectionInfo.setTaskId(task.getTaskId());
            taskInspectionInfoCrudService.add(taskInspectionInfo);
        }
        addTaskExpert("组员", taskFourDTO.getZuyuan(), task.getTaskId());
        addTaskExpert("组长", taskFourDTO.getZuzhang(), task.getTaskId());
        return taskin;
    }
    /**
     * 五科任务保存
     * @param
     */
    @Transactional
    public Result addFive(TaskFiveDTO taskFiveDTO) {
        Task task = new Task();
        try {
            BeanUtils.copyProperties(task, taskFiveDTO);//copy对象的属性
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        task.setState("处理中");
        Result taskin = taskCrudService.add(task);
        if (taskFiveDTO.getZuyuan() != null) {
            for (InspectionGroup inspectionGroup : taskFiveDTO.getZuyuan()) {
                inspectionGroup.setTaskId(task.getTaskId());
                inspectionGroup.setCategory(inspectionGroup.getCategory());
                inspectionGroup.setCategoryTwo(inspectionGroup.getCategory());
                inspectionGroupCrudService.add(inspectionGroup);
            }
        }
        return taskin;
    }

    /**
     * 一科任务保存
     *
     * @param taskOneDTO
     */
    @Transactional
    public Result addOne(TaskOneDTO taskOneDTO) {
        Task task = new Task();
        try {
            BeanUtils.copyProperties(task, taskOneDTO);//copy对象的属性
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
       // taskOneDTO.get
        task.setState("处理中");
        Result taskin = taskCrudService.add(task);
        addTaskExpert("临床", taskOneDTO.getLinchuang(), task.getTaskId());
        return taskin;
    }

    @Transactional
    public String addTaskExpert(String cateaory, List<InspectionGroup> taskTwoDTOList, int taskId) {
        if (taskTwoDTOList != null) {
            for (InspectionGroup inspectionGroup : taskTwoDTOList) {
                inspectionGroup.setTaskId(taskId);
                inspectionGroup.setCategoryTwo("无");
                inspectionGroup.setCategory(cateaory);

                inspectionGroupCrudService.add(inspectionGroup);
            }
        }
        return "";
    }
    public String addTaskTwoExpert(String cateaory, List<InspectionGroup> taskTwoDTOList, int taskId) {
        if (taskTwoDTOList != null) {
            for (InspectionGroup inspectionGroup : taskTwoDTOList) {
                inspectionGroup.setTaskId(taskId);
                inspectionGroup.setCategoryTwo(inspectionGroup.getCategory());
                inspectionGroup.setCategory(cateaory);
                inspectionGroupCrudService.add(inspectionGroup);
            }
        }
        return "";
    }

    /**
     * 二科人员全面生成
     *
     * @param taskId
     * @return
     */
    @Transactional
    public List<Experts> selectTwoGroup(int taskId) throws Exception {
        return taskUtilService.selectGroupDetail(taskId, "", "one");
    }

    /*
     * 显示传入taskId的专家列表
     * @param taskId
     * @return
     */
    public List<ExpertsDTO> getTaskIdReturnExperts(int taskId) {
        List<ExpertsDTO> expertsDTOlist = new ArrayList<ExpertsDTO>();
        List<GroupExperts> groupExpertsList = groupExpertsCrudService.getByTaskId(taskId);
        if (groupExpertsList != null && groupExpertsList.size() != 0) {
            for (GroupExperts groupExperts : groupExpertsList) {
                Experts experts = expertsCrudService.get(groupExperts.getExpertsId());
                ExpertsDTO expertsDTO = new ExpertsDTO();
                if (experts != null) {
                    try {
                        BeanUtils.copyProperties(expertsDTO, experts);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    expertsDTO.setState(groupExperts.getState());
                    //获取各科室的更换理由
                    expertsDTO.setReason(taskUpdateLogCrudService.selectTaskIdAndExpertsId(taskId, expertsDTO.getExpertsId()));
                    expertsDTOlist.add(expertsDTO);
                }
            }
        }
        //taskUpdateLogCrudService.query
        return expertsDTOlist;
    }

    @Transactional
    public int changeExperts(TaskChangeDTO taskChangeDTO, String creatUser) {
        Task task = new Task();
        task.setTaskId(taskChangeDTO.getTaskId());
        task.setState("变更中");
        taskCrudService.update(task);
        System.out.print(taskChangeDTO.getTaskId());
        for (TaskTowChage taskTowChage : taskChangeDTO.getExpertsIdList()) {
            //创建更换日志
            TaskUpdateLog taskUpdateLog = new TaskUpdateLog();
            taskUpdateLog.setCreateUser(creatUser);
            taskUpdateLog.setReason(taskTowChage.getReason());
            taskUpdateLog.setTaskId(taskChangeDTO.getTaskId());//taskId
            taskUpdateLog.setExpertsId(taskTowChage.getId());//expertsId
            taskUpdateLogCrudService.add(taskUpdateLog);
            GroupExperts groupExperts = groupExpertsCrudService.selectByTaskIdAndExpertsId(taskChangeDTO.getTaskId(), taskTowChage.getId());
            groupExperts.setState("待确认");
            groupExpertsCrudService.update(groupExperts);
        }
        return 1;
    }


//    /**
//     * 二科
//     * 根据taskId和expertsId查询出一条人员删除从新生成一个人员
//     *
//     * @param taskId
//     * @param expertsId
//     * @param reason
//     * @return
//     */
//    // TODO: 2016/10/21   修改变更条件
//    @Transactional
//    public ExpertsDTO selectTwoGroupOne(int taskId, int expertsId, String reason) {
//        return taskUtilService.selectGroupOneDetail(taskId, expertsId, reason, "two");//出问题返回一个空
//    }

    /**
     * 在质量科确认专家列表之后,根据taskId查出要检查的单位和检查时间还有检查人的手机号
     * @param taskId
     * @return
     */
    @Transactional
    public int expertsForMessage(int taskId , int id) throws ParseException {
        Task task = taskCrudService.get(taskId);
        String inspectionUnit = task.getInspectionUnit();//被检单位
        String startExecutionTime = task.getStartExecutionTime();//检查时间
        String endExecutionTime = task.getEndExecutionTime();//检车结束时间
        DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        List<GroupExperts> groupExperts = groupExpertsCrudService.getByTaskId(taskId);
        // TODO: 2016/11/30 查询出所有人进行短信通知 要钱
        //查询出所有人 发送短信通知
        for (GroupExperts groupExpert:groupExperts ) {
           Experts experts = expertsCrudService.get(groupExpert.getExpertsId());
            // 电话号码字符串，中间用英文逗号间隔
            //StringBuffer mobileString=new StringBuffer(experts.getPhone());
            StringBuffer mobileString=new StringBuffer(experts.getPhone().trim().substring(0,11));
            // 内容字符串
                StringBuffer contextString=new StringBuffer("黑龙江省食品药品审核查验中心提醒您，请您在检查期间严格遵守以下廉政要求：\n" +
                    "一、不准收受被认证、检查、核查单位的现金、有价证券、支付凭证及礼品。不准违反原则及认证、检查、核查标准，将不具备条件的单位通过认证、检查及核查。\n" +
                    "二、严格遵守承诺制、公示制、组长负责制和食品药品认证、检查及核查纪律要求；严格落实食品药品认证、检查及核查方案；严格执行食品药品认证、检查及核查标准。\n" +
                    "三、认证、检查及核查要细致；记录要详实；评价要公正；现场认证、检查及核查情况反映要客观。\n" +
                    "四、严禁参加由地方局或行政相对人组织的宴请、娱乐健身和旅游等及其他可能影响执行公务的活动；严禁在认证、检查及核查期间饮酒；严禁向被检单位提出与工作无关的额外要求、泄露被检单位商业秘密和其他应保密的工作秘密；严禁接受超标准住宿和在被检单位报销应由个人支付的费用。严禁利用认证、检查及核查权，吃、拿、卡、要，刁难、粗暴对待被认证、检查及核查的行政相对人。\n" +
                    "五、文明礼貌，热情服务，谦虚谨慎，不骄不躁，仪容整洁。\n" +
                    "中心纪委联系人：尹大志，电话：0451-51983680\n");


            StringBuffer contextString1=new StringBuffer(experts.getName()+"检查员：\n"+
                    "您好! 黑龙江省食品药品审核查验中心拟邀请您于"+startExecutionTime+"至"+endExecutionTime+"期间参加"+inspectionUnit+"检查工作，检查工作地点："+task.getAttribution()+"。请您在收到信息后一个小时内给予回复是否能够参加检查。\n"+
                    "如您能参加本次检查工作，请遵守以下两点要求：\n"+
                    "一、购买车票、住宿应严格使用公务卡结算，并将刷卡存根和消费票据一同寄到省中心。\n"+
                    "二、请您于"+startExecutionTime+"8:00前到达指定工作地点。如需召开检查前工作动员会，另行通知。\n"+
                    "联系人：任春晓，电话：0451-51983683\n");

            //StringBuffer contextString=new StringBuffer("尊敬的"+experts.getName()+",请您在"+startExecutionTime+"到达"+inspectionUnit+"进行检查");
            // 签名
            String sign="审核查验中心";
            // 追加发送时间，可为空，为空为及时发送
            String stime="";
            // 扩展码，必须为数字 可为空
            StringBuffer extno=new StringBuffer();
            try {
                if (id == 0){
                    String messageState= MessageUtil.doPost(mobileString, contextString, sign, stime, extno);//调用发送短信方法
                }else{
                    String messageState= MessageUtil.doPost(mobileString, contextString1, sign, stime, extno);//调用发送短信方法
                }

            } catch (Exception e) {
                System.out.print("请检查短信功能是否欠费!!!!");
                e.printStackTrace();
            }
        }
        return taskId;
    }



    @Transactional
    public TaskQueryNumberDTO queryTaskProcessing() {
        TaskQueryNumberDTO taskQueryNumberDTO  = new TaskQueryNumberDTO();
        //处理中
        int processing = taskCrudService.queryTaskProcessing();
        int generate = taskCrudService.queryTaskGenerate();
        int change = taskCrudService.queryTaskChange();
        taskQueryNumberDTO.setChange(change);
        taskQueryNumberDTO.setGenerate(generate);
        taskQueryNumberDTO.setProcessing(processing);
        return taskQueryNumberDTO;
    }


    public Page<ExpertsTaskDTO> queryExpertsTask(int pageNum, String q, String asc, String desc, String source) {
        return groupExpertsCrudService.queryExpertsTask(pageNum, q, asc, desc, source);
    }

    public List<Experts> FreqAvoidance(String source, int times) {
        SelectProviderDTO selectProviderDTO = new SelectProviderDTO();
        selectProviderDTO.setSource(source);
        selectProviderDTO.setTimes(times);
        return taskMapperExt.FreqAvoidance(selectProviderDTO);

    }

    /**
     * 六科任务保存
     * @param
     * @return
     */
    @Transactional
    public Result addsix(TaskSixDTO taskSixDTO) {
        Task task = new Task();
        try {
            BeanUtils.copyProperties(task, taskSixDTO);//copy对象的属性
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        task.setState("处理中");
        Result taskin = taskCrudService.add(task);
        if (taskSixDTO.getZyzz() != null) {
            for (InspectionGroup inspectionGroup : taskSixDTO.getZyzz()) {
                inspectionGroup.setTaskId(task.getTaskId());
                inspectionGroup.setCategoryTwo(inspectionGroup.getCategory());
                inspectionGroup.setCategory("中药制剂");
                inspectionGroupCrudService.add(inspectionGroup);
            }
        }
        if (taskSixDTO.getHyzj() != null) {
            for (InspectionGroup inspectionGroup : taskSixDTO.getHyzj()) {
                inspectionGroup.setTaskId(task.getTaskId());
                inspectionGroup.setCategoryTwo(inspectionGroup.getCategory());
                inspectionGroup.setCategory("化药制剂");
                inspectionGroupCrudService.add(inspectionGroup);
            }
        }
        return taskin;

    }
    @Transactional
    public Result addseven(TaskDTO taskDTO) {
        Task task = new Task();
        try {
            BeanUtils.copyProperties(task, taskDTO);//copy对象的属性
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        task.setState("处理中");
        //
        String inspectionName = "";//单位名字
        String attribution = "";//归属地
        for (TaskInspectionInfo taskInspectionInfo : taskDTO.getInspectionUnitList()) {
            if (taskDTO.getInspectionUnitList().size() == 1){
                inspectionName += taskInspectionInfo.getInspectionUnit();
                attribution += taskInspectionInfo.getAttribution();
            }else{
                inspectionName += taskInspectionInfo.getInspectionUnit()+",";
                attribution += taskInspectionInfo.getAttribution()+",";
            }
        }
        task.setInspectionUnit(inspectionName);
        task.setAttribution(attribution);
        Result taskin = taskCrudService.add(task);
        for (TaskInspectionInfo taskInspectionInfo : taskDTO.getInspectionUnitList()) {
            taskInspectionInfo.setTaskId(task.getTaskId());
            taskInspectionInfoCrudService.add(taskInspectionInfo);
        }

        if (taskDTO.getGroupList() != null) {
            for (InspectionGroup inspectionGroup : taskDTO.getGroupList()) {
                inspectionGroup.setTaskId(task.getTaskId());
                inspectionGroup.setCategoryTwo("无");
                inspectionGroupCrudService.add(inspectionGroup);
            }
            //添加一个检查组长想
            InspectionGroup inspectionGroup = new InspectionGroup();
            inspectionGroup.setCategory("检查组长");
            inspectionGroup.setCategoryTwo("无");
            inspectionGroup.setNum(taskDTO.getLeaderNum());
            inspectionGroup.setTaskId(task.getTaskId());
            inspectionGroupCrudService.add(inspectionGroup);
        }
        return taskin;
    }
}
