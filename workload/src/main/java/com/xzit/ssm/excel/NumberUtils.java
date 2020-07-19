package com.xzit.ssm.excel;

/**
 * create by hjx on 2018/11/15 0015
 */
public class NumberUtils {
    public static float decimalwithtwo(float f){
        return  (float)(Math.round(f*100.0f))/100;
    }
}
