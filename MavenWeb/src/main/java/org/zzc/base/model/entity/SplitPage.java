package org.zzc.base.model.entity;

import java.io.Serializable;

/**
 * @功能:分页信息
 * @项目:dlkproject
 * @作者:wangjz
 * @日期:2012-11-15下午03:39:21
 */
public class SplitPage implements Serializable {
	/** */
	private static final long serialVersionUID = -4796708099962256262L;
	/** 是否分页 */
	private boolean isSplitPage = false;
	/** 总记录数 */
	private int totalRows = 0;
	/** 总页数 */
	private int totalPage = 0;
	/** 一页的记录条数 */
	private int pageSize = 30;
	/** 当前的页数 */
	private int currentPage = 1;
	/** 取得记录所在的开始行数 */
	private int startRow = 0;
	/** 取得记录所在的结束行数 */
	private int endRow = 0;

	/** 在页面上每次显示的页数 */
	private int showPages = 6;
	/** 在页面上显示的开始页数 */
	private int startPage = 1;
	/** 在页面上显示的结束页数 */
	private int endPage = showPages;

	/**
	 * @构造方法
	 */
	public SplitPage() {
		setCurrentPage(this.currentPage);
	}

	/**
	 * @取得 是否分页
	 */
	public boolean getIsSplitPage() {
		return isSplitPage;
	}

	/**
	 * @设置 是否分页
	 */
	public void setIsSplitPage(boolean isSplitPage) {
		this.isSplitPage = isSplitPage;
	}

	/**
	 * @取得 总记录数
	 */
	public int getTotalRows() {
		return totalRows;
	}

	/**
	 * @设置 总记录数
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		this.totalPage = (this.totalRows - 1) / this.pageSize + 1;
		if (this.totalPage < this.currentPage) {
			setCurrentPage(this.totalPage + 1);
		}
		if (this.totalPage < this.startPage) {
			this.startPage = this.totalPage + 1;
		}
		this.endPage = this.startPage + this.showPages - 1;
		if (this.totalPage < this.endPage) {
			this.endPage = this.totalPage;
		}
	}

	/**
	 * @取得 总页数
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @取得 一页的记录条数
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @设置 一页的记录条数
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.startRow = (this.currentPage - 1) * this.pageSize;
		this.endRow = this.startRow + this.pageSize - 1;
	}

	/**
	 * @取得 当前的页数
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @设置 当前的页数
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		this.startRow = (this.currentPage - 1) * this.pageSize;
		this.endRow = this.startRow + this.pageSize - 1;
	}

	/**
	 * @取得 取得记录所在的开始行数
	 */
	public int getStartRow() {
		return this.startRow;
	}

	/**
	 * @取得 取得记录所在的结束行数
	 */
	public int getEndRow() {
		return this.endRow;
	}

	/**
	 * @取得 在页面上每次显示的页数
	 */
	public int getShowPages() {
		return showPages;
	}

	/**
	 * @设置 在页面上每次显示的页数
	 */
	public void setShowPages(int showPages) {
		this.showPages = showPages;
	}

	/**
	 * @取得 在页面上显示的开始页数
	 */
	public int getStartPage() {
		return startPage;
	}

	/**
	 * @设置 在页面上显示的开始页数
	 */
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	/**
	 * @取得 在页面上显示的结束页数
	 */
	public int getEndPage() {
		return endPage;
	}

	/**
	 * @设置 在页面上显示的结束页数
	 */
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
