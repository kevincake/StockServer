package com.ifreedom.beauty.util;

import java.io.UnsupportedEncodingException;

/**
 * @atuhor:eavawu
 * @date:06/12/2016
 * @todo:
 */
public class CharacterEncodeConverter {

    public static String convertGBK2UTF8(String gbk)  {
        String iso = null;
        try {
            iso = new String(gbk.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            return new String(iso.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
