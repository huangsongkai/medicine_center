package com.medicineCenter.interfaces.controller;

import org.apache.log4j.Logger;

/**
 * Created by huang on 2016/12/28.
 */
public class NotEnoughException extends Exception {
    protected final Logger logger = Logger.getLogger(this.getClass());
    public NotEnoughException(String msg)
    {

        super(msg);
        logger.info(msg);
    }
}
