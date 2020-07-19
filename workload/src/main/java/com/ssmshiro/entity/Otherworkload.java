package com.ssmshiro.entity;

public class Otherworkload {
    private Integer otherid;

    private Integer xq;

    private Integer xyid;

    private String gzlmc;

    private Float gzl;

    private String brief;

    private String cwd;

    private String jy;

    public Integer getOtherid() {
        return otherid;
    }

    public void setOtherid(Integer otherid) {
        this.otherid = otherid;
    }

    public Integer getXq() {
        return xq;
    }

    public void setXq(Integer xq) {
        this.xq = xq;
    }

    public Integer getXyid() {
        return xyid;
    }

    public void setXyid(Integer xyid) {
        this.xyid = xyid;
    }

    public String getGzlmc() {
        return gzlmc;
    }

    public void setGzlmc(String gzlmc) {
        this.gzlmc = gzlmc == null ? null : gzlmc.trim();
    }

    public Float getGzl() {
        return gzl;
    }

    public void setGzl(Float gzl) {
        this.gzl = gzl;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
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