package com.album.actions;

import com.album.dao.impl.UserDaoImpl;
import com.album.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserRegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6185879569582347219L;
	/**
	 * 
	 */
	private  UserDaoImpl interUser;
	private User user;
	
	
	
	public String execute() throws Exception {
		boolean flag = interUser.isExist(user.getUsername());
		if(!flag){
			return INPUT;
		}else{
			interUser.save(user);
			return SUCCESS;
		}
		
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
