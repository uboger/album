package com.album.actions;

import com.album.dao.impl.UserDaoImpl;
import com.album.db.Page;
import com.album.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class FindAllUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1661845905476875592L;
	private User user;
	private UserDaoImpl interUser;
	private Page page;
	
	@Override
	public String execute() throws Exception {
		this.page = interUser.getPage(page);
		this.user = interUser.findUserById(user.getId());
		return SUCCESS;
	}
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserDaoImpl getInterUser() {
		return interUser;
	}
	public void setInterUser(UserDaoImpl interUser) {
		this.interUser = interUser;
	}
	
}
