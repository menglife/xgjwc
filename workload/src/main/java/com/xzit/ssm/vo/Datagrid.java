package com.xzit.ssm.vo;

import java.util.List;
import java.util.Map;

/**
 * create by hjx on 2018/11/9 0009
 */
public class Datagrid<T> {
    private long total;
    private List<T> rows;
    private List<Map<String,Object>> footer;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public List<Map<String, Object>> getFooter() {
        return footer;
    }

    public void setFooter(List<Map<String, Object>> footer) {
        this.footer = footer;
    }

}
