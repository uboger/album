package com.album.actions;

import com.album.dao.impl.PhotoDaoImpl;
import com.album.domain.Folder;
import com.album.domain.Photo;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePhotoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2956385416332171053L;
	private PhotoDaoImpl interPhoto;
	private Photo photo;
	private Folder folder;
	
	
	@Override
	public String execute() throws Exception {
		interPhoto.deletePhotoByFolderId(photo);
		return SUCCESS;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public Folder getFolder() {
		return folder;
	}
	public void setFolder(Folder folder) {
		this.folder = folder;
	}
	public PhotoDaoImpl getInterPhoto() {
		return interPhoto;
	}
	public void setInterPhoto(PhotoDaoImpl interPhoto) {
		this.interPhoto = interPhoto;
	}
}
