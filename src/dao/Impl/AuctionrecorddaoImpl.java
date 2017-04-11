package dao.Impl;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import util.HibernateSessionFactory;
import dao.Auctionrecorddao;
import entity.Auction;
import entity.Auctionrecord;
import entity.Auctionuser;

public class AuctionrecorddaoImpl implements Auctionrecorddao {

	Session session = null;

	Transaction transaction = null;

	Query query = null;

	/**
	 * 查找最高竞价
	 */
	public double getmaxprice(Integer auction) {
		try {

			session = HibernateSessionFactory.getSession();

			double auctionprice = Double.parseDouble(session
					.createCriteria(Auctionrecord.class, "a")
					.createAlias("auction", "u")
					.setProjection(Projections.max("auctionprice"))
					.add(Restrictions.eq("u.auctionid", auction))
					.uniqueResult().toString());

			return auctionprice;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return 0;
	}

	/**
	 * 添加
	 */
	public int addrecord(Auctionrecord auc) {
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
	 * 根据ID查找用户
	 */
	public Auctionuser getauctionuser(Integer auctionuserid) {

		Auctionuser auc = null;

		try {

			session = HibernateSessionFactory.getSession();

			auc = (Auctionuser) session.get(Auctionuser.class, auctionuserid);

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
	 * 根据ID查找拍卖品
	 */
	public Auction getauction(Integer auctionid) {

		Auction auc = null;

		try {

			session = HibernateSessionFactory.getSession();

			auc = (Auction) session.get(Auction.class, auctionid);

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
	 * 根据ID查看竞拍结果
	 */
	public List<Auctionrecord> getauctionrecord(Auctionuser auc) {
		List<Auctionrecord> list = new ArrayList<Auctionrecord>();
		try {

			SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

			session = HibernateSessionFactory.getSession();

			query = session.getNamedQuery("getacutionrecords");

			query.setParameter("userid", auc);

			query.setParameter("auctionendtime",
					df.format(System.currentTimeMillis()));

			list = query.list();

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
	 * 获取开始拍卖价
	 */
	public double getstartprice(Integer auctionid) {

		try {

			session = HibernateSessionFactory.getSession();

			double price = Double.parseDouble(session
					.createCriteria(Auction.class)
					.setProjection(Property.forName("auctionstartprice"))
					.add(Restrictions.eq("auctionid", auctionid))
					.uniqueResult().toString());

			return price;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {

			HibernateSessionFactory.closeSession();

		}

		return 0.0;
	}

}
