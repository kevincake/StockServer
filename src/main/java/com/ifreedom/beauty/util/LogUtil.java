package com.ifreedom.beauty.util;

/**
 * Created by eavawu on 4/28/16.
 */

public class LogUtil {
    private static boolean isShowLog = true;
    public static void info(String tag,String info){
        if (isShowLog){
            System.out.println(tag+":"+info);
        }
    }
    public static void error(String tag,String errinfo){
        if (isShowLog){
         System.err.println(tag+":"+errinfo);
        }
    }
}

