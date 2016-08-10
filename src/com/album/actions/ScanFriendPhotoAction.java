package com.album.actions;

import org.apache.struts2.ServletActionContext;

import com.album.dao.impl.FolderDaoImpl;
import com.album.dao.impl.PhotoDaoImpl;
import com.album.db.Page;
import com.album.domain.Folder;
import com.opensymphony.xwork2.ActionSupport;

public class ScanFriendPhotoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -39846929241323832L;
	private Folder folder;
	private Page page;
	private PhotoDaoImpl interPhoto;
	private FolderDaoImpl interFolder;
	
	
	@Override
	public String execute() throws Exception {
		this.folder=interFolder.find(folder.getId());
		this.page = interPhoto.findPhotoList(folder,page);
		return SUCCESS;
	}


	public Folder getFolder() {
		return folder;
	}


	public void setFolder(Folder folder) {
		this.folder = folder;
	}


	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public PhotoDaoImpl getInterPhoto() {
		return interPhoto;
	}


	public void setInterPhoto(PhotoDaoImpl interPhoto) {
		this.interPhoto = interPhoto;
	}


	public FolderDaoImpl getInterFolder() {
		return interFolder;
	}


	public void setInterFolder(FolderDaoImpl interFolder) {
		this.interFolder = interFolder;
	}

}
