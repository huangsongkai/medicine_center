package com.medicineCenter.util;

/**
 * Created by song on 16/7/26.
 */
public class PageUtil {
    public final static int PAGE_SIZE = 15;
    public static int getPageNum(int total, int size){
        int remainder = total%size;
        int totalPage = remainder ==0 ?total/size:total/size+1;
        return totalPage;
    }

    public static int getPageNum(int total){
        return getPageNum(total, PAGE_SIZE);
    }

    public static String genPaginationClause(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize;
        return  " LIMIT "+offset+","+pageSize;
    }

    public static String genPaginationClause(int pageNum) {
        return genPaginationClause(pageNum, PAGE_SIZE);
    }
}
