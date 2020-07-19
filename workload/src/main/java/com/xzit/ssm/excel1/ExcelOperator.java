package com.xzit.ssm.excel1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelOperator<T>{
	/* 定义默认的列宽 */
	private static final int DEFAULT_COLUMN_WIDTH = 10;
	/* 定义默认的工作薄名称 */
	private static final String DEFAULT_WORK_TITLE = "表格名称";
	/* 定义默认的工作表标题样式 */
	private static final ITitleFormat DEFAULT_TITLE_FORMAT = new DefaultTitleFormat();
	/* 定义默认的工作表表头样式 */
	private static final IColumnFormat DEFAULT_COLUMN_FORMAT = new DefaultColumnFormat();
	/* 定义默认的工作表数据样式 */
	private static final IDataCellFormat DEFAULT_DATACELL_FORMAT = new DefaultDataCellFormat();

	private static final IDataCellFormat CUSTOM_DATACELL_FORMAT = new CustomDataCellFormat();

	/* 指定工作表标题的 样式 */
	private ITitleFormat titleFormat = DEFAULT_TITLE_FORMAT;
	/* 指定表头样式 */
	private IColumnFormat columnFormat = DEFAULT_COLUMN_FORMAT;
	/* 指定数据行 样式 */
	private IDataCellFormat dataFormat = DEFAULT_DATACELL_FORMAT;

	/**
	 * 导出Excel .成功导出，返回true；否则返回false
	 * 
	 * @param request
	 *            HTTP请求对象
	 * @param response
	 *            HTTP响应对象
	 * @param workTitle
	 *            工作薄名称
	 * @param title
	 *            工作表标题
	 * @param columns
	 *            列名数组
	 * @param widths
	 *            列宽度数组
	 * @param dataList
	 *            要导出的对象集合
	 * @param objectMapper
	 *            对象解析器，将一个对象解析成一行数据
	 * @param mz 表头是否合并，mz=null不合并
	 */ 
	public boolean exportExcel(HttpServletRequest request,
								HttpServletResponse response, String workTitle, String title,
								String[] columns, int[] widths, List<T> dataList,
								IObjectMapper<T> objectMapper,MergeZone mz) {
		OutputStream out = null;
		WritableWorkbook wbook = null;
		try {
			// 对象解析器不能为空
			if(objectMapper==null)
				throw new Exception("对象解析器不能为空");

			if (workTitle == null || workTitle.trim().equals("")) {
				workTitle = DEFAULT_WORK_TITLE;
			}
			out = response.getOutputStream();
			response.setContentType("application/msexcel");// 定义输出类型
			String fileName = workTitle;
			// 获取浏览器类型
			String user_agent = request.getHeader("User-Agent").toLowerCase();
			// 为不同的浏览器，对文件名进行不同的编码转换
			if (user_agent.indexOf("firefox") > 0) {
				fileName = new String(workTitle.getBytes("UTF-8"), "iso8859-1");
			} else {
				fileName = URLEncoder.encode(workTitle, "UTF-8");
			}

			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName + ".xls"); // 设定输出文件头

			wbook = Workbook.createWorkbook(out); // 建立excel文件

            WritableSheet wsheet;
			if (workTitle != null && !workTitle.equals("")) {
				wsheet = wbook.createSheet(workTitle, 0); // 创建一个工作薄
			} else {
				wsheet = wbook.createSheet("", 0);
			}

			int headerIndex = 0; // 记录表头所在的行 ,表头占两行

			if (title != null && !title.equals("")) {
				headerIndex = 2; //表头占两行,如果占一行，则headerIndex=1;
				//合并单元格
				if(mz!=null)
					wsheet.mergeCells(mz.getLeftCol(), mz.getLeftRow(), mz.getRightCol(), mz.getRightRow());
				// 设置excel标题
				wsheet.addCell(new Label(0, 0, title, this.getTitleFormat()
						.getTitleCellFormat()));
			}

			// 在一新行中, 为表格添加表头
			if (columns != null) {
				for (int i = 0; i < columns.length; i++) {
					if (widths != null && widths.length > 0) {
						if ((i + 1) <= widths.length) {
							wsheet.setColumnView(i, widths[i]);
						} else {
							wsheet.setColumnView(i, DEFAULT_COLUMN_WIDTH);
						}
					} else {
						wsheet.setColumnView(i, DEFAULT_COLUMN_WIDTH);
					}
					wsheet.addCell(new Label(i, headerIndex, columns[i], this
							.getColumnFormat().getTitleCellFormat()));
				}
			}

			// 将集合中的数据添加到excel的工作表中
			if (dataList != null) {
				for (int i = 0; i < dataList.size(); i++) {
					T obj = dataList.get(i);
					objectMapper.toExcelRow(wsheet, this.dataFormat, i
							+ headerIndex + 1, obj);
				}
			}
			// 主体内容生成结束
			wbook.write(); // 写入文件
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (wbook != null) {
				try {
					wbook.close();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 导出Excel
	 */
	public void exportMultisheetExcel(WritableWorkbook wbook,
                                         String workTitle, String title,
										 String[] columns, int[] widths,
                                         List<T> dataList,
										 IObjectMapper<T> objectMapper,
                                         MergeZone mz,
                                         int sheetIndex) {
		try {
			// 对象解析器不能为空
			if(objectMapper==null)
				throw new Exception("对象解析器不能为空");

			if (workTitle == null || workTitle.trim().equals("")) {
				workTitle = DEFAULT_WORK_TITLE;
			}
            WritableSheet wsheet;
            if (workTitle != null && !workTitle.equals("")) {
                wsheet = wbook.createSheet(workTitle, sheetIndex); // 创建一个工作薄
            } else {
                wsheet = wbook.createSheet("", sheetIndex);
            }

            int headerIndex = 0; // 记录表头所在的行 ,表头占两行

            if (title != null && !title.equals("")) {
                headerIndex = 1; //表头占两行,如果占一行，则headerIndex=1;
                //合并单元格
                if(mz!=null)
                    wsheet.mergeCells(mz.getLeftCol(), mz.getLeftRow(), mz.getRightCol(), mz.getRightRow());
                // 设置excel标题
                wsheet.addCell(new Label(0, 0, title, this.getTitleFormat()
                        .getTitleCellFormat()));
            }

            // 在一新行中, 为表格添加表头
            if (columns != null) {
                for (int i = 0; i < columns.length; i++) {
                    if (widths != null && widths.length > 0) {
                        if ((i + 1) <= widths.length) {
                            wsheet.setColumnView(i, widths[i]);
                        } else {
                            wsheet.setColumnView(i, DEFAULT_COLUMN_WIDTH);
                        }
                    } else {
                        wsheet.setColumnView(i, DEFAULT_COLUMN_WIDTH);
                    }
                    wsheet.addCell(new Label(i, headerIndex, columns[i], this
                            .getColumnFormat().getTitleCellFormat()));
                }
            }

            // 将集合中的数据添加到excel的工作表中
            if (dataList != null) {
                for (int i = 0; i < dataList.size(); i++) {
                    T obj = dataList.get(i);
                    objectMapper.toExcelRow(wsheet, this.dataFormat, i
                            + headerIndex + 1, obj);
                }
            }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 导入Excel,将Excel 中的数据导入到List 中
	 * 
	 * @param input
	 *            指定输入流
	 * @param index
	 *            工作博的序号 (从0开始)
	 * @param startIndex
	 *            指定从第几行开始读入 (第一行对应的index为0)
	 * @param rowMapper
	 *            行包装器(负责将一行数据转变成一个数据对象)
	 */
	@SuppressWarnings("unchecked")
	public List<T> importExcel(InputStream input, int index, int startIndex,
			IRowMapper<T> rowMapper) {
		// TODO Auto-generated method stub
		Workbook rwb = null;
		try {
			List list = new ArrayList();
			rwb = Workbook.getWorkbook(input);
			// Assert.isTrue(index < rwb.getSheets().length && index >= 0,
			// "为index指定的值  " + index + " 无效 ");

			Sheet st = rwb.getSheet(index);
			startIndex = (startIndex < 0) ? 0 : startIndex;
			// Assert.isTrue(startIndex < st.getRows(), "为startIndex指定的值   " +
			// startIndex + " 无效");
			// Assert.notNull(rowMapper, "行包装器没有指定");
			for (int i = startIndex; i < st.getRows(); i++) {
				T obj = rowMapper.toObject(st, i);
				if (obj != null) {
					list.add(obj);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rwb != null) {
				rwb.close();
			}
		}
	}
	/**
	 * 导入Excel,将Excel中的数据导入到List 中
	 * 
	 * @param input
	 *            指定输入流
	 * @param title
	 *            工作博的名称
	 * @param startIndex
	 *            指定从第几行开始读入（第一行对应的index为0）
	 * @param rowMapper
	 *            行包装器（负责将一行数据转变成一个数据对象）
	 */
	@SuppressWarnings("unchecked")
	public List<T> importExcel(InputStream input, String title,
			int startIndex, IRowMapper<T> rowMapper) {
		Workbook rwb = null;
		try {
			List list = new ArrayList();
			rwb = Workbook.getWorkbook(input);
			// Assert.notNull(title,"title参数不能为空");
			Sheet st = rwb.getSheet(title);
			// Assert.notNull(st,"为title参数指定的值:" + title + "无效");
			startIndex = (startIndex < 0) ? 0 : startIndex;
			// Assert.isTrue(startIndex < st.getRows(), "为startIndex指定的值   " +
			// startIndex + " 无效");
			// Assert.notNull(rowMapper, "行包装器没有指定");
			for (int i = startIndex; i < st.getRows(); i++) {
				T obj = rowMapper.toObject(st, i);
				if (obj != null) {
					list.add(obj);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rwb != null) {
				rwb.close();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void setTitleFormat(ITitleFormat titleFormat) {
		this.titleFormat = titleFormat;
	}

	@SuppressWarnings("unchecked")
	public void setColumnFormat(IColumnFormat columnFormat) {
		this.columnFormat = columnFormat;
	}

	@SuppressWarnings("unchecked")
	public void setDataFormat(IDataCellFormat dataFormat) {
		this.dataFormat = dataFormat;
	}

	@SuppressWarnings("unchecked")
	public ITitleFormat getTitleFormat() {
		// 如果没有设置工作表标题样式，就给它一个默认样式
		if (this.titleFormat == null
				|| this.titleFormat.getTitleCellFormat() == null) {
			this.titleFormat = DEFAULT_TITLE_FORMAT;
		}
		return titleFormat;
	}

	@SuppressWarnings("unchecked")
	public IColumnFormat getColumnFormat() {
		// 如果没有设置工作表标题样式，就给它一个默认样式
		if (this.columnFormat == null
				|| this.columnFormat.getTitleCellFormat() == null) {
			this.columnFormat = DEFAULT_COLUMN_FORMAT;
		}
		return columnFormat;
	}

	@SuppressWarnings("unchecked")
	public IDataCellFormat getDataFormat() {
		//if (this.dataFormat == null) {
		this.dataFormat = DEFAULT_DATACELL_FORMAT;
		//}
		return dataFormat;
	}

	public IDataCellFormat getCustomDataFormat(){
		//if (this.dataFormat == null) {
		this.dataFormat = CUSTOM_DATACELL_FORMAT;
		//}
		return dataFormat;
	}

	public jxl.write.Number addNumber(float value){
        jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#.##"); //设置数字格式
        jxl.write.WritableCellFormat wcfN = new jxl.write.WritableCellFormat(nf); //设置表单格式
        jxl.write.Number labelNF = new jxl.write.Number(1, 1, value, wcfN); //格式化数值
        return labelNF;
    }

}
