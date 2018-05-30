package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.ExpertsLog;
import com.medicineCenter.service.ExpertsLogCrudService;
import com.medicineCenter.util.ObjectNullCheck;
import com.medicineCenter.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;

/**
* Created by song.
*/
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/expertslog")
public class ExpertsLogCrudController extends BaseController {

    @Resource
    ExpertsLogCrudService expertslogCrudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ExpertsLog view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(ExpertsLog.class, expertslogCrudService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody ExpertsLog expertslog, HttpServletRequest request/*,Model model*/){
        Result result = expertslogCrudService.add(expertslog);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody ExpertsLog expertslog, HttpServletRequest request/*,Model model*/){
        expertslog.setExpertsLogId(id);
        int result = expertslogCrudService.update(expertslog);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody ExpertsLog expertslog, HttpServletRequest request/*,Model model*/){
        expertslog.setExpertsLogId(id);
        int result = expertslogCrudService.delete(expertslog);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<ExpertsLog> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return expertslogCrudService.getList(pageNum, q, asc, desc);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "expertslog/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "expertslog/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "expertslog/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "expertslog/list";
    }
}
