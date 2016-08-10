package com.album.actions;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.album.dao.impl.PhotoDaoImpl;
import com.album.db.UUIDUtil;
import com.album.domain.Photo;
import com.opensymphony.xwork2.ActionSupport;

public class UploadPhotoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3572496297478279133L;

	private PhotoDaoImpl interPhoto;
	private Photo photo;
	private File image;
	private String imageFileName;
	
	
	@Override
	public String execute() throws Exception {
		String realPath=ServletActionContext.getServletContext().getRealPath("/images");
		if(imageFileName==null||imageFileName.trim().equals("")){
			this.addFieldError("image", "select file");
		}else{
			String targetName=generateFileName(imageFileName);
			String randomPath=generateRandomPath(targetName);
			String newPath=realPath+"\\"+randomPath;
			photo.setPhotopath("images"+"\\"+randomPath+"\\"+targetName);
			File target = new File(newPath,targetName);
			FileUtils.copyFile(image, target);
			photo.setCreatetime(new Date());
			interPhoto.save(photo);
		}
		return SUCCESS;
	}
	private String generateRandomPath(String targetName) {
		int i = targetName.lastIndexOf(".");
		String random = targetName.substring(0,i);
		int code = random.hashCode();
		
		int a = code&0xf;
		int b = code&0xf0;
		
		return 	a+"\\"+b;
	}
	private String generateFileName(String imageFileName2) {
		int i = imageFileName.lastIndexOf(".");
		String suffix = imageFileName.substring(i);
		return 	UUIDUtil.uuid()+suffix;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public PhotoDaoImpl getInterPhoto() {
		return interPhoto;
	}
	public void setInterPhoto(PhotoDaoImpl interPhoto) {
		this.interPhoto = interPhoto;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	
}
