package dao;

import java.util.List;

import entity.User;

public interface IUserDao {
	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	public int insert(User user);
	
	/**
	 * 根据用户名查询
	 * @param name
	 * @return
	 */
	public User queryByName(String name);
	/**
	 * 根据用户名密码查询
	 * @param user
	 * @return
	 */
	public User queryByUser(User user);
	/**
	 * 查询所有
	 * @return
	 */
	public List<User> queryAll();
}











