package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.ExpertsCdLog;
import com.medicineCenter.service.ExpertsCdLogCrudService;
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
@RequestMapping("/expertscdlog")
public class ExpertsCdLogCrudController extends BaseController {

    @Resource
    ExpertsCdLogCrudService expertscdlogCrudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ExpertsCdLog view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(ExpertsCdLog.class, expertscdlogCrudService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody ExpertsCdLog expertscdlog, HttpServletRequest request/*,Model model*/){
        Result result = expertscdlogCrudService.add(expertscdlog);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody ExpertsCdLog expertscdlog, HttpServletRequest request/*,Model model*/){
        expertscdlog.setId(id);
        int result = expertscdlogCrudService.update(expertscdlog);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody ExpertsCdLog expertscdlog, HttpServletRequest request/*,Model model*/){
        expertscdlog.setId(id);
        int result = expertscdlogCrudService.delete(expertscdlog);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<ExpertsCdLog> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return expertscdlogCrudService.getList(pageNum, q, asc, desc);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "expertscdlog/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "expertscdlog/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "expertscdlog/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "expertscdlog/list";
    }
}
