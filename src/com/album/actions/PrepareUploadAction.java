package com.album.actions;

import java.util.HashMap;
import java.util.Map;

import com.album.dao.impl.FolderDaoImpl;
import com.album.domain.Folder;
import com.album.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PrepareUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4600201076161704207L;
	private Map<Integer,String> folders = new HashMap<Integer,String>();
	private FolderDaoImpl interFolder;
	private Folder folder;
	
	@Override
	public String execute() throws Exception {
		User user= (User) ActionContext.getContext().getSession().get("user");
		this.folders = interFolder.findFolders(user.getId());
		if(folders!=null){
			return SUCCESS;
		}
			return INPUT;
	}
	
	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public Map<Integer, String> getFolders() {
		return folders;
	}
	public void setFolders(Map<Integer, String> folders) {
		this.folders = folders;
	}
	public FolderDaoImpl getInterFolder() {
		return interFolder;
	}
	public void setInterFolder(FolderDaoImpl interFolder) {
		this.interFolder = interFolder;
	}
	
}
