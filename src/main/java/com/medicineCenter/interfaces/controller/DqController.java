package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dataObject.Task;
import com.medicineCenter.model.dto.*;
import com.medicineCenter.service.ExpertsCrudService;
import com.medicineCenter.service.TaskCrudService;
import com.medicineCenter.service.TaskService;
import com.medicineCenter.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.List;

/**
* Created by song.
*/
@Controller
@RequestMapping("/dq")
public class DqController extends BaseController {
    @Resource
    TaskCrudService taskCrudService;
    @Resource
    TaskService taskService;
    @Resource
    TaskCrudController taskCrudController;
    @Resource
    ExpertsCrudService expertsCrudService;


    /**
     * 显示全部任务
     * @param pageNum
     * @param q
     * @param asc
     * @param desc
     * @return
     */
    @RequestMapping(value = "/task/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Task> viewList(@PathVariable int pageNum, String q, String asc, String desc , String state){
        if(q != null)
            q = URLDecoder.decode(q);
        return taskCrudService.getList(pageNum, q, asc, desc, "质量科", state);
    }


    /**
     * 分科室显示任务
     * @param pageNum
     * @param q
     * @param asc
     * @param desc
     * @return
     * http://localhost:8082/dq/task/list/d1/1
     */
    @RequestMapping(value = "/task/list/{keShi}/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Task> viewList1(@PathVariable String keShi, @PathVariable int pageNum, String q, String asc, String desc , String state){
        if(q != null)
            q = URLDecoder.decode(q);
        if("d1".equals(keShi)){
            return taskCrudService.getList(pageNum, q, asc, desc,"一科",state);
        }
        if("d2".equals(keShi)){
            return taskCrudService.getList(pageNum, q, asc, desc,"二科",state);
        }
        if("d3".equals(keShi)){
            return taskCrudService.getList(pageNum, q, asc, desc,"三科",state);
        }
        if("d4".equals(keShi)){
            return taskCrudService.getList(pageNum, q, asc, desc,"四科",state);
        }
        if("d5".equals(keShi)){
            return taskCrudService.getList(pageNum, q, asc, desc,"五科",state);
        }
        if("d6".equals(keShi)){
            return taskCrudService.getList(pageNum, q, asc, desc,"六科",state);
        }
        if("d7".equals(keShi)){
            return taskCrudService.getList(pageNum, q, asc, desc,"七科",state);
        }
        return taskCrudService.getList(pageNum, q, asc, desc, "质量科", state);
    }

