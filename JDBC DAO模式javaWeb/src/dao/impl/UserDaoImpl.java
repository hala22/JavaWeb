package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.IUserDao;
import entity.User;
import javaWeb.utils.JDBCUtils;

public class UserDaoImpl implements IUserDao{
	

	@Override
	public int insert(User user) {
		 
        String sql = "insert into m_user values(seq_m_user.nextval,?,?)";
		Object[] params = {user.getName(),user.getPwd()};
		int row = -1;
		try {
			row = JDBCUtils.getQueryRunner().update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		}
		return row;
	}

	@Override
	public User queryByName(String name) {
		String sql = "select * from m_user where name = ?";
		User user = null;
		try {
			user = JDBCUtils.getQueryRunner().query(sql , new BeanHandler<>(User.class), name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public User queryByUser(User user) {
		String sql = "select * from m_user where name = ?and pwd = ?";
		User u = null;
		try {
			u = JDBCUtils.getQueryRunner().query(sql , new BeanHandler<>(User.class), user.getName(),user.getPwd());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<User> queryAll() {
		String sql = "select * from m_user";
		List<User> list = null;
		try {
			list = JDBCUtils.getQueryRunner().query(sql, new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
