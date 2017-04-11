package biz.Impl;

import java.util.List;

import dao.Impl.AuctiondaoImpl;
import util.fenye;
import entity.Auction;
import biz.Auctionbiz;

public class AuctionbizImpl implements Auctionbiz {

	AuctiondaoImpl adi = new AuctiondaoImpl();

	/**
	 * ��ҳ��ʾ
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
	 * ���
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
	 * ����ID����
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
	 * ��ѯ��������������Ʒ
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
	 * ��ѯδ��ʼ����������Ʒ
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
	 * ɾ��
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
	 * �޸�����Ʒ
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
