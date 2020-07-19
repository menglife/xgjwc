package com.xzit.ssm.entity;

public class Curworkload {
    private Integer id=0;

    private Integer xq=-1;

    private String kch;

    private String kxh;

    private String kcm;

    private String skls;

    private String lszc;

    private Integer yxid=0;

    private String kcsx;

    private String bjmc;

    private Integer krl=0;

    private Integer xkrs=0;

    private Integer zxs=0;

    private Integer mzxs=0;

    private Integer skxs=0;

    private Integer sjxs=0;

    private Integer syxs=0;

    private Float xf=0f;

    private String kclx="";

    private Integer sfcxk=1;

    private String bz="";

    private String kclx1="";

    private String kclx2="";

    private String kclx3="";

    private Float kcxs=0f;

    private Float rsxs=0f;

    private Float lljxgzl=0f;

    private Float sjjxgzl=0f;

    private Float sumgzl=0f;

    private String errmsg="";

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }

    private String re="";
    private String cwd;

    private String jy;

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



    //所属学期
    private Term term;
    //所属学院
    private College college;

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

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getKcm() {
        return kcm;
    }

    public void setKcm(String kcm) {
        this.kcm = kcm == null ? null : kcm.trim();
    }

    public String getSkls() {
        return skls;
    }

    public void setSkls(String skls) {
        this.skls = skls == null ? null : skls.trim();
    }

    public String getLszc() {
        return lszc;
    }

    public void setLszc(String lszc) {
        this.lszc = lszc == null ? null : lszc.trim();
    }

    public Integer getYxid() {
        return yxid;
    }

    public void setYxid(Integer yxid) {
        this.yxid = yxid;
    }

    public String getKcsx() {
        return kcsx;
    }

    public void setKcsx(String kcsx) {
        this.kcsx = kcsx == null ? null : kcsx.trim();
    }

    public String getBjmc() {
        return bjmc;
    }

    public void setBjmc(String bjmc) {
        this.bjmc = bjmc == null ? null : bjmc.trim();
    }

    public Integer getKrl() {
        return krl;
    }

    public void setKrl(Integer krl) {
        this.krl = krl;
    }

    public Integer getXkrs() {
        return xkrs;
    }

    public void setXkrs(Integer xkrs) {
        this.xkrs = xkrs;
    }

    public Integer getZxs() {
        return zxs;
    }

    public void setZxs(Integer zxs) {
        this.zxs = zxs;
    }

    public Integer getMzxs() {
        return mzxs;
    }

    public void setMzxs(Integer mzxs) {
        this.mzxs = mzxs;
    }

    public Integer getSkxs() {
        return skxs;
    }

    public void setSkxs(Integer skxs) {
        this.skxs = skxs;
    }

    public Integer getSjxs() {
        return sjxs;
    }

    public void setSjxs(Integer sjxs) {
        this.sjxs = sjxs;
    }

    public Integer getSyxs() {
        return syxs;
    }

    public void setSyxs(Integer syxs) {
        this.syxs = syxs;
    }

    public Float getXf() {
        return xf;
    }

    public void setXf(Float xf) {
        this.xf = xf;
    }

    public String getKclx() {
        return kclx;
    }

    public void setKclx(String kclx) {
        this.kclx = kclx == null ? null : kclx.trim();
    }

    public Integer getSfcxk() {
        return sfcxk;
    }

    public void setSfcxk(Integer sfcxk) {
        this.sfcxk = sfcxk;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getKclx1() {
        return kclx1;
    }

    public void setKclx1(String kclx1) {
        this.kclx1 = kclx1 == null ? null : kclx1.trim();
    }

    public String getKclx2() {
        return kclx2;
    }

    public void setKclx2(String kclx2) {
        this.kclx2 = kclx2 == null ? null : kclx2.trim();
    }

    public String getKclx3() {
        return kclx3;
    }

    public void setKclx3(String kclx3) {
        this.kclx3 = kclx3 == null ? null : kclx3.trim();
    }

    public Float getKcxs() {
        return kcxs;
    }

    public void setKcxs(Float kcxs) {
        this.kcxs = kcxs;
    }

    public Float getRsxs() {
        return rsxs;
    }

    public void setRsxs(Float rsxs) {
        this.rsxs = rsxs;
    }

    public Float getLljxgzl() {
        return lljxgzl;
    }

    public void setLljxgzl(Float lljxgzl) {
        this.lljxgzl = lljxgzl;
    }

    public Float getSjjxgzl() {
        return sjjxgzl;
    }

    public void setSjjxgzl(Float sjjxgzl) {
        this.sjjxgzl = sjjxgzl;
    }

    public Float getSumgzl() {
        return sumgzl;
    }

    public void setSumgzl(Float sumgzl) {
        this.sumgzl = sumgzl;
    }
}