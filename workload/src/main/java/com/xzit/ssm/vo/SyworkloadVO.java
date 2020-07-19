package com.xzit.ssm.vo;

import com.xzit.ssm.entity.Curworkload;

/**
 * create by hjx on 2018/11/27 0027
 */
public class SyworkloadVO {
    private int syid; //实验工作量统计表id
    private int xyid;  //学院id
    private int xq;    //所属学期id
    private String kch;  //课程号
    private String kxh;  //课序号
    private int syzxs;   //实验总学时
    private int fpcx;   //分批次数
    private int fpxs;   //分批学时
    private float fpgzl;  //分批工作量
    private String kcm;   //课程名
    private String skls;   //授课老师
    private String bjmc;   //班级名称
    private int xkrs;     //选课人数
    private int zxs;    //总学时
    private int skxs;   //授课学时
    private int syxs;   //实践学时
    private String name;  //学院名称
    private String termname; //学期名称
    private String cwd;
    private String jy;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    private String errmsg="";

    public Curworkload getCwl() {
        return cwl;
    }

    public void setCwl(Curworkload cwl) {
        this.cwl = cwl;
    }

    private Curworkload cwl;//分批实验对应的课程信息

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

    public int getSyid() {
        return syid;
    }

    public void setSyid(int syid) {
        this.syid = syid;
    }

    public int getXyid() {
        return xyid;
    }

    public void setXyid(int xyid) {
        this.xyid = xyid;
    }

    public int getXq() {
        return xq;
    }

    public void setXq(int xq) {
        this.xq = xq;
    }

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch;
    }

    public String getKxh() {
        return kxh;
    }

    public void setKxh(String kxh) {
        this.kxh = kxh;
    }

    public int getSyzxs() {
        return syzxs;
    }

    public void setSyzxs(int syzxs) {
        this.syzxs = syzxs;
    }

    public int getFpcx() {
        return fpcx;
    }

    public void setFpcx(int fpcx) {
        this.fpcx = fpcx;
    }

    public int getFpxs() {
        return fpxs;
    }

    public void setFpxs(int fpxs) {
        this.fpxs = fpxs;
    }

    public float getFpgzl() {
        return fpgzl;
    }

    public void setFpgzl(float fpgzl) {
        this.fpgzl = fpgzl;
    }

    public String getKcm() {
        return kcm;
    }

    public void setKcm(String kcm) {
        this.kcm = kcm;
    }

    public String getSkls() {
        return skls;
    }

    public void setSkls(String skls) {
        this.skls = skls;
    }

    public String getBjmc() {
        return bjmc;
    }

    public void setBjmc(String bjmc) {
        this.bjmc = bjmc;
    }

    public int getXkrs() {
        return xkrs;
    }

    public void setXkrs(int xkrs) {
        this.xkrs = xkrs;
    }

    public int getZxs() {
        return zxs;
    }

    public void setZxs(int zxs) {
        this.zxs = zxs;
    }

    public int getSkxs() {
        return skxs;
    }

    public void setSkxs(int skxs) {
        this.skxs = skxs;
    }

    public int getSyxs() {
        return syxs;
    }

    public void setSyxs(int syxs) {
        this.syxs = syxs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTermname() {
        return termname;
    }

    public void setTermname(String termname) {
        this.termname = termname;
    }
}
