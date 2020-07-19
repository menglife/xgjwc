package com.xzit.ssm.excel1;

import jxl.Sheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/* 
 * Excel 行包装器, 负责将excel 中一行数据转变成一个对象 
 */  
public interface IRowMapper<T>{  
  
    /* 
     * 定义如何将一个excel 中的一行 转变成一个对象,返回装有excel数据的对象 
     * sheet  操作的工作表 
     * rowNum 表示 行号 
     */  
    public T toObject(Sheet sheet, int rowNum)  throws RowsExceededException, WriteException;
}  
