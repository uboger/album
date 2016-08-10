package com.album.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.album.dao.IDao;
import com.album.db.DBCPUtils;
import com.album.domain.Folder;

public class FolderDaoImpl implements IDao {
	private  UserDaoImpl interUser;
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	public UserDaoImpl getInterUser() {
		return interUser;
	}

	public void setInterUser(UserDaoImpl interUser) {
		this.interUser = interUser;
	}

	@Override
	public <T> void save(T t) {
		Folder folder = (Folder) t;
		String sql="insert into folders(foldername,folderinfor,createtime,limitid,uid) values(?,?,?,?,?)";
		Object[] params = {folder.getFoldername(),folder.getFolderinfor(),folder.getCreatetime(),folder.getLimitid(),folder.getUid()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public <T> void update(T t) {
		Folder folder = (Folder) t;
		String sql="update folders set foldername=?,folderinfor=?,createtime=?,limitid=?,uid=?, where id=?";
		Object[] params = {folder.getFoldername(),folder.getFolderinfor(),folder.getCreatetime(),folder.getLimitid(),folder.getUid(),folder.getId()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public <T> void delete(T t) {
		// TODO Auto-generated method stub

	}



	public List<Folder> findFoldersByUserId(int userid) {
		String sql = "select * from folders where uid=?" ;
		try {
			return qr.query(sql, new BeanListHandler<Folder>(Folder.class), userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T find(Serializable id) {
		String sql="select * from folders where id=?";
		Object[] params = {id};
		try {
		return 	(T) qr.query(sql, new BeanHandler<Folder>(Folder.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int createFolder(Folder folder) {
		String sql="insert into folders(foldername,folderinfor,createtime,limitid,uid) values(?,?,?,?,?)";
		Object[] params = {folder.getFoldername(),folder.getFolderinfor(),folder.getCreatetime(),folder.getLimitid(),folder.getUid()};
		try {
			return qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Map<Integer, String> findFolders(Integer uid) {
		Map<Integer, String> maps = new HashMap<Integer, String>();
		String sql="select id,foldername from folders where uid=?";
		Connection conn =null;
		try {
			conn = qr.getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				maps.put(rs.getInt("id"), rs.getString("foldername"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maps;
	}

}
