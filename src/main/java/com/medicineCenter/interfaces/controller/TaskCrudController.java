package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dto.TaskDTO;
import com.medicineCenter.model.dto.TaskTwoDTO;
import com.medicineCenter.service.TaskCrudService;
import com.medicineCenter.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* Created by song.
*/
@Controller
@RequestMapping("/task")
public class TaskCrudController extends BaseController {

    @Resource
    TaskCrudService taskCrudService;
    @Resource
    TaskService taskService;

// 二科 三科显示页面分开
// 1.任务列表页（分科显示）
// 2.添加任务，状态：
// 2.任务详情页，可以修改检查时间（其他属性再议），可以取消任务，如果当前任务状态是已经生成列表的，专家后面可以加复选框，提交专家变更请求。
// 3.


// 质量科
// 1.显示全部列表，可以根据任务状态筛选（optional）
// 2.任务详情页，判别任务状态，
// 2.1如果是新提交的，显示生成专家按钮，生成备选专家，状态变换至（生成待确认）；
// 2.2生成待确认状态，可以替换专家，最后确认，变为确认状态；
// 2.3变更状态的任务，专家列表中需要变更的专家条目显示变更按钮，进行依次更换后，确认，变更为确认状态。

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
     * 保存任务
     * @param taskDTO
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody TaskDTO taskDTO, HttpServletRequest request/*,Model model*/){
        Result result = taskService.add(taskDTO);
       // taskCrudService.add(taskDTO);
        return result;
    }

    /**
     * 修改任务
     * @param taskId
     * @param taskDTO
     * @param request
     * @return
     */
    @RequestMapping(value = "/{taskId}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable int taskId, @RequestBody TaskDTO taskDTO, HttpServletRequest request/*,Model model*/){
        taskDTO.setTaskId(taskId);
        Result result =  taskService.update(taskDTO);
      //  int result = taskCrudService.update(task);
        return result;
    }

    /**
     * 取消任务
     * @param taskId
     * @param
     * @param request
     * @return Result
     */
    @RequestMapping(value = "/{taskId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable int taskId, @RequestBody TaskDTO taskDTO, HttpServletRequest request/*,Model model*/){
        taskDTO.setTaskId(taskId);
        int result = taskService.DeleteOrUpdate(taskDTO);
        return newResult(result, "", null);
    }

    //-------------------------------------------------------------------------------------------------------------------------
    /**
     * 二科任务保存
     * @return
     */
    @RequestMapping(value = "two", method = RequestMethod.POST)
    @ResponseBody
    public Result createTwo(@RequestBody TaskTwoDTO taskTwoDTO, HttpServletRequest request/*,Model model*/){
        Result result = taskService.addTwo(taskTwoDTO);
        return result;
    }

    /**
     * 二科人员全面生成
     * @return
     */
    @RequestMapping(value = "/selectTwoGroup/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Experts> selectTwoGroup(@PathVariable int taskId, HttpServletRequest request/*,Model model*/) throws Exception {
        List<Experts> expertsList = taskService.selectTwoGroup(taskId);
        request.setAttribute("taskId",taskId);
        return expertsList;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "task/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "task/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "task/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "task/list";
    }
    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public String redirectAdd2(){
        return "task/add2";
    }

}




