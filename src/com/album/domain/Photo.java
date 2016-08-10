package com.album.domain;

import java.io.Serializable;
import java.util.Date;

public class Photo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4689691416202983142L;
	private Integer id;
	private String photoname;
	private String photoinfor;
	private String photopath;
	private Date createtime;
	private Integer fid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public String getPhotoinfor() {
		return photoinfor;
	}
	public void setPhotoinfor(String photoinfor) {
		this.photoinfor = photoinfor;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
}
