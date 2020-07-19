package com.xzit.ssm.entity;

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

    private Curworkload cwl;//分批实验对应的课程信息
    private Term term;
    public String getCwd() {
        return cwd;
    }

    public void setCwd(String cwd) {
        this.cwd = cwd;
    }

    public String getJy() {
        return jy;
    }

    public void setJy(String jy) {
        this.jy = jy;
    }
    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    private College college;

    private String errmsg="";

    public Integer getXyid() {
        return xyid;
    }

    public void setXyid(Integer xyid) {
        this.xyid = xyid;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Curworkload getCwl() {
        return cwl;
    }

    public void setCwl(Curworkload cwl) {
        this.cwl = cwl;
    }

    public Integer getSyid() {
        return syid;
    }

    public void setSyid(Integer syid) {
        this.syid = syid;
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
}