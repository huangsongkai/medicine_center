package com.medicineCenter.infrastructure.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by song on 16/8/5.
 */
public class D1Interceptor extends HandlerInterceptorAdapter {
    protected final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String department =  (String)request.getSession().getAttribute("department");
        if(department == null){
            response.sendRedirect("/login");
            return false;
        }
        if(!department.equals("一科")){
            logger.info("无访问权限");
            response.sendRedirect("/static/errors/403.html");
            return false;
        }else
            return true;
    }
}
