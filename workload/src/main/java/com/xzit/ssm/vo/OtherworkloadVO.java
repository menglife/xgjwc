package com.xzit.ssm.vo;

import com.xzit.ssm.entity.Otherworkload;

/**
 * create by hjx on 2018/11/28 0028
 */
public class OtherworkloadVO extends Otherworkload {
    private String name;//学院名称
    private String termname;//学期名称

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
