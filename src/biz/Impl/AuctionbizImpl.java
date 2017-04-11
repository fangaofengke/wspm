package biz.Impl;

import java.util.List;

import dao.Impl.AuctiondaoImpl;
import util.fenye;
import entity.Auction;
import biz.Auctionbiz;

public class AuctionbizImpl implements Auctionbiz {

	AuctiondaoImpl adi = new AuctiondaoImpl();

	/**
	 * 分页显示
	 */
	public List<Auction> listauction(fenye fen, Auction auc) {
		try {

			return adi.listauction(fen, auc);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 添加
	 */
	public int addauction(Auction auc) {
		try {

			return adi.addauction(auc);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	/**
	 * 根据ID查找
	 */
	public Auction acutionbyid(Integer auctionid) {
		try {

			return adi.acutionbyid(auctionid);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 查询正在拍卖的拍卖品
	 */
	public List<Auction> getauction() {
		try {

			return adi.getauction();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 查询未开始拍卖的拍卖品
	 */
	public Auction getauctionbyid(Integer auctionid) {
		try {

			return adi.getauctionbyid(auctionid);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 删除
	 */
	public int deleauctionbyid(Auction auc) {
		try {

			return adi.deleauctionbyid(auc);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	/***
	 * 修改拍卖品
	 */
	public int updateauction(Auction auc) {
		try {

			return adi.updateauction(auc);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

}
