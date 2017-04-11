package biz.Impl;

import java.util.List;

import dao.Impl.AuctionrecorddaoImpl;
import entity.Auction;
import entity.Auctionrecord;
import entity.Auctionuser;
import biz.Auctionrecordbiz;

public class AuctionrecordbizImpl implements Auctionrecordbiz {

	AuctionrecorddaoImpl adi = new AuctionrecorddaoImpl();

	/**
	 * ������߾���
	 */
	public double getmaxprice(Integer auction){
		try {

			return adi.getmaxprice(auction);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	/**
	 * ��Ӿ��ۼ�¼
	 */
	public int addrecord(Auctionrecord auc) {
		try {

			return adi.addrecord(auc);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	/**
	 * ����ID�����û�
	 */
	public Auctionuser getauctionuser(Integer auctionuserid) {
		try {

			return adi.getauctionuser(auctionuserid);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ����ID��������Ʒ
	 */
	public Auction getauction(Integer auctionid) {
		try {

			return adi.getauction(auctionid);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ��ѯ�ѽ���������Ʒ
	 */
	public List<Auctionrecord> getauctionrecord(Auctionuser auc) {
		try {
			
			return adi.getauctionrecord(auc);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * ��ȡ��ʼ������
	 */
	public double getstartprice(Integer auctionid) {
		try {
			
			return adi.getstartprice(auctionid);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

}
