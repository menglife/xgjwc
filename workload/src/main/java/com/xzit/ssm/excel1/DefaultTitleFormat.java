package com.xzit.ssm.excel1;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;

/* 
 * 定义一个工作博标题样式的默认实现 
 */   
public class DefaultTitleFormat implements ITitleFormat{
    @Override
    public WritableCellFormat getTitleCellFormat() {  
        // TODO Auto-generated method stub  
        WritableCellFormat wcf = null;     
           try {     
               //字体样式     
               WritableFont wf = new WritableFont(WritableFont.TIMES,20, WritableFont.BOLD,false);//最后一个为是否italic     
               wf.setColour(Colour.BLACK);     
               wcf = new WritableCellFormat(wf);     
               //对齐方式     
               wcf.setAlignment(Alignment.CENTRE);     
               wcf.setVerticalAlignment(VerticalAlignment.CENTRE);     
               //边框     
               wcf.setBorder(Border.ALL,BorderLineStyle.THIN); 
               //背景色     
               wcf.setBackground(Colour.WHITE);     
           } catch (WriteException e) {     
            e.printStackTrace();     
           }     
           return wcf;      
    }  
  
}  
