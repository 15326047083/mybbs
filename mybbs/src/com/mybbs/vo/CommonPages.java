package com.mybbs.vo;

import java.util.List;

/**
 * 通用分页显示
 * 
 * @author leiyuan
 *
 * @param <T>
 */
public class CommonPages<T> {

	private int pages; // 当前页
	private int count;// 总数量数
	private int totalpages;// 总页数
	private int limit = 1;
	private List<T> commonList;

	@Override
	public String toString() {
		return "CommonPages [pages=" + pages + ", count=" + count + ", totalpages=" + totalpages + ", limit=" + limit
				+ ", commonList=" + commonList + "]";
	}

	public CommonPages(int pages, int count, int totalpages, int limit, List<T> commonList) {
		// super();
		this.pages = pages;
		this.count = count;
		this.totalpages = totalpages;
		this.limit = limit;
		this.commonList = commonList;
	}

	public CommonPages() {

	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getTotalpages() {
		return totalpages;
	}

	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<T> getCommonList() {
		return commonList;
	}

	public void setCommonList(List<T> commonList) {
		this.commonList = commonList;
	}

}
