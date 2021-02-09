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


	public static final String GET_ALL_STMT = "SELECT SHOP_ORDER_ID,MEM_ID,PAYMENT,to_char(TIME,'yyyy-mm-dd') TIME,SHOP_TOTAL_AMOUNT,STATUS FROM SHOP_ORDER ORDER BY SHOP_ORDER_ID";
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
		// TODO Auto-generated method stub
		return null;
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
		dao.findByPrimaryKey("SD10001");
	}
}
