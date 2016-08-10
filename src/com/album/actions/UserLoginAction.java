package com.album.actions;


import java.util.List;

import com.album.dao.impl.FolderDaoImpl;
import com.album.dao.impl.UserDaoImpl;
import com.album.domain.Folder;
import com.album.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3758667534922704380L;
	/**
	 * 
	 */
	private FolderDaoImpl interFolder;
	private UserDaoImpl interUser;
	private User user;
	
	
	@Override
	public String execute() throws Exception {
		user=interUser.login1(user);
		if(user!=null){
			int userid = interUser.getUserId(user.getUsername(),user.getUserpwd());
			
			List<User> friendList = interUser.findAllFriend(userid);
			List<Folder> folders = interFolder.findFoldersByUserId(userid);
			ActionContext.getContext().getSession().put("user", user);
			ActionContext.getContext().getSession().put("friendList", friendList);
			ActionContext.getContext().getSession().put("folders", folders);
			return SUCCESS;
		}
		return INPUT;
	}




	public FolderDaoImpl getInterFolder() {
		return interFolder;
	}




	public void setInterFolder(FolderDaoImpl interFolder) {
		this.interFolder = interFolder;
	}




	public UserDaoImpl getInterUser() {
		return interUser;
	}


	public void setInterUser(UserDaoImpl interUser) {
		this.interUser = interUser;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
}
