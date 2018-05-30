package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.TaskLog;
import com.medicineCenter.model.dto.TaskLogDTO;
import com.medicineCenter.service.TaskLogCrudService;
import com.medicineCenter.util.ObjectNullCheck;
import com.medicineCenter.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by song.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/tasklog")
public class TaskLogCrudController extends BaseController {

    @Resource
    TaskLogCrudService tasklogCrudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TaskLog view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(TaskLog.class, tasklogCrudService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody TaskLog tasklog, HttpServletRequest request/*,Model model*/){
        Result result = tasklogCrudService.add(tasklog);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody TaskLog tasklog, HttpServletRequest request/*,Model model*/){
        tasklog.setId(id);
        int result = tasklogCrudService.update(tasklog);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody TaskLog tasklog, HttpServletRequest request/*,Model model*/){
        tasklog.setId(id);
        int result = tasklogCrudService.delete(tasklog);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<TaskLogDTO> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
       String source = null;
        if(q!=null)
            q = URLDecoder.decode(q);
        return tasklogCrudService.getList(source, pageNum, q, asc, desc);
    }
    @RequestMapping(value = "/list/{source}/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<TaskLogDTO> viewList(@PathVariable int pageNum, @PathVariable String source, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return tasklogCrudService.getList(source, pageNum, q, asc, desc);
    }
    @RequestMapping(value = "/taskId/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public List<TaskLogDTO> testDTO(@PathVariable int taskId){
        List<TaskLogDTO> taskLogList = tasklogCrudService.querytaskLogForTaskId(taskId);
        return taskLogList;

    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "taskLog/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "taskLog/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "taskLog/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "taskLog/list";
    }
    @RequestMapping(value = "/list/d1", method = RequestMethod.GET)
    public String redirectListD1(){
        return "taskLog/listD1";
    }
    @RequestMapping(value = "/list/d2", method = RequestMethod.GET)
    public String redirectListD2(){
        return "taskLog/listD2";
    }
    @RequestMapping(value = "/list/d3", method = RequestMethod.GET)
    public String redirectListD3(){
        return "taskLog/listD3";
    }
    @RequestMapping(value = "/list/d4", method = RequestMethod.GET)
    public String redirectListD4(){
        return "taskLog/listD4";
    }
    @RequestMapping(value = "/list/d5", method = RequestMethod.GET)
    public String redirectListD5(){
        return "taskLog/listD5";
    }
    @RequestMapping(value = "/list/d6", method = RequestMethod.GET)
    public String redirectListD6(){
        return "taskLog/listD6";
    }
    @RequestMapping(value = "/list/d7", method = RequestMethod.GET)
    public String redirectListD7(){
        return "taskLog/listD7";
    }
}

