package com.medicineCenter.util;

import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ObjectUtil {
    /*
     * 1.null == null
     * 2.null != Object
     * 3.object.equals(other) is true,return
     * true 4.compare all Fields
     */
    public static boolean equals(Object obj, Object other) {
        if (obj == null && other == null){
            return true;
        }

        if(obj != null && other == null){
            return false;
        }
        if(obj != null && other == null){
            return false;
        }

        return compareNotNull(obj,other);
    }
    //非空比较
    private static boolean compareNotNull(Object obj, Object other){
        if(obj.equals(other)){
            return true;
        }
        Class type = obj.getClass();
        if(type != other.getClass()){
            return false;
        }

        //简单类型
        if(ClassUtils.isPrimitiveOrWrapper(type)){
            return comparePrimitiveType(obj, other);
        }
        //数组
        if(type.isArray()){
            return compareArray(obj, other);
        }

        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field : fields){
            try {
                field.setAccessible(true);
                Object tmp1=field.get(obj);
                Object tmp2=field.get(other);
                if(!equals(tmp1, tmp2)){
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        }
        return true;
    }

    private static boolean comparePrimitiveType(Object obj, Object other){
        if(obj.getClass().isPrimitive()){
            return obj==other;
        }else{
            return obj.equals(other);
        }
    }

    private static boolean compareArray(Object obj, Object other) {
        int len = Array.getLength(obj);
        if (len != Array.getLength(other)){
            return false;
        }
        for(int i=0;i<len;i++){
            if(!equals(Array.get(obj, i), Array.get(other, i))){
                return false;
            }
        }
        return true;
    }
}