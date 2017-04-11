package dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import util.HibernateSessionFactory;
import dao.Auctionuserdao;
import entity.Auctionuser;

public class AuctionuserdaoImpl implements Auctionuserdao {

	Session session = null;

	Transaction transaction = null;

	Query query = null;

	/**
	 * 注册
	 */
	public int adduser(Auctionuser auc) {
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
	 * 登录
	 */
	public int loginuser(String username, String userpassword) {
		try {

			session = HibernateSessionFactory.getSession();

			int count = Integer.parseInt(session
					.createCriteria(Auctionuser.class)
					.add(Restrictions.and(
							Restrictions.eq("username", username),
							Restrictions.eq("userpassword", userpassword)))
					.setProjection(Projections.rowCount()).uniqueResult()
					.toString());

			return count;
		} catch (Exception e) {
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
	public Auctionuser loginbyuserid(String username, String userpassword) {
		Auctionuser auc = null;
		try {

			session = HibernateSessionFactory.getSession();

			List<Integer> list = session
					.createCriteria(Auctionuser.class)
					.add(Restrictions.and(
							Restrictions.eq("username", username),
							Restrictions.eq("userpassword", userpassword)))
					.setProjection(Property.forName("userid")).list();

			for (Integer integer : list) {

				auc = (Auctionuser) session.get(Auctionuser.class, integer);
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

}
