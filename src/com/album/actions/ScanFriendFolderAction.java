package com.album.actions;

import java.util.List;

import com.album.dao.impl.FolderDaoImpl;
import com.album.dao.impl.UserDaoImpl;
import com.album.domain.Folder;
import com.album.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ScanFriendFolderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4534413456250673702L;

	private UserDaoImpl interUser;
	private FolderDaoImpl interFolder;
	private List<Folder> friendFolders;
	private int userid;
	private int friendid;
	private User friend;
	private boolean ifIsMyFriend;
	
	@Override
	public String execute() throws Exception {
		int id = ((User)ActionContext.getContext().getSession().get("user")).getId();
		this.friend=interUser.findUserById(friendid);
		this.ifIsMyFriend=interUser.isExistFriend(id, friendid);
		System.out.println("isFriend="+ifIsMyFriend);
		this.friendFolders=interFolder.findFoldersByUserId(friendid);
		return SUCCESS;
	}
	



	public boolean isIfIsMyFriend() {
		return ifIsMyFriend;
	}




	public void setIfIsMyFriend(boolean ifIsMyFriend) {
		this.ifIsMyFriend = ifIsMyFriend;
	}




	public User getFriend() {
		return friend;
	}


	public void setFriend(User friend) {
		this.friend = friend;
	}


	
	public List<Folder> getFriendFolders() {
		return friendFolders;
	}

	public void setFriendFolders(List<Folder> friendFolders) {
		this.friendFolders = friendFolders;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}

	public UserDaoImpl getInterUser() {
		return interUser;
	}
	public void setInterUser(UserDaoImpl interUser) {
		this.interUser = interUser;
	}
	public FolderDaoImpl getInterFolder() {
		return interFolder;
	}
	public void setInterFolder(FolderDaoImpl interFolder) {
		this.interFolder = interFolder;
	}

	
}
