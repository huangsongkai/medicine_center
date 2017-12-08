package com.medicineCenter.interfaces.controller;

import com.medicineCenter.util.ObjectNullCheck;
import com.medicineCenter.util.PageUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by song on 16/7/22.
 */
public class BaseController {
    protected final Logger logger = Logger.getLogger(this.getClass());
    protected final int PAGE_SIZE = PageUtil.PAGE_SIZE;
    protected <E> Result<E> newFaildResult(String message) {
        return newResult(-1, message, null);
    }

    protected <E> Result<E> newSuccessResult(String message, E data) {
        return newResult(1, message, data);
    }

    protected <E> Result<E> newResult(int status, String message, E data){
        Result<E> result = new Result<E>();
        result.setStatus(status);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /*@RequestMapping(value = "/default", method = RequestMethod.POST)
    @ResponseBody
    protected Result add(){
        return null;
    }
    @RequestMapping(value = "/default", method = RequestMethod.PUT)
    @ResponseBody
    protected Result update(){
        return null;
    }

    @RequestMapping(value = "/default", method = RequestMethod.DELETE)
    @ResponseBody
    protected Result delete(){
        return null;
    }*/

    protected String safeGetUserId(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        Object userId = httpSession.getAttribute("userId");
        if(userId == null)
            return null;
        return userId.toString();
    }


    protected CheckResult checkFormAndGetUserId(HttpServletRequest request, Object o){
        CheckResult checkResult = new CheckResult();
        checkResult.setState(false);
        if(ObjectNullCheck.check(o)){
            checkResult.setMsg("非法操作");
            return checkResult;
        }
        String userId = safeGetUserId(request);
        if(userId == null) {
            checkResult.setMsg("未登录");
            return checkResult;
        }
        checkResult.setState(true);
        checkResult.setUserId(userId);
        return checkResult;
    }

    protected class CheckResult {
        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Boolean getState() {
            return state;
        }

        public void setState(Boolean state) {
            this.state = state;
        }
        public String getUserId() {
            return UserId;
        }

        public void setUserId(String userId) {
            UserId = userId;
        }

        Boolean state;
        String msg;
        String UserId;
    }
}
