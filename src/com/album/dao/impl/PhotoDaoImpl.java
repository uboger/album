package com.album.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.album.dao.IDao;
import com.album.db.DBCPUtils;
import com.album.db.Page;
import com.album.domain.Folder;
import com.album.domain.Photo;

public class PhotoDaoImpl implements IDao {
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	@Override
	public <T> void save(T t) {
		Photo photo = (Photo) t;
		String sql="insert into photos(photoname,photoinfor,photopath,createtime,fid) values(?,?,?,?,?)";
		Object[] params = {photo.getPhotoname(),photo.getPhotoinfor(),photo.getPhotopath(),photo.getCreatetime(),photo.getFid()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> void update(T t) {
		
	}

	@Override
	public <T> void delete(T t) {
		
	}

	@Override
	public <T> T find(Serializable id) {
		String sql="select * from photos where id=?";
		Object[] params = {id};
		try {
			return (T) qr.query(sql, new BeanHandler<Photo>(Photo.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Page findPhotoList(Folder folder, Page page) {
		int total = getTatol(folder.getId());
		int no = 1;
		if(page!=null){
			no = page.getNo();
		}
		page=new Page<>(total, no);
		List<Photo> ps= findPhotoByFolderId(folder.getId(), page.getStartIndex(), page.getSize());
		page.setResults(ps);
		return page;
	}


	public List<Photo> findPhotoByFolderId(int fid,int startIndex,int size){
		String sql = "select * from photos where fid=? limit ?,?";
		Object[] params = {fid,startIndex,size}; 
		try {
			return qr.query(sql, new BeanListHandler<Photo>(Photo.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getTatol(Integer fid){
		String sql = "select count(id) from photos where fid=?";
		try {
			Long a = qr.query(sql, new ScalarHandler<Long>(), fid);
			return a.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void deletePhotoByFolderId(Photo photo) {
		String sql="delete from photos where id=?";
		Object[] params = {photo.getId()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
