package com.xzit.ssm.entity;

public class Checkmessage {
    private Integer id;

    private Integer xyid;

    private Integer kcid;

    private String kclx;

    private String msg;

    private String handle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXyid() {
        return xyid;
    }

    public void setXyid(Integer xyid) {
        this.xyid = xyid;
    }

    public Integer getKcid() {
        return kcid;
    }

    public void setKcid(Integer kcid) {
        this.kcid = kcid;
    }

    public String getKclx() {
        return kclx;
    }

    public void setKclx(String kclx) {
        this.kclx = kclx == null ? null : kclx.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle == null ? null : handle.trim();
    }
}