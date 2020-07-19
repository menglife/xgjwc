package com.xzit.ssm.excel1;

import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/* 
 * 该类负责将一个对象转变成Excel 中的一行数据 
 */  
public interface IObjectMapper<T>{  
    /* 
     * 将obj 对象 转变成sheet工作表 中的第 rowNum行数据 
     * sheet  操作的工作表 
     * dataFormat 指定数据行样式 
     * rowNum 表示 行号 
     * obj  要转换的对象 
     */  
    public void toExcelRow(WritableSheet sheet, IDataCellFormat dataFormat, int rowNum, T obj)  throws RowsExceededException, WriteException;
      
}  
