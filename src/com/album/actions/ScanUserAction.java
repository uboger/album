package com.album.actions;

import com.album.dao.impl.UserDaoImpl;
import com.album.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class ScanUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8010709161512338346L;
	
	private UserDaoImpl interUser;
	private int id;
	private User userInfor;
	
	
	@Override
	public String execute() throws Exception {
		this.setUserInfor(interUser.findUserById(id));
		return SUCCESS;
	}
	public UserDaoImpl getInterUser() {
		return interUser;
	}
	public void setInterUser(UserDaoImpl interUser) {
		this.interUser = interUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserInfor() {
		return userInfor;
	}
	public void setUserInfor(User userInfor) {
		this.userInfor = userInfor;
	}
	
	
}