    /**task
     * 三科检查人员生成(全)
     * @return
     *
     */
    @RequestMapping(value = "/selectGroup/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Experts> selectGroup(@PathVariable int taskId, String bacteria, HttpServletRequest request/*,Model model*/) throws ParseException {
        List<Experts> expertsList = null;
        try {
            expertsList = taskService.selectGroup(taskId, bacteria, "three");
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("taskId",taskId);
        return expertsList;
    }
    /**
     * 三科人员替换
     */
    @RequestMapping(value = "/selectGroupOne/{taskId}/{expertsId}", method = RequestMethod.POST)
    @ResponseBody
    public ExpertsDTO selectGroupOne(HttpServletRequest request, HttpServletResponse response, @RequestBody ReasonDTO reasonDTO, @PathVariable int expertsId, @PathVariable int taskId )  {
        String reason = "";
        if(reasonDTO.getReason() != null)
            reason = URLDecoder.decode(reasonDTO.getReason());
        String userName =  (String)request.getSession().getAttribute("userName");//查询出操作人
        ExpertsDTO experts= null;
        try {
            experts = taskService.selectGroupOne(userName, taskId, expertsId, reason, "three");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return experts;
    }

    /**
     * 二科人员替换
     */
    @RequestMapping(value = "/selectTwoGroupOne/{taskId}/{expertsId}", method = RequestMethod.POST)
    @ResponseBody
    public ExpertsDTO selectTwoGroupOne(HttpServletRequest request, HttpServletResponse response, @RequestBody ReasonDTO reasonDTO, @PathVariable int taskId, @PathVariable int expertsId  )  {
       String reason = "";
        if(reasonDTO.getReason() != null)
             reason = URLDecoder.decode(reasonDTO.getReason());
        String userName =  (String)request.getSession().getAttribute("userName");//查询出操作人
        ExpertsDTO experts= null;
        try {
            experts = taskService.selectGroupOne(userName, taskId,expertsId, reason, "two");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return experts;
    }
    /**
     * 二科人员全面生成
     * @return
     */
    @RequestMapping(value = "/selectTwoGroup/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Experts> selectTwoGroup(@PathVariable int taskId, HttpServletRequest request/*,Model model*/) throws Exception {
        List<Experts> expertsList = null;
        try {
            expertsList = taskService.selectGroup(taskId, "", "two");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //request.setAttribute("taskId",taskId);
        return expertsList;
    }
    /**
     * @param taskId
     * 确定任务专家组列表
     * @return
     */
    @RequestMapping(value = "/determineTask/{taskId}", method = RequestMethod.PUT)
    @ResponseBody
    public  Result determineTask (@PathVariable int taskId) throws Exception {
        int task = taskService.determineTask(taskId);
        return newResult(task, "专家组列表已经确定", null);
    }
    /**
     * 根据id显示一条任务 条件查询
     * @param taskId
     * @param request
     * @return
     */
    @RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public TaskDTO view(@PathVariable int taskId, HttpServletRequest request/*,Model model*/){
        TaskDTO taskDTO =  taskService.getTaskIdReturnTaskDTO(taskId);
        return taskDTO;
    }

    /**
     * 根据taskId显示专家列表
     * @param taskId
     * @param request
     * @return
     */
    @RequestMapping(value = "/task/experts/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public List<ExpertsDTO> vieweExperts(@PathVariable int taskId, HttpServletRequest request/*,Model model*/){
        List<ExpertsDTO> experts =  taskService.getTaskIdReturnExperts(taskId);
        return experts;
    }

    /**
     * 质量科未完成任务查询
     * @return
     */
    @RequestMapping(value = "/queryTaskNumber", method = RequestMethod.GET)
    @ResponseBody
    public TaskQueryNumberDTO queryTaskNumber(){
        return taskService.queryTaskProcessing();
    }

    /**
     * 显示专家所有的任务记录
     * @return
     */
    @RequestMapping(value = "/queryExpertsTask/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<ExpertsTaskDTO> queryExpertsTask(@PathVariable int pageNum, String q, String asc, String desc ,String source){
        if(q != null)
            q = URLDecoder.decode(q);
        return taskService.queryExpertsTask(pageNum, q, asc, desc, source);
    }

    /**
     * 查看全部专家
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/experts/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Experts> viewList2(@PathVariable int pageNum, String q, String asc, String desc /*, HttpServletRequest request*//*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return expertsCrudService.getExperts(pageNum, q, asc, desc,null);
    }



    @RequestMapping(value = "/experts/list", method = RequestMethod.GET)
    public String redirectListExperts(){
        return "taskdq/listExperts";
    }
    @RequestMapping(value = "/task/list", method = RequestMethod.GET)
    public String redirectList(){
        return "taskdq/listTaskdq";
    }
    @RequestMapping(value = "/task/list/department/{department}", method = RequestMethod.GET)
    public String redirectList1(@PathVariable String department){
        return "taskdq/listTask"+department;
    }

    @RequestMapping(value = "/task/d2/{taskId}", method = RequestMethod.GET)
    public String listTask2(){
        return "taskdq/viewTask2";
    }
    @RequestMapping(value = "/task/d3/{taskId}", method = RequestMethod.GET)
    public String listTask3(){
        return "taskdq/viewTask3";
    }



    @RequestMapping(value = "/d2/listE", method = RequestMethod.GET)
    public String d2listexperts(){
        return "list/d2listExperts";
    }
    @RequestMapping(value = "/d3/listE", method = RequestMethod.GET)
    public String d3listexperts(){
        return "list/d3listExperts";
    }
    @RequestMapping(value = "/d4/listE", method = RequestMethod.GET)
    public String d4listexperts(){
        return "list/d4listExperts";
    }
    @RequestMapping(value = "/d5/listE", method = RequestMethod.GET)
    public String d5listexperts(){
        return "list/d5listExperts";
    }
    @RequestMapping(value = "/d6/listE", method = RequestMethod.GET)
    public String d6listexperts(){
        return "list/d6listExperts";
    }
    @RequestMapping(value = "/d7/listE", method = RequestMethod.GET)
    public String d7listexperts(){
        return "list/d7listExperts";
    }
}




