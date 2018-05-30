package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dataObject.Task;
import com.medicineCenter.model.dto.ExpertsDTO;
import com.medicineCenter.model.dto.TaskChangeDTO;
import com.medicineCenter.model.dto.TaskDTO;
import com.medicineCenter.service.ExpertsCrudService;
import com.medicineCenter.service.TaskCrudService;
import com.medicineCenter.service.TaskService;
import com.medicineCenter.util.ObjectNullCheck;
import com.medicineCenter.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.List;

/**
* Created by song.
*/
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/d3")
public class D3Controller extends BaseController {
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
     */
    @RequestMapping(value = "/task/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Task> viewList(@PathVariable int pageNum, String q, String asc, String desc, String state){
        if(q!=null)
           q = URLDecoder.decode(q);
        if(state!=null)
           state = URLDecoder.decode(state);
        return taskCrudService.getList(pageNum, q, asc, desc,"三科",state);
    }

    /**
     * 修改任务
     * @param taskId
     * @param taskDTO
     * @param request
     * @return
     */
    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable int taskId, @RequestBody TaskDTO taskDTO, HttpServletRequest request/*,Model model*/){
        taskDTO.setTaskId(taskId);
        Result result =  taskService.update(taskDTO);
        //  int result = taskCrudService.update(task);
        return result;
    }
    /**
     * 保存任务
     * @param taskDTO
     * @param request
     * @return
     */
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody TaskDTO taskDTO, HttpServletRequest request/*,Model model*/){
        taskDTO.setAttribution(taskDTO.getInspectionUnitList().get(0).getAttribution());
        taskDTO.setInspectionUnit(taskDTO.getInspectionUnitList().get(0).getInspectionUnit());
        Result result = taskService.add(taskDTO);
        // taskCrudService.add(taskDTO);
        return result;
    }

    /**
     * 取消任务
     * @param taskId
     * @param
     * @param request
     * @return Result
     */
    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable int taskId,  HttpServletRequest request/*,Model model*/){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskId(taskId);
        int result = taskService.DeleteOrUpdate(taskDTO);
        return newResult(result, "取消成功", null);
    }
    /**
     * 根据id显示一条任务 条件查询
     * @param taskId
     * @param request
     * @return
     */
    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET)
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
    /*在
     * 根据taskid和 experts发出一个更换专家的请求
     * @param request
     * @return
     */
    @RequestMapping(value = "/task/change", method = RequestMethod.PUT)
    @ResponseBody
    public Result changeExperts(@RequestBody TaskChangeDTO taskChangeList, HttpServletRequest request/*,Model model*/){
        String userName = (String) request.getSession().getAttribute("userName");
        int result = taskService.changeExperts(taskChangeList, userName);
       // List<Experts> experts =  taskService.getTaskIdReturnExperts(taskId);
        return newResult(result, "变更申请发出成功", null);
    }
    //------------------------------------------------------------------------------------------------------------
    // TODO: 2016/10/30  最后的条件没写完
    /**
     * 查看全部专家
     * @param
     * @param request
     * @return
     */
    @RequestMapping(value = "/experts/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Experts> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return expertsCrudService.getExperts(pageNum, q, asc, desc,"三科");
    }

    /**
     * 保存专家列表
     * @param experts
     * @param request
     * @return
     */
    @RequestMapping(value = "/experts", method = RequestMethod.POST)
    @ResponseBody
    public Result createExpert(@RequestBody Experts experts, HttpServletRequest request/*,Model model*/){
        experts.setCategoryTwo("无");
        String userName =  (String)request.getSession().getAttribute("userName");//查询出操作人
        Result result = expertsCrudService.add(experts, userName);
        return result;
    }

    /**
     * 查询一条
     * @return
     */
    @RequestMapping(value = "/experts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Experts view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(Experts.class, expertsCrudService.get(id));
    }

    /**
     * 修改一条
     * @param id
     * @param experts
     * @param request
     * @return
     */
    @RequestMapping(value = "/experts/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody Experts experts, HttpServletRequest request/*,Model model*/) throws InvocationTargetException, IllegalAccessException {
        experts.setExpertsId(id);
        experts.setCategoryTwo("无");
        int result = expertsCrudService.update(experts);
        String userName = request.getSession().getAttribute("userName") + "";
        int result1 = expertsCrudService.updateForLog(experts,userName);
        return newResult(result, "", null);
    }

    /**
     * 删除一条
     * @param id
     * @param experts
     * @param request
     * @return
     */
    @RequestMapping(value = "/experts/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody Experts experts, HttpServletRequest request/*,Model model*/){
        experts.setExpertsId(id);
        String userName =  (String)request.getSession().getAttribute("userName");//查询出操作人
        int result = expertsCrudService.delete(experts, userName);
        return newResult(result, "", null);
    }

//---------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/experts/list", method = RequestMethod.GET)
    public String redirectListExperts(){
return "taskd3/listExperts";
}

    @RequestMapping(value = "/experts/add", method = RequestMethod.GET)
    public String redirectAddExpert(){
        return "taskd3/addExperts";
    }

    @RequestMapping(value = "/experts/edit/{id}", method = RequestMethod.GET)
    public String redirectEditExpert(){
        return "taskd3/editExperts";
    }

    @RequestMapping(value = "/task/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "taskd3/add";
    }
    @RequestMapping(value = "/task/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "taskd3/edit";
    }
    @RequestMapping(value = "/task/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "taskd3/delete";
    }
    @RequestMapping(value = "/task/list", method = RequestMethod.GET)
    public String redirectList(){
        return "taskd3/list";
    }
}




