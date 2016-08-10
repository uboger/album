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
import com.album.domain.User;

public class UserDaoImpl implements IDao {
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	@Override
	public <T> void save(T t) {
		User user = (User) t;
		Object[] params = {user.getUsername(),user.getUserpwd(),user.getSex(),user.getBirthday(),user.getTelephone(),user.getEmail(),user.getAddress(),user.getRemark()};
		String sql="insert into users(username,userpwd,sex,birthday,telephone,email,address,remark) values(?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> void update(T t) {
		User user = (User) t;
		Object[] params = {user.getUsername(),user.getUserpwd(),user.getSex(),user.getBirthday(),user.getTelephone(),user.getEmail(),user.getAddress(),user.getRemark(),user.getId()};
		String sql="UPDATE users SET username=?,userpwd=?,sex=?,birthday=?,telephone=?,email=?,address=?,remark=? WHERE id=?";
		try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public <T> void delete(T t) {
		User user = (User) t;
		String sql ="select * from users where id=?";
		try {
			qr.update(sql, user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public boolean isExist(String username){
		String sql ="select * from users where username=?";
		try {
			User user = qr.query(sql, new BeanHandler<User>(User.class), username);
			if(user==null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public boolean login(User user) {
		String sql ="select * from users where username=? and userpwd=?";
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getUserpwd());
			if(user!=null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public User login1(User user) {
		String sql ="select * from users where username=? and userpwd=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getUserpwd());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public int getUserId(String username, String userpwd) {
		String sql ="select id from users where username=? and userpwd=?";
		try {
			return qr.query(sql, new ScalarHandler<Integer>(), username,userpwd);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<User> findAllFriend(int userid) {
		String sql = "select * from users where id in(select friendid from friends where userid=?)";
		Object[] params = {userid};
		try {
			return qr.query(sql, new BeanListHandler<User>(User.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findUserById(int id) {
		String sql ="select * from users where id=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public <T> T find(Serializable id) {
		String sql ="select * from users where id=?";
		try {
			User user =qr.query(sql, new BeanHandler<User>(User.class), id);
			return (T) user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public int modify(User user) {
		Object[] params = {user.getUsername(),user.getUserpwd(),user.getSex(),user.getBirthday(),user.getTelephone(),user.getEmail(),user.getAddress(),user.getRemark(),user.getId()};
		String sql="UPDATE users SET username=?,userpwd=?,sex=?,birthday=?,telephone=?,email=?,address=?,remark=? WHERE id=?";
		try {
			int i = qr.update(sql,params);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Page getPage(Page page) {
		int no=1;
		int total = getTotal();
		if(page!=null){
			no=page.getNo();
		}
		page = new Page<>(total, no);
		List<User> users = findUsersByLimit(page.getStartIndex(),page.getSize());
		page.setResults(users);
		return page;
	}

	private List<User> findUsersByLimit(int startIndex, int size) {
		String sql="select * from users limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<User>(User.class),startIndex,size);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private int getTotal() {
		String sql="select count(id) from users";
		try {
			Long a = qr.query(sql, new ScalarHandler<Long>());
			return a.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean isExistFriend(Integer id, Integer friendid) {
		System.out.println("userid:"+id+",<>friendid:"+friendid);
		String sql = "select id from friends where (userid=?&&friendid=?)||(userid=?&&friendid=?)";
		Object[] params={id,friendid,friendid,id};
		try {
			Integer a = qr.query(sql, new ScalarHandler<Integer>(), params);
			return (a!=null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addFriend(Integer id, Integer friendid) {
		String sql="insert into friends(userid,friendid) values(?,?)";
		Object[] params = {id,friendid};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
