package com.example.final_case_restaurant.util;

/*
 * @author batuhanvural
 */

import java.util.logging.Logger;

public class LoggerHandler {

    private static Logger logger;

    public static Logger getLogger() {
        logger = Logger.getLogger("LoggerHandler");
        return logger;
    }

}
