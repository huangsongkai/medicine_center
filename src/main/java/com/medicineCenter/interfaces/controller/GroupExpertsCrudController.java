package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.GroupExperts;
import com.medicineCenter.service.GroupExpertsCrudService;
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
@RequestMapping("/groupexperts")
public class GroupExpertsCrudController extends BaseController {

    @Resource
    GroupExpertsCrudService groupexpertsCrudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public GroupExperts view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(GroupExperts.class, groupexpertsCrudService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody GroupExperts groupexperts, HttpServletRequest request/*,Model model*/){
        Result result = groupexpertsCrudService.add(groupexperts);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody GroupExperts groupexperts, HttpServletRequest request/*,Model model*/){
        groupexperts.setId(id);
        int result = groupexpertsCrudService.update(groupexperts);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody GroupExperts groupexperts, HttpServletRequest request/*,Model model*/){
        groupexperts.setId(id);
        int result = groupexpertsCrudService.delete(groupexperts);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<GroupExperts> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return groupexpertsCrudService.getList(pageNum, q, asc, desc);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "groupexperts/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "groupexperts/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "groupexperts/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "groupexperts/list";
    }
}
