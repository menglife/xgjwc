package com.xzit.ssm.vo;

/**
 * create by hjx on 2018/11/29 0029
 */
public class GzlVO {
    private int collid = 0;//学院id
    private String nick = "";//学院昵称
    private int xq=0;//学期
    private Float lljxgzl = 0f;//理论教学工作量之和
    private Float sjjxgzl = 0f;//实践教学工作量之和
    private Float kcsumgzl = 0f;//课程部分工作量之和
    private Float othergzl = 0f;//其它补贴工作量
    private Float totalgzl = 0f;//所有工作量之和


    public int getCollid() {
        return collid;
    }

    public void setCollid(int collid) {
        this.collid = collid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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

    public Float getKcsumgzl() {
        return kcsumgzl;
    }

    public void setKcsumgzl(Float kcsumgzl) {
        this.kcsumgzl = kcsumgzl;
    }

    public Float getOthergzl() {
        return othergzl;
    }

    public void setOthergzl(Float othergzl) {
        this.othergzl = othergzl;
    }

    public Float getTotalgzl() {
        return totalgzl;
    }

    public void setTotalgzl(Float totalgzl) {
        this.totalgzl = totalgzl;
    }

    public int getXq() {
        return xq;
    }

    public void setXq(int xq) {
        this.xq = xq;
    }
}
