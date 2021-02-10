package com.shop_order.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.emp.model.EmpVO;
import com.roomorder.model.RoomOrderVO;
import com.shop_order_detail.model.ShopOrderDetailDAO;
import com.shop_order_detail.model.ShopOrderDetailVO;

import hibernate.util.HibernateUtil;

public class ShopOrderDAO implements ShopOrderDAO_interface {


	public static final String GET_ALL_STMT = "from ShopOrderVO order by shop_order_id";
	public static final String GETONE_BY_MEMID = "SELECT * FROM SHOP_ORDER WHERE MEM_ID = ?";
	@Override
	public void insert(ShopOrderVO shop_orderVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(shop_orderVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(ShopOrderVO shop_orderVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(shop_orderVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String shop_order_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			ShopOrderVO vo = session.get(ShopOrderVO.class, shop_order_id);
			session.delete(vo);
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public ShopOrderVO findByPrimaryKey(String shop_order_id) {
		ShopOrderVO shopOrderVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			shopOrderVO = session.get(ShopOrderVO.class, shop_order_id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return shopOrderVO;
	}
	@Override
	public List<ShopOrderVO> getAll() {
		List<ShopOrderVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<ShopOrderVO> query = session.createQuery(GET_ALL_STMT,ShopOrderVO.class);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	@Override
	public List<ShopOrderVO> getByMemId(String mem_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insertWithOrderDetail(ShopOrderVO shopOrderVO, List<ShopOrderDetailVO> list) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		ShopOrderDAO dao = new ShopOrderDAO();
		ShopOrderVO vo = new ShopOrderVO();
		
		//insert
//		vo.setMem_id("M10001");
//		vo.setPayment("creditcard");
//		vo.setTime(new Date(System.currentTimeMillis()));
//		vo.setShop_total_amount(100000F);
//		vo.setStatus(1);
//		dao.insert(vo);
		
		//update
//		vo.setShop_order_id("SD10012");
//		vo.setMem_id("M10001");
//		vo.setPayment("creditcard");
//		vo.setTime(new Date(System.currentTimeMillis()));
//		vo.setShop_total_amount(999999F);
//		vo.setStatus(1);
//		dao.update(vo);
		
		//delete
//		dao.delete("SD10013");
		
		//getOne
		vo = dao.findByPrimaryKey("SD10001");
		System.out.print(vo.getShop_order_id() + ",");
		System.out.print(vo.getShop_total_amount() + ",");
		System.out.print(vo.getMem_id() + ",");
		System.out.print(vo.getPayment() + ",");
		System.out.print(vo.getStatus() + ",");
		System.out.print(vo.getTime());
		System.out.println("\n-----------------");
		Set<ShopOrderDetailVO> set = vo.getShopOrderDetails();
		for(ShopOrderDetailVO shopOrderDetailVO : set) {
			System.out.print(shopOrderDetailVO.getShop_order_id() + ",");
			System.out.print(shopOrderDetailVO.getItem_id() + ",");
			System.out.print(shopOrderDetailVO.getItem_promotion_id() + ",");
			System.out.print(shopOrderDetailVO.getItem_price() + ",");
			System.out.print(shopOrderDetailVO.getQuantity() + ",");
			System.out.println(shopOrderDetailVO.getNote());
		}
		
		
//		List<ShopOrderVO> list = dao.getAll();
//		for(ShopOrderVO shopOrderVO : list) {
//			System.out.print(shopOrderVO.getShop_order_id() + ",");
//			System.out.print(shopOrderVO.getShop_total_amount() + ",");
//			System.out.print(shopOrderVO.getMem_id() + ",");
//			System.out.print(shopOrderVO.getPayment() + ",");
//			System.out.print(shopOrderVO.getStatus() + ",");
//			System.out.print(shopOrderVO.getTime());
//			System.out.println("\n-----------------");
//			Set<ShopOrderDetailVO> set = vo.getShopOrderDetails();
//			for(ShopOrderDetailVO shopOrderDetailVO : set) {
//				System.out.print(shopOrderDetailVO.getShop_order_id() + ",");
//				System.out.print(shopOrderDetailVO.getItem_id() + ",");
//				System.out.print(shopOrderDetailVO.getItem_promotion_id() + ",");
//				System.out.print(shopOrderDetailVO.getItem_price() + ",");
//				System.out.print(shopOrderDetailVO.getQuantity() + ",");
//				System.out.println(shopOrderDetailVO.getNote());
//			}
//			System.out.println();
//		}
	}
}
