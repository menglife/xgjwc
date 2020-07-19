package com.xzit.ssm.vo;

/**
 * create by hjx on 2018/12/13 0013
 */
public class TermGzlVo {
    private int xyid; //所属学院
    private int termid; //所属学期
    private String termname="";
    private float lljxgzl;
    private float sjjxgzl;
    private float kcsumgzl;
    private float othergzl;
    private float sumgzl;

    public int getXyid() {
        return xyid;
    }

    public void setXyid(int xyid) {
        this.xyid = xyid;
    }

    public int getTermid() {
        return termid;
    }

    public void setTermid(int termid) {
        this.termid = termid;
    }

    public String getTermname() {
        return termname;
    }

    public void setTermname(String termname) {
        this.termname = termname;
    }

    public float getLljxgzl() {
        return lljxgzl;
    }

    public void setLljxgzl(float lljxgzl) {
        this.lljxgzl = lljxgzl;
    }

    public float getSjjxgzl() {
        return sjjxgzl;
    }

    public void setSjjxgzl(float sjjxgzl) {
        this.sjjxgzl = sjjxgzl;
    }

    public float getKcsumgzl() {
        return kcsumgzl;
    }

    public void setKcsumgzl(float kcsumgzl) {
        this.kcsumgzl = kcsumgzl;
    }

    public float getOthergzl() {
        return othergzl;
    }

    public void setOthergzl(float othergzl) {
        this.othergzl = othergzl;
    }

    public float getSumgzl() {
        return kcsumgzl+othergzl;
    }

}
