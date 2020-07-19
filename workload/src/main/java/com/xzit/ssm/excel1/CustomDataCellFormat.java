package com.xzit.ssm.excel1;

import jxl.CellType;
import jxl.format.*;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;

/* 
 * 定义一个工作博数据行样式的默认实现 
 */   
public class CustomDataCellFormat implements IDataCellFormat{
    @Override
    public WritableCellFormat getDataCellFormat(CellType type) {
        // TODO Auto-generated method stub
          WritableCellFormat wcf = null;
           try {
        	   WritableFont wf = new WritableFont(WritableFont.TIMES,12, WritableFont.NO_BOLD,false);//最后一个为是否italic
               //字体样式
               if(type == CellType.NUMBER || type == CellType.NUMBER_FORMULA){//数字
                  NumberFormat nf = new NumberFormat("#,#0.00");
                  wcf = new WritableCellFormat(wf,nf);
               }else if(type == CellType.DATE || type == CellType.DATE_FORMULA){//日期
                   jxl.write.DateFormat df = new jxl.write.DateFormat("yyyy-MM-dd hh:mm");
                   wcf = new WritableCellFormat(wf,df);
               }else{     
                   //WritableFont wf = new WritableFont(WritableFont.TIMES,10, WritableFont.NO_BOLD,false);//最后一个为是否italic     
                   wcf = new WritableCellFormat(wf);     
               }     
               //对齐方式     
               wcf.setAlignment(Alignment.LEFT);     
               wcf.setVerticalAlignment(VerticalAlignment.CENTRE);     
               //边框     
               wcf.setBorder(Border.ALL,BorderLineStyle.THIN);
               wcf.setBorder(Border.LEFT,BorderLineStyle.THIN);
               wcf.setBorder(Border.BOTTOM,BorderLineStyle.THIN);
               wcf.setBorder(Border.RIGHT,BorderLineStyle.THIN);
               //背景色
               wcf.setBackground(Colour.PINK);
               wcf.setWrap(true);//自动换行     
                    
           } catch (WriteException e) {     
            e.printStackTrace();     
           }     
           return wcf;      
    }  
  
}  
