package com.album.domain;

import java.io.Serializable;
import java.util.Date;

public class Folder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -777725026339165689L;
	private Integer id;
	private String foldername;
	private String folderinfor;
	private Date createtime;
	private Integer limitid;
	private Integer uid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoldername() {
		return foldername;
	}
	public void setFoldername(String foldername) {
		this.foldername = foldername;
	}
	public String getFolderinfor() {
		return folderinfor;
	}
	public void setFolderinfor(String folderinfor) {
		this.folderinfor = folderinfor;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Integer getLimitid() {
		return limitid;
	}
	public void setLimitid(Integer limitid) {
		this.limitid = limitid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
}
