package com.album.dao;

import java.io.Serializable;



public interface IDao {
	/**\
	 * save object
	 * @param t
	 */
	<T> void save(T t);
	/**
	 * update object
	 * @param t
	 */
	<T> void update(T t);
	/**
	 * delete object
	 * @param t
	 */
	<T> void delete(T t);
	/**
	 * find object
	 * @param t
	 * @return
	 */
	<T> T  find(Serializable id);
}
