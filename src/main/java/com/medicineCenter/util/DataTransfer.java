package com.medicineCenter.util;

import com.google.gson.Gson;
import com.mchange.v2.beans.BeansUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 16/8/4.
 */
public class DataTransfer {
    public static String toJson(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static  <T, E> E toDestClass(T orig, Class<E> eClass){
        if(orig == null)
            return null;
        try {
            E e = eClass.newInstance();
            BeanUtils.copyProperties(e, orig);
            return e;
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T, E> List<E> toDestClassList(List<T> orig, Class<E> eClass){
        List<E> eList = new ArrayList<E>();
        for(T t : orig){
            eList.add(toDestClass(t, eClass));
        }
        return eList;
    }

}
