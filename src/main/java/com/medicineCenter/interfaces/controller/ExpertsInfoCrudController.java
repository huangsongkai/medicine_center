package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.ExpertsInfo;
import com.medicineCenter.service.ExpertsInfoCrudService;
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
@RequestMapping("/expertsinfo")
public class ExpertsInfoCrudController extends BaseController {

    @Resource
    ExpertsInfoCrudService expertsinfoCrudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ExpertsInfo view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(ExpertsInfo.class, expertsinfoCrudService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody ExpertsInfo expertsinfo, HttpServletRequest request/*,Model model*/){
        Result result = expertsinfoCrudService.add(expertsinfo);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody ExpertsInfo expertsinfo, HttpServletRequest request/*,Model model*/){
        expertsinfo.setExpertsId(id);
        int result = expertsinfoCrudService.update(expertsinfo);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody ExpertsInfo expertsinfo, HttpServletRequest request/*,Model model*/){
        expertsinfo.setExpertsId(id);
        int result = expertsinfoCrudService.delete(expertsinfo);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<ExpertsInfo> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return expertsinfoCrudService.getList(pageNum, q, asc, desc);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "expertsinfo/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "expertsinfo/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "expertsinfo/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "expertsinfo/list";
    }
}
