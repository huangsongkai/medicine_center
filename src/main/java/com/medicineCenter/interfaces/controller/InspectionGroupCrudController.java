package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.InspectionGroup;
import com.medicineCenter.service.InspectionGroupCrudService;
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
@RequestMapping("/inspectiongroup")
public class InspectionGroupCrudController extends BaseController {

    @Resource
    InspectionGroupCrudService inspectiongroupCrudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public InspectionGroup view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(InspectionGroup.class, inspectiongroupCrudService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody InspectionGroup inspectiongroup, HttpServletRequest request/*,Model model*/){
        Result result = inspectiongroupCrudService.add(inspectiongroup);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody InspectionGroup inspectiongroup, HttpServletRequest request/*,Model model*/){
        inspectiongroup.setGroupId(id);
        int result = inspectiongroupCrudService.update(inspectiongroup);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody InspectionGroup inspectiongroup, HttpServletRequest request/*,Model model*/){
        inspectiongroup.setGroupId(id);
        int result = inspectiongroupCrudService.delete(inspectiongroup);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<InspectionGroup> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return inspectiongroupCrudService.getList(pageNum, q, asc, desc);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "inspectiongroup/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "inspectiongroup/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "inspectiongroup/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "inspectiongroup/list";
    }
}
