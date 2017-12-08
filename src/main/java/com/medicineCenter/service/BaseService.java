package com.medicineCenter.service;

import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.util.PageUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by song on 16/7/26.
 */
@Service
public abstract class BaseService {
    protected final Logger logger = Logger.getLogger(this.getClass());
    final int PAGE_SIZE = PageUtil.PAGE_SIZE;
    public int getTotalPage(){
        return 0;
    }
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



}
