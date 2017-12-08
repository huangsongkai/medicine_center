package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.TaskUpdateLog;
import com.medicineCenter.service.TaskUpdateLogCrudService;
import com.medicineCenter.util.ObjectNullCheck;
import com.medicineCenter.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.URLDecoder;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
* Created by song.
*/
@Controller
@RequestMapping("/taskupdatelog")
public class TaskUpdateLogCrudController extends BaseController {

    @Resource
    TaskUpdateLogCrudService taskupdatelogCrudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TaskUpdateLog view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(TaskUpdateLog.class, taskupdatelogCrudService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody TaskUpdateLog taskupdatelog, HttpServletRequest request/*,Model model*/){
        Result result = taskupdatelogCrudService.add(taskupdatelog);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody TaskUpdateLog taskupdatelog, HttpServletRequest request/*,Model model*/){
        taskupdatelog.setId(id);
        int result = taskupdatelogCrudService.update(taskupdatelog);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody TaskUpdateLog taskupdatelog, HttpServletRequest request/*,Model model*/){
        taskupdatelog.setId(id);
        int result = taskupdatelogCrudService.delete(taskupdatelog);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<TaskUpdateLog> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return taskupdatelogCrudService.getList(pageNum, q, asc, desc);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "taskupdatelog/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "taskupdatelog/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "taskupdatelog/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "taskupdatelog/list";
    }
}
