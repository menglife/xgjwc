package com.xzit.ssm.excel1;

import jxl.CellType;
import jxl.write.WritableCellFormat;

/* 
 * 该接口定义了如何为不同的数据类型指定不同的样式的方法 
 */  
public interface IDataCellFormat {  
    public WritableCellFormat getDataCellFormat(CellType type);  
}  
