package biz.Impl;

import dao.Impl.AuctionuserdaoImpl;
import entity.Auction;
import entity.Auctionuser;
import biz.Auctionuserbiz;

public class AuctionuserbizImpl implements Auctionuserbiz {

	AuctionuserdaoImpl adi=new AuctionuserdaoImpl();

	/**
	 * 注册
	 */
	public int adduser(Auctionuser auc) {
		try {

			return adi.adduser(auc);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	/**
	 * 登录
	 */
	public int loginuser(String username, String userpassword) {
		try {

			return adi.loginuser(username, userpassword);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	/**
	 * 根据ID查找用户
	 */
	public Auctionuser loginbyuserid(String username, String userpassword) {
		try {
			
			return adi.loginbyuserid(username, userpassword);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	

}
