package com.xzit.ssm.excel1;
/**
 * 第一个参数：要合并的单元格最左上角的列号，
 * 第二个参数：要合并的单元格最左上角的行号，
 * 第三个参数：要合并的单元格最右角的列号，
 * 第四个参数：要合并的单元格最右下角的行号， 
 */
public class MergeZone {
    private int leftCol;
    private int leftRow;
    private int rightCol;
    private int rightRow;
    
	public MergeZone(int leftCol, int leftRow, int rightCol, int rightRow) {
		super();
		this.leftCol = leftCol;
		this.leftRow = leftRow;
		this.rightCol = rightCol;
		this.rightRow = rightRow;
	}

	public int getLeftCol() {
		return leftCol;
	}

	public void setLeftCol(int leftCol) {
		this.leftCol = leftCol;
	}

	public int getLeftRow() {
		return leftRow;
	}

	public void setLeftRow(int leftRow) {
		this.leftRow = leftRow;
	}

	public int getRightCol() {
		return rightCol;
	}

	public void setRightCol(int rightCol) {
		this.rightCol = rightCol;
	}

	public int getRightRow() {
		return rightRow;
	}

	public void setRightRow(int rightRow) {
		this.rightRow = rightRow;
	} 
}
