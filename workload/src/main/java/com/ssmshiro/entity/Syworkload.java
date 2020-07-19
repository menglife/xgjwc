package com.ssmshiro.entity;

public class Syworkload {
    private Integer syid;

    private Integer xyid;

    private Integer xq;

    private String kch;

    private String kxh;

    private Integer syzxs;

    private Integer fpcx;

    private Integer fpxs;

    private Float fpgzl;

    private String cwd;

    private String jy;

    public Integer getSyid() {
        return syid;
    }

    public void setSyid(Integer syid) {
        this.syid = syid;
    }

    public Integer getXyid() {
        return xyid;
    }

    public void setXyid(Integer xyid) {
        this.xyid = xyid;
    }

    public Integer getXq() {
        return xq;
    }

    public void setXq(Integer xq) {
        this.xq = xq;
    }

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch == null ? null : kch.trim();
    }

    public String getKxh() {
        return kxh;
    }

    public void setKxh(String kxh) {
        this.kxh = kxh == null ? null : kxh.trim();
    }

    public Integer getSyzxs() {
        return syzxs;
    }

    public void setSyzxs(Integer syzxs) {
        this.syzxs = syzxs;
    }

    public Integer getFpcx() {
        return fpcx;
    }

    public void setFpcx(Integer fpcx) {
        this.fpcx = fpcx;
    }

    public Integer getFpxs() {
        return fpxs;
    }

    public void setFpxs(Integer fpxs) {
        this.fpxs = fpxs;
    }

    public Float getFpgzl() {
        return fpgzl;
    }

    public void setFpgzl(Float fpgzl) {
        this.fpgzl = fpgzl;
    }

    public String getCwd() {
        return cwd;
    }

    public void setCwd(String cwd) {
        this.cwd = cwd == null ? null : cwd.trim();
    }

    public String getJy() {
        return jy;
    }

    public void setJy(String jy) {
        this.jy = jy == null ? null : jy.trim();
    }
}