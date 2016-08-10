package com.album.actions;

import com.album.dao.impl.UserDaoImpl;
import com.album.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6611685431615439315L;
	private User userInfor;
	private UserDaoImpl interUser;
	
	
	@Override
	public String execute() throws Exception {
		int state = interUser.modify(userInfor);
		if(state==1){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	public User getUserInfor() {
		return userInfor;
	}
	public void setUserInfor(User userInfor) {
		this.userInfor = userInfor;
	}
	public UserDaoImpl getInterUser() {
		return interUser;
	}
	public void setInterUser(UserDaoImpl interUser) {
		this.interUser = interUser;
	}
	
}
