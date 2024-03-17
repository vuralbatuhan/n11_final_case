package com.example.n11_final_case.util;

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
