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
	 * 查找最高竞价
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
	 * 添加竞价记录
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
	 * 根据ID查找用户
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
	 * 根据ID查找拍卖品
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
	 * 查询已结束的拍卖品
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
	 * 获取开始拍卖价
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
