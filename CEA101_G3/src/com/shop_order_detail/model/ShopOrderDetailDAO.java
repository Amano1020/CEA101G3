package com.shop_order_detail.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.query.Query;
import org.hibernate.Session;

import com.shop_order.model.ShopOrderVO;

import hibernate.util.HibernateUtil;

public class ShopOrderDetailDAO implements ShopOrderDetailDAO_interface{

	public static final String GET_ALL_STMT = "from ShopOrderDetailVO order by shop_order_id";
	public static final String GET_ONE_STMT = "from ShopOrderDetailVO where shop_order_id=?0";
	public void insert(ShopOrderDetailVO shopOrderDetailVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(shopOrderDetailVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}	
	}
	
	public void update(ShopOrderDetailVO shopOrderDetailVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(shopOrderDetailVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}	
	}

	public void delete(String shop_order_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("delete ShopOrderDetailVO where shop_order_id=?0");
			query.setParameter(0, shop_order_id);
			query.executeUpdate();
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
		
	public List<ShopOrderDetailVO> findByPrimaryKey(String shop_order_id) {
		List<ShopOrderDetailVO> list = new ArrayList<ShopOrderDetailVO>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<ShopOrderDetailVO> query = session.createQuery(GET_ONE_STMT, ShopOrderDetailVO.class);
			query.setParameter(0, shop_order_id);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	public List<ShopOrderDetailVO> getAll(){
		List<ShopOrderDetailVO> list = new ArrayList<ShopOrderDetailVO>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<ShopOrderDetailVO> query = session.createQuery(GET_ALL_STMT, ShopOrderDetailVO.class);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public static void main(String[] args) {
		ShopOrderDetailDAO dao = new ShopOrderDetailDAO();
		
		
		ShopOrderDetailVO vo = new ShopOrderDetailVO();
		ShopOrderVO shopOrderVO = new ShopOrderVO();
		shopOrderVO.setShop_order_id("SD10001");		
		//insert
//		vo.setShop_order_id("SD10001");
		vo.setShopOrderVO(shopOrderVO);
		vo.setItem_id("I10014");
		vo.setItem_promotion_id("IP10001");
		vo.setNote("nice");
		vo.setQuantity(2);
		vo.setItem_price(300);
		dao.insert(vo);
		
		//update
//		vo.setShop_order_id("SD10014");
//		vo.setItem_id("I10001");
//		vo.setItem_promotion_id("IP10001");
//		vo.setNote("niceeeeeeee");
//		vo.setQuantity(2);
//		vo.setItem_price(300);
//		dao.update	(vo);
		
		//delete
//		dao.delete("SD10010");
		
		//getOne
//		List<ShopOrderDetailVO> list = dao.findByPrimaryKey("SD10001");
//		for(ShopOrderDetailVO shdVO : list) {
//			System.out.print(shdVO.getShop_order_id() + ",");
//			System.out.print(shdVO.getItem_id() + ",");
//			System.out.print(shdVO.getItem_price() + ",");
//			System.out.print(shdVO.getItem_promotion_id() + ",");
//			System.out.print(shdVO.getQuantity() + ",");
//			System.out.println(shdVO.getNote());
//		}
		
		//getAll
//		List<ShopOrderDetailVO> list = dao.getAll();
//		for(ShopOrderDetailVO shdVO : list) {
//			System.out.print(shdVO.getShop_order_id() + ",");
//			System.out.print(shdVO.getItem_id() + ",");
//			System.out.print(shdVO.getItem_price() + ",");
//			System.out.print(shdVO.getItem_promotion_id() + ",");
//			System.out.print(shdVO.getQuantity() + ",");
//			System.out.println(shdVO.getNote());
//		}		
	}
}
