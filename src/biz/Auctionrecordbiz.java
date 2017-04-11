package biz;

import java.util.List;

import entity.Auction;
import entity.Auctionrecord;
import entity.Auctionuser;

public interface Auctionrecordbiz {

	/**
	 * ������߾���
	 * 
	 * @param auctionid
	 * @return
	 */
	public double getmaxprice(Integer auction);

	/**
	 * ��Ӿ��ۼ�¼
	 * 
	 * @param auc
	 * @return
	 */
	public int addrecord(Auctionrecord auc);

	/**
	 * ����ID�����û�
	 * 
	 * @param auctionuserid
	 * @return
	 */
	public Auctionuser getauctionuser(Integer auctionuserid);

	/**
	 * ����ID��������Ʒ
	 * 
	 * @param auctionid
	 * @return
	 */
	public Auction getauction(Integer auctionid);

	/**
	 * �����û�ID�鿴���Ľ��
	 * 
	 * @param auctionuserid
	 * @return
	 */
	public List<Auctionrecord> getauctionrecord(Auctionuser auc);

	/**
	 * ��ȡ��ʼ������
	 * 
	 * @param auctionid
	 * @return
	 */
	public double getstartprice(Integer auctionid);
}
