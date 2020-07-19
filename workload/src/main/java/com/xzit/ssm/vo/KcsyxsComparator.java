package com.xzit.ssm.vo;

import com.xzit.ssm.entity.Syworkload;

/**
 * create by hjx on 2018/11/26 0026
 */
public class KcsyxsComparator {
    private int sjxstotal; //课程总的实验学时
    private int fpxs;      //每批次的学时
    private Syworkload swl; //实验课程

    public int getSjxstotal() {
        return sjxstotal;
    }

    public void setSjxstotal(int sjxstotal) {
        this.sjxstotal = sjxstotal;
    }

    public int getFpxs() {
        return fpxs;
    }

    public void setFpxs(int fpxs) {
        this.fpxs = fpxs;
    }

    public Syworkload getSwl() {
        return swl;
    }

    public void setSwl(Syworkload swl) {
        this.swl = swl;
    }
}
