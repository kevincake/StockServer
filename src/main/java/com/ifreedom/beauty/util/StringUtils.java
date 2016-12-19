package com.ifreedom.beauty.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 创建者:yin_zeping
 * 创建时间:2016/3/1 14:22
 * 功能说明:
 */
public class StringUtils {
    //用正则表达式判断字符串是否为数字（含负数）
    public static boolean isNumeric(String str) {
        String regEx = "^-?[0-9]+$";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(str);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isPhone(String phone) {
        if (isEmpty(phone)) {
            return false;
        }
        boolean matches = phone.matches("(^(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7})$");
        return matches;
    }


    public static boolean isContainCode(String number) {
        if (number == null) {
            return false;
        }
        boolean b = number.startsWith("+86");
        return b;
    }

    public static String getPhoneFromCountyPhoneNum(String number) {
        if (isContainCode(number)) {
            StringBuffer buffer = new StringBuffer(number);
            String result = buffer.substring(3, number.length()).trim();
            return result;
        }
        return "";
    }

    public static boolean isPwdValid(String pwd) {
        if (isEmpty(pwd)) return false;
        if (pwd.length() < 6) return false;
        return true;
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static String getInParamByIds(List<Long> ids) {
        String result = "";
        for (int i=0;i<ids.size();i++){
            String s = ids.size() - 1 == i ? "" : ",";
            result = result+ids.get(i)+s;
        }
        return result;

    }

    public static String getHighPriceStr(String dayStr,double price){
        return String.format(PropertyUtil.getProperty("ma_high"),dayStr,price);
    }
    public static String getLowPriceStr(String dayStr,double price){
        return String.format(PropertyUtil.getProperty("ma_low"),dayStr,price);
    }


}
