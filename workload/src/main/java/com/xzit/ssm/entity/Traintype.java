package com.xzit.ssm.entity;

public class Traintype {
    private Integer ptid;

    private String ptname;

    private Integer nvalue;

    private Float kvalue;

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public String getPtname() {
        return ptname;
    }

    public void setPtname(String ptname) {
        this.ptname = ptname == null ? null : ptname.trim();
    }

    public Integer getNvalue() {
        return nvalue;
    }

    public void setNvalue(Integer nvalue) {
        this.nvalue = nvalue;
    }

    public Float getKvalue() {
        return kvalue;
    }

    public void setKvalue(Float kvalue) {
        this.kvalue = kvalue;
    }
}