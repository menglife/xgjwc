package com.xzit.ssm.excel;

/**
 * create by hjx on 2018/11/9 0009
 */
public class StringUtils {
    //将字符串转为整型
    public static int str2int(String str){
        str = str!=null?str:"-1";
        int result = -1;
        try{
            result = Integer.parseInt(str);
        }catch (NumberFormatException ex){
            //ex.printStackTrace();
        }
        return result;
    }

    //将字符串转为浮点数
    public static float str2float(String str){
        str = str!=null?str:"-1.0";
        float result = -1.0f;
        try{
            result = Float.parseFloat(str);
        }catch (NumberFormatException ex){
            //ex.printStackTrace();
        }
        return result;
    }

    //去掉首尾空格
    public static String trim(String str){
        str = str!=null?str:"";
        String result = "";
        if(str!=null){
            result = str.trim();
        }
        return result;
    }

    //删除（，(,),）等字符
    public static String chinese(String str){
        str = str!=null?str:"";
        String reg = "[^\u4e00-\u9fa5]";
        str = str.replaceAll(reg, "");
        return str;
    }

}
