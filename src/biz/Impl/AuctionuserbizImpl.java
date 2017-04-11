package biz.Impl;

import dao.Impl.AuctionuserdaoImpl;
import entity.Auction;
import entity.Auctionuser;
import biz.Auctionuserbiz;

public class AuctionuserbizImpl implements Auctionuserbiz {

	AuctionuserdaoImpl adi=new AuctionuserdaoImpl();

	/**
	 * ע��
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
	 * ��¼
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
	 * ����ID�����û�
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
