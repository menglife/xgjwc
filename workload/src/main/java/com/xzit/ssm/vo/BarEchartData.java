package com.xzit.ssm.vo;

import java.util.ArrayList;
import java.util.List;
import com.xzit.ssm.vo.Datagrid;

/**
 * create by hjx on 2018/11/27 0027
 */
public class BarEchartData{
    private List<String> category = new ArrayList<String>();// 横坐标
    private List<Float> llgzldata = new ArrayList<Float>();//理论工作量
    private List<Float> sjgzldata = new ArrayList<Float>();//实践工作量
    private List<Float> othergzldata = new ArrayList<Float>();//其它工作量
    private List<GzlVO> gzldata = new ArrayList<GzlVO>();//包含所有工作量信息的集合
    private Datagrid<GzlVO> datagrid;

    public BarEchartData() {
    }

    public BarEchartData(List<String> category,
                         List<Float> llgzldata,
                         List<Float> sjgzldata,
                         List<Float> othergzldata) {
        this.category = category;
        this.llgzldata = llgzldata;
        this.sjgzldata = sjgzldata;
        this.othergzldata = othergzldata;
    }

    public Datagrid<GzlVO> getDatagrid() {
        return datagrid;
    }

    public void setDatagrid(Datagrid<GzlVO> datagrid) {
        this.datagrid = datagrid;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<Float> getLlgzldata() {
        return llgzldata;
    }

    public void setLlgzldata(List<Float> llgzldata) {
        this.llgzldata = llgzldata;
    }

    public List<Float> getSjgzldata() {
        return sjgzldata;
    }

    public void setSjgzldata(List<Float> sjgzldata) {
        this.sjgzldata = sjgzldata;
    }

    public List<Float> getOthergzldata() {
        return othergzldata;
    }

    public void setOthergzldata(List<Float> othergzldata) {
        this.othergzldata = othergzldata;
    }

    public List<GzlVO> getGzldata() {
        return gzldata;
    }

    public void setGzldata(List<GzlVO> gzldata) {
        this.gzldata = gzldata;
    }
}
