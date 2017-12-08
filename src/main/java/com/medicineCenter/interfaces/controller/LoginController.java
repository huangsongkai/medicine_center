package com.medicineCenter.interfaces.controller;

/**
 * Created by song on 2016/10/28.
 */

import com.medicineCenter.model.dto.LoginDTO;
import com.medicineCenter.service.UserCrudService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class LoginController extends BaseController{
    @Resource
    UserCrudService userCrudService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirectLogin(){
        return "/user/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String redirectLogout(HttpServletRequest request){
        request.getSession().invalidate();
        return "/user/login";
    }

    @RequestMapping(value = "/login/submit", method = RequestMethod.POST)
    @ResponseBody
    public Result submit(@RequestBody LoginDTO loginDTO, HttpServletRequest request){
        Result result = userCrudService.checkLoginReturnDepartment(loginDTO.getUserName(), loginDTO.getPassWord());
        if(result.getStatus() > 0){
            request.getSession().setAttribute("userName", loginDTO.getUserName());
            request.getSession().setAttribute("department", (String)result.getData());
        }
        return result;
    }

}
