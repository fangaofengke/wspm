package biz;

import java.util.List;

import entity.Auction;
import entity.Auctionrecord;
import entity.Auctionuser;

public interface Auctionrecordbiz {

	/**
	 * 查找最高竞价
	 * 
	 * @param auctionid
	 * @return
	 */
	public double getmaxprice(Integer auction);

	/**
	 * 添加竞价记录
	 * 
	 * @param auc
	 * @return
	 */
	public int addrecord(Auctionrecord auc);

	/**
	 * 根据ID查找用户
	 * 
	 * @param auctionuserid
	 * @return
	 */
	public Auctionuser getauctionuser(Integer auctionuserid);

	/**
	 * 根据ID查找拍卖品
	 * 
	 * @param auctionid
	 * @return
	 */
	public Auction getauction(Integer auctionid);

	/**
	 * 根据用户ID查看竞拍结果
	 * 
	 * @param auctionuserid
	 * @return
	 */
	public List<Auctionrecord> getauctionrecord(Auctionuser auc);

	/**
	 * 获取开始拍卖价
	 * 
	 * @param auctionid
	 * @return
	 */
	public double getstartprice(Integer auctionid);
}
