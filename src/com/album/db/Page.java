package com.album.db;

import java.io.Serializable;

import java.util.List;

public class Page<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8677923695457985473L;
	private int no = 1;//默认开始页数
	private int size = 4;//每页显示条数
	private int startIndex;
	private int count=1;//总页数
	private int total;//总条数
	private List<T> results;//存放的记录
	public Page(){}
	public Page(int total,int no){
		this.total = total;
		this.count = total%size==0 ? total/size : total/size+1;
		if(no<1)no=1;
		if(no>count)no=count;
		this.no=no;
		this.startIndex=(this.no-1)*this.size;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
	
}
