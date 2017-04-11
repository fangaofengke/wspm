package dao.Impl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import util.HibernateSessionFactory;
import util.fenye;
import dao.Auctiondao;
import entity.Auction;
import entity.Auctionrecord;
import entity.Auctionuser;

public class AuctiondaoImpl implements Auctiondao {

	Session session = null;

	Transaction transaction = null;

	Query query = null;

	SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

	/**
	 * 分页显示
	 */
	public List<Auction> listauction(fenye fen, Auction auc) {

		List<Auction> list = new ArrayList<Auction>();

		try {

			session = HibernateSessionFactory.getSession();

			Criteria criteria = session.createCriteria(Auction.class);

			Criteria criteria2 = session.createCriteria(Auction.class);
			

			if (auc.getAuctionname() != null
					&& !auc.getAuctionname().equals("")) {

				criteria.add(Restrictions.ilike("auctionname",
						auc.getAuctionname(), MatchMode.ANYWHERE));

				criteria2.add(Restrictions.ilike("auctionname",
						auc.getAuctionname(), MatchMode.ANYWHERE));
			}
			if (auc.getAuctiondesc() != null
					&& !auc.getAuctiondesc().equals("")) {

				criteria.add(Restrictions.ilike("auctiondesc",
						auc.getAuctiondesc(), MatchMode.ANYWHERE));

				criteria2.add(Restrictions.ilike("auctiondesc",
						auc.getAuctiondesc(), MatchMode.ANYWHERE));

			}
			if (auc.getAuctionstarttime() != null
					&& !auc.getAuctionstarttime().equals("")) {

				criteria.add(Restrictions.ge("auctionstarttime",
						auc.getAuctionstarttime()));

				criteria2.add(Restrictions.ge("auctionstarttime",
						auc.getAuctionstarttime()));
			}

			if (auc.getAuctionendtime() != null
					&& !auc.getAuctionendtime().equals("")) {
				criteria.add(Restrictions.le("auctionendtime",
						auc.getAuctionendtime()));

				criteria2.add(Restrictions.le("auctionendtime",
						auc.getAuctionendtime()));
			}
			if (auc.getAuctionstartprice() != null
					&& !auc.getAuctionstartprice().equals("")) {
				criteria.add(Restrictions.eq("auctionstartprice",
						auc.getAuctionstartprice()));

				criteria2.add(Restrictions.eq("auctionstartprice",
						auc.getAuctionstartprice()));
			}

			fen.setCount(Integer.parseInt(criteria
					.setProjection(Projections.rowCount()).uniqueResult()
					.toString()));

			criteria2.setFirstResult((fen.getPageindex() - 1)
					* fen.getPagesie());
			criteria2.setMaxResults(fen.getPagesie());

			list = criteria2.list();

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return null;
	}

	/**
	 * 添加
	 */
	public int addauction(Auction auc) {
		try {

			session = HibernateSessionFactory.getSession();

			transaction = session.beginTransaction();

			session.save(auc);

			transaction.commit();

			return 1;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return 0;
	}

	/**
	 * 根据ID找拍卖品
	 */
	public Auction acutionbyid(Integer auctionid) {
		Auction auc = null;
		try {

			session = HibernateSessionFactory.getSession();

			List<Auction> list = session
					.getNamedQuery("getauctionbyid")
					.setParameter("auctionid", auctionid)
					.setParameter("auctionstarttime",
							df.format(System.currentTimeMillis()))
					.setParameter("auctionendtime",
							df.format(System.currentTimeMillis())).list();
			;

			for (Auction auction : list) {

				auc = auction;

				InputStream binaryStream = auc.getAuctionpic()
						.getBinaryStream();

				FileOutputStream fos = new FileOutputStream("C:/Users/hp/Workspaces/MyEclipse Professional 2014/Y2_Chap12/WebRoot/images/"
						+ auc.getPriname());

				int len = 0;

				while ((len = binaryStream.read()) != -1) {

					fos.write(len);

				}

				fos.close();
			}

			return auc;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return null;
	}

	/**
	 * 查询正在拍卖的拍卖品
	 */
	public List<Auction> getauction() {
		List<Auction> list = new ArrayList<Auction>();
		try {

			session = HibernateSessionFactory.getSession();

			list = session
					.getNamedQuery("getauction")
					.setParameter("auctionstarttime",
							df.format(System.currentTimeMillis()))
					.setParameter("auctionendtime",
							df.format(System.currentTimeMillis())).list();

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return null;
	}

	/**
	 * 查询未开始竞拍的拍卖品
	 */
	public Auction getauctionbyid(Integer auctionid) {
		Auction auc = null;
		try {

			session = HibernateSessionFactory.getSession();

			auc = (Auction) session
					.getNamedQuery("auctionbyid")
					.setParameter("auctionstarttime",
							df.format(System.currentTimeMillis()))
					.setParameter("auctionid", auctionid).uniqueResult();

			return auc;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return null;
	}

	/**
	 * 删除拍卖品
	 */
	public int deleauctionbyid(Auction auc) {
		try {

			session = HibernateSessionFactory.getSession();

			transaction = session.beginTransaction();

			session.delete(auc);

			transaction.commit();

			return 1;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return 0;
	}

	/**
	 * 修改拍卖品
	 */
	public int updateauction(Auction auc) {
		try {

			session = HibernateSessionFactory.getSession();

			transaction = session.beginTransaction();

			session.update(auc);

			transaction.commit();

			return 1;

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			// TODO: handle exception
		} finally {

			HibernateSessionFactory.closeSession();

		}
		return 0;
	}

}
