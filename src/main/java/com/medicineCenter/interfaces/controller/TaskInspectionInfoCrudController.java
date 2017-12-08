package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.TaskInspectionInfo;
import com.medicineCenter.service.TaskInspectionInfoCrudService;
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
@RequestMapping("/taskinspectioninfo")
public class TaskInspectionInfoCrudController extends BaseController {

    @Resource
    TaskInspectionInfoCrudService taskinspectioninfoCrudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TaskInspectionInfo view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(TaskInspectionInfo.class, taskinspectioninfoCrudService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody TaskInspectionInfo taskinspectioninfo, HttpServletRequest request/*,Model model*/){
        Result result = taskinspectioninfoCrudService.add(taskinspectioninfo);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody TaskInspectionInfo taskinspectioninfo, HttpServletRequest request/*,Model model*/){
        taskinspectioninfo.setId(id);
        int result = taskinspectioninfoCrudService.update(taskinspectioninfo);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody TaskInspectionInfo taskinspectioninfo, HttpServletRequest request/*,Model model*/){
        taskinspectioninfo.setId(id);
        int result = taskinspectioninfoCrudService.delete(taskinspectioninfo);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<TaskInspectionInfo> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return taskinspectioninfoCrudService.getList(pageNum, q, asc, desc);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "taskinspectioninfo/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "taskinspectioninfo/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "taskinspectioninfo/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "taskinspectioninfo/list";
    }
}
