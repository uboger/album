package com.album.db;

import org.junit.Test;

public class JavaBean {
	private int id;
	private float price;
	public int id(){
		return id;
	}
	public float price(){
		return price;
	}
	public JavaBean id(int id){
		this.id=id;
		return this;
	}
	public JavaBean price(float price){
		this.price=price;
		return this;
	}
@Test
public void test(){
	//JavaBean bean = new JavaBean().id(2).price(22.5f);
	//int id=bean.id();
	//JavaBean bean1 = new JavaBean();
	//int id1=bean1.id();
}

}