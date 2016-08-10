package com.album.actions;

import java.util.List;

import com.album.dao.impl.UserDaoImpl;
import com.album.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddFriendAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7875348203840583806L;
	private Integer friendid;
	private UserDaoImpl interUser;
	private User user;
	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(!interUser.isExistFriend(user.getId(),friendid)){
			interUser.addFriend(user.getId(),friendid);//添加为好友
			List<User> friendList = interUser.findAllFriend(user.getId());//重新查询好友
			if(ActionContext.getContext().getSession().containsKey("friendList")){
				//更新Session
				ActionContext.getContext().getSession().remove("friendList");
				ActionContext.getContext().getSession().put("friendList", friendList);
			}
			return SUCCESS;
		}
		return INPUT;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getFriendid() {
		return friendid;
	}
	public void setFriendid(Integer friendid) {
		this.friendid = friendid;
	}
	public UserDaoImpl getInterUser() {
		return interUser;
	}
	public void setInterUser(UserDaoImpl interUser) {
		this.interUser = interUser;
	}
	
}
