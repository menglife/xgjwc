package com.xzit.ssm.vo;

/**
 * create by hjx on 2018/11/15 0015
 */
public class RatioStuNumber {

    public static float ratio(String kclx2,int stunum){
        float r = 1.0f;
        if("艺术类课".equals(kclx2)){
            if(stunum<=30){
                r = 1.0f;
            }else if(stunum>30 && stunum<=60){
                r = 1.2f;
            }else if(stunum>60){
                r = 1.4f;
            }
        }else{
            if(stunum<=50){
                r = 1.0f;
            }else if(stunum>50 && stunum<=60){
                r = 1.1f;
            }else if(stunum>60 && stunum<=90){
                r = 1.2f;
            }else if(stunum>90 && stunum<=120){
                r = 1.4f;
            }else{
                r = 1.5f;
            }
        }
        return r;
    }
}
