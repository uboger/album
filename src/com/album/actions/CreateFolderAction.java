package com.album.actions;

import java.util.Date;
import java.util.List;

import com.album.dao.impl.FolderDaoImpl;
import com.album.domain.Folder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateFolderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2354170287280253973L;
	private Folder folder;
	private FolderDaoImpl interFolder;
	
	
	@Override
	public String execute() throws Exception {
		folder.setCreatetime(new Date());
		interFolder.createFolder(folder);//保存到数据库
		List<Folder> folderList = interFolder.findFoldersByUserId(folder.getUid());
		if(folderList==null){
			folderList=null;
		}
		if(ActionContext.getContext().getSession().containsKey("folderList")){
			ActionContext.getContext().getSession().remove("folderList");
		}
		//存到session里面
		ActionContext.getContext().getSession().put("folderList", folderList);
		return SUCCESS;
	}
	public Folder getFolder() {
		return folder;
	}
	public void setFolder(Folder folder) {
		this.folder = folder;
	}
	public FolderDaoImpl getInterFolder() {
		return interFolder;
	}
	public void setInterFolder(FolderDaoImpl interFolder) {
		this.interFolder = interFolder;
	}
	
}
