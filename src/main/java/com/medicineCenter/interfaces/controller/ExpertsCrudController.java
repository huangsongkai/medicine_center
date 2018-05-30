package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.service.ExpertsCrudService;
import com.medicineCenter.util.ObjectNullCheck;
import com.medicineCenter.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;

/**
* Created by song.
*/
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/experts")
public class    ExpertsCrudController extends BaseController {

    @Resource
    ExpertsCrudService expertsCrudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Experts view(@PathVariable java.lang.Integer id, HttpServletRequest request/*,Model model*/){
       return ObjectNullCheck.getNonNullObject(Experts.class, expertsCrudService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result create(@RequestBody Experts experts, HttpServletRequest request/*,Model model*/){
        String userName =  (String)request.getSession().getAttribute("userName");//查询出操作人
        Result result = expertsCrudService.add(experts, userName);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable java.lang.Integer id, @RequestBody Experts experts, HttpServletRequest request/*,Model model*/) throws InvocationTargetException, IllegalAccessException {
        experts.setExpertsId(id);
        String userName = request.getSession().getAttribute("userName") + "";
        int result = expertsCrudService.updateForLog(experts,userName);

        return newResult(result, "", null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable java.lang.Integer id, @RequestBody Experts experts, HttpServletRequest request/*,Model model*/){
        experts.setExpertsId(id);
        String userName =  (String)request.getSession().getAttribute("userName");//查询出操作人
        int result = expertsCrudService.delete(experts, userName);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Experts> viewList(@PathVariable int pageNum, String q, String asc, String desc, HttpServletRequest request/*,Model model*/){
        if(q!=null)
            q = URLDecoder.decode(q);
        return expertsCrudService.getList(pageNum, q, asc, desc);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "experts/add";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String redirectEdit(){
        return "experts/edit";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "experts/delete";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirectList(){
        return "experts/list";
    }
}
