package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.ExpertsUpLog;
import com.medicineCenter.service.ExpertsUpLogCrudService;
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
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/expertsuplog")
public class ExpertsUpLogCrudController extends BaseController {

    @Resource
    ExpertsUpLogCrudService expertsuplogCrudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ExpertsUpLog view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(ExpertsUpLog.class, expertsuplogCrudService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody ExpertsUpLog expertsuplog, HttpServletRequest request/*,Model model*/){
        Result result = expertsuplogCrudService.add(expertsuplog);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody ExpertsUpLog expertsuplog, HttpServletRequest request/*,Model model*/){
        expertsuplog.setId(id);
        int result = expertsuplogCrudService.update(expertsuplog);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody ExpertsUpLog expertsuplog, HttpServletRequest request/*,Model model*/){
        expertsuplog.setId(id);
        int result = expertsuplogCrudService.delete(expertsuplog);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<ExpertsUpLog> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return expertsuplogCrudService.getList(pageNum, q, asc, desc);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "expertsuplog/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "expertsuplog/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "expertsuplog/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "expertsuplog/list";
    }
}
