package dao;

import entity.Auctionuser;

public interface Auctionuserdao {
	
	/**
	 * ע��
	 * @param auc
	 * @return
	 */
	public int adduser(Auctionuser auc);
	
	
	/**
	 * ��¼
	 * @param username
	 * @param userpassword
	 * @return
	 */
	public int loginuser(String username,String userpassword);
	
	/**
	 * ����ID�����û�
	 * @param username
	 * @param userpassword
	 * @return
	 */
	public Auctionuser loginbyuserid(String username,String userpassword);
	


}
