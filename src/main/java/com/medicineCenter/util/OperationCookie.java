package com.medicineCenter.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 2016/12/21.
 */
public class OperationCookie {


    /**
     * 新建一个cookie
     * @param request
     * @param response
     * @param cookievalue
     * @return boolean
     */
    public static Boolean newCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookievalue) {
        Cookie cookie;
        cookie = new Cookie(cookieName, cookievalue);
        cookie.setPath("/");//使cookie在项目中都能使用
        response.addCookie(cookie);
        return true;
    }
    /**
     * 根据名字获取cookie
     * @param request
     * @param name cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }
    }
    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }


}
