package com.medicineCenter.util;

import java.util.Random;

/**
 * Created by song on 16/9/20.
 */
public class RandomUtil {
    public static int genericOffset(int capacity){
        Random rand =new Random(/*System.currentTimeMillis()*/);
        return rand.nextInt(capacity);
    }
    public static void main(String args[]){
//        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//        for(int i = 0 ; i < 10000 ; i++){
//            Integer ran = RandomUtil.genericOffset(10);
//            Integer u = hashMap.get(ran);
//            System.out.println(u);
//            if(u == null){
//                hashMap.put(ran,1);
//            }else
//                hashMap.put(ran,u+1);
//        }
//        System.out.println(hashMap);
        System.out.println(RandomUtil.genericOffset(10));


    }
}

