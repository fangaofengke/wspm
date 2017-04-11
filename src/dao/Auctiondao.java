package dao;

import java.util.List;

import util.fenye;
import entity.Auction;

public interface Auctiondao {

	/**
	 * 分页显示
	 * @param fen
	 * @param auc
	 * @return
	 */
	public List<Auction> listauction(fenye fen,Auction auc);
	
	
	/**
	 * 添加
	 * @param auc
	 * @return
	 */
	public int addauction(Auction auc);
	
	/**
	 * 根据ID查询竞拍品
	 * @return
	 */
	public Auction acutionbyid(Integer auctionid);
	
	
	/**
	 * 获取未开始拍卖的拍卖品
	 * @param auctionid
	 * @return
	 */
	public Auction getauctionbyid(Integer auctionid);
	
	/**
	 * 根据ID删除拍卖品
	 * @param auc
	 * @return
	 */
	public int deleauctionbyid(Auction auc);
	
	
	/**
	 * 查询正在拍卖的拍卖品
	 * @return
	 */
	public List<Auction> getauction();
	
	/**
	 * 修改拍卖品
	 * @param auc
	 * @return
	 */
	public int updateauction(Auction auc);
	
}
