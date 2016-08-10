package com.album.actions;

import com.album.dao.IDao;
import com.opensymphony.xwork2.ActionSupport;

public class SelectMyInforAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8715815192036514060L;
	
	private IDao interUser;

	public IDao getInterUser() {
		return interUser;
	}

	public void setInterUser(IDao interUser) {
		this.interUser = interUser;
	}
	
}
