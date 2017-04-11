package dao;

import entity.Auctionuser;

public interface Auctionuserdao {
	
	/**
	 * 注册
	 * @param auc
	 * @return
	 */
	public int adduser(Auctionuser auc);
	
	
	/**
	 * 登录
	 * @param username
	 * @param userpassword
	 * @return
	 */
	public int loginuser(String username,String userpassword);
	
	/**
	 * 根据ID查找用户
	 * @param username
	 * @param userpassword
	 * @return
	 */
	public Auctionuser loginbyuserid(String username,String userpassword);
	


}
