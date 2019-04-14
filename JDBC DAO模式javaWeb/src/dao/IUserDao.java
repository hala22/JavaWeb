package dao;

import java.util.List;

import entity.User;

public interface IUserDao {
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public int insert(User user);
	
	/**
	 * �����û�����ѯ
	 * @param name
	 * @return
	 */
	public User queryByName(String name);
	/**
	 * �����û��������ѯ
	 * @param user
	 * @return
	 */
	public User queryByUser(User user);
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<User> queryAll();
}











