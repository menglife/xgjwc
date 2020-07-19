package com.xzit.ssm.excel1;

import jxl.write.WritableCellFormat;
 
//该接口为 标识接口，所有描述工作博标题样式的类都要实现此接口  
public interface ITitleFormat extends ICellFormat{  
    public WritableCellFormat getTitleCellFormat();  
} 
