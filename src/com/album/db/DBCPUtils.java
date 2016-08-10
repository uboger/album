package com.album.db;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.album.dao.impl.FolderDaoImpl;
import com.album.dao.impl.PhotoDaoImpl;
import com.album.dao.impl.UserDaoImpl;
import com.album.domain.Folder;
import com.album.domain.Photo;
import com.album.domain.User;


public class DBCPUtils {
	private static DataSource ds;
	static {
		Properties ps = new Properties();
		InputStream inStream = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
		try {
			ps.load(inStream);
			ds = BasicDataSourceFactory.createDataSource(ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		return ds;
	}
	@Test
	public void test() throws Exception{
		Properties ps = new Properties();
		InputStream inStream = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
		ps.load(inStream);
		DataSource ds = BasicDataSourceFactory.createDataSource(ps);
		QueryRunner qr = new QueryRunner(ds);
		String sql = "insert into users(username,userpwd,sex,birthday,telephone,email,address,remark) values(?,?,?,?,?,?,?,?)";
		User user = new User();
		user.setAddress("dsa");
		user.setBirthday(new Date());
		user.setEmail("sdgfdg");
		user.setRemark("sdgdsfhfdssaa");
		user.setTelephone("4565566");
		user.setUserpwd("dgdffdds");
		user.setUsername("ddddd");
		user.setSex("s");
		qr.update(sql, user.getUsername(),user.getUserpwd(),user.getSex(),user.getBirthday(),user.getTelephone(),user.getEmail(),user.getAddress(),user.getRemark());
	}
	@Test
	public void test1() throws Exception{
		UserDaoImpl dao = new UserDaoImpl();
		dao.isExist("ddddsd");
	}
	@Test
	public void test2() throws Exception{
		UserDaoImpl dao = new UserDaoImpl();
		User user = dao.findUserById(4);
		user.setAddress("fffff");
		dao.modify(user);
	}
	@Test
	public void test4() throws Exception{
		FolderDaoImpl dao = new FolderDaoImpl();
		Map<Integer,String> maps = dao.findFolders(4);
		maps.size();
	}
	@Test
	public void test3() throws Exception{
		PhotoDaoImpl dao = new PhotoDaoImpl();
		int a = dao.getTatol(5);
		System.out.println(a);
	}
	@Test
	public void test5() throws Exception{
		UserDaoImpl dao = new UserDaoImpl();
		int a = dao.getUserId("小明", "123");
		System.out.println(a);
	}
	@Test
	public void test6() throws Exception{
		UserDaoImpl dao = new UserDaoImpl();
		List<User> friends1 = dao.findAllFriend(1);
		friends1.size();
		List<User> friends2 = dao.findAllFriend(2);
		friends2.size();
	}
	@Test
	public void test7() throws Exception{
		FolderDaoImpl dao = new FolderDaoImpl();
		List<Folder> folders4 = dao.findFoldersByUserId(4);
		List<Folder> folders2 = dao.findFoldersByUserId(2);
		List<Folder> folders3 = dao.findFoldersByUserId(3);
		folders3.size();
		folders2.size();
		folders4.size();
	}
	@Test
	public void test8() throws Exception{
		PhotoDaoImpl dao = new PhotoDaoImpl();
		List<Photo> photos = dao.findPhotoByFolderId(1, 1, 6);
		photos.size();
	}
	@Test
	public void test9() throws Exception{
		UserDaoImpl dao = new UserDaoImpl();
		boolean boo = dao.isExistFriend(4, 4);
		boolean boo1 = dao.isExistFriend(2, 8);
		boolean boo2 = dao.isExistFriend(9, 8);
		System.out.println(boo+""+boo1+boo2+"");
		
	}
}
