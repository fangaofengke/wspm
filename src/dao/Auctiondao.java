package dao;

import java.util.List;

import util.fenye;
import entity.Auction;

public interface Auctiondao {

	/**
	 * ��ҳ��ʾ
	 * @param fen
	 * @param auc
	 * @return
	 */
	public List<Auction> listauction(fenye fen,Auction auc);
	
	
	/**
	 * ���
	 * @param auc
	 * @return
	 */
	public int addauction(Auction auc);
	
	/**
	 * ����ID��ѯ����Ʒ
	 * @return
	 */
	public Auction acutionbyid(Integer auctionid);
	
	
	/**
	 * ��ȡδ��ʼ����������Ʒ
	 * @param auctionid
	 * @return
	 */
	public Auction getauctionbyid(Integer auctionid);
	
	/**
	 * ����IDɾ������Ʒ
	 * @param auc
	 * @return
	 */
	public int deleauctionbyid(Auction auc);
	
	
	/**
	 * ��ѯ��������������Ʒ
	 * @return
	 */
	public List<Auction> getauction();
	
	/**
	 * �޸�����Ʒ
	 * @param auc
	 * @return
	 */
	public int updateauction(Auction auc);
	
}
