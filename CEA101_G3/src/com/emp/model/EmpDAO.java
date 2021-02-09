package com.emp.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.emp_func.model.EmpFuncVO;

import hibernate.util.HibernateUtil;

public class EmpDAO implements EmpDAO_interface {

	private static final String GET_ALL_STMT = "from EmpVO order by emp_id";

	@Override
	public void insert(EmpVO empVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(empVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(EmpVO empVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(empVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(String emp_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			EmpVO empVO = new EmpVO();
			empVO.setEmp_id(emp_id);
			session.delete(empVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public EmpVO findByPrimaryKey(String emp_id) {
		EmpVO empVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			empVO = (EmpVO) session.get(EmpVO.class, emp_id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return empVO;
	}

	@Override
	public List<EmpVO> getAll() {
		List<EmpVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<EmpVO> query = session.createQuery(GET_ALL_STMT, EmpVO.class);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public EmpVO getUser(String emp_user_id, String emp_user_pwd) {
		EmpVO empVO = null;
		List<EmpVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<EmpVO> query = session.createQuery(GET_ALL_STMT, EmpVO.class);
			list = query.getResultList();

			for (EmpVO aEmp : list) {
				if (aEmp.getEmp_user_id().equals(emp_user_id) && aEmp.getEmp_user_pwd().contentEquals(emp_user_pwd)) {
					return empVO = aEmp;
				}
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}

		return empVO;
	}

	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();

		// insert
//		EmpVO vo1 = new EmpVO();
//		vo1.setEmp_name("安安");
//		vo1.setEmp_user_id("qwe123");
//		vo1.setEmp_user_pwd("qwe123");
//		vo1.setEmp_status(1);
//		dao.insert(vo1);

		// update
//		EmpVO vo2 = new EmpVO();
//		vo2.setEmp_id("E10011");
//		vo2.setEmp_name("你好");
//		vo2.setEmp_user_id("qwe123");
//		vo2.setEmp_user_pwd("qwe123");
//		vo2.setEmp_status(1);
//		dao.update(vo2);

		// delete
//		EmpVO vo3 = new EmpVO();
//		dao.delete("E10011");

		// findOne
//		EmpVO vo4 = dao.findByPrimaryKey("E10001");
//		System.out.print(vo4.getEmp_id() + ",");
//		System.out.print(vo4.getEmp_name() + ",");
//		System.out.print(vo4.getEmp_user_id() + ",");
//		System.out.print(vo4.getEmp_user_pwd() + ",");
//		System.out.println(vo4.getEmp_status());

		// getAll
		List<EmpVO> list = dao.getAll();
		for (EmpVO aEmp : list) {
			System.out.print(aEmp.getEmp_id() + ",");
			System.out.print(aEmp.getEmp_name() + ",");
			System.out.print(aEmp.getEmp_user_id() + ",");
			System.out.print(aEmp.getEmp_user_pwd() + ",");
			System.out.print(aEmp.getEmp_status() + ",");
			Set<EmpFuncVO> set = aEmp.getEmpFuncs();
			
			for(EmpFuncVO func : set) {
				System.out.print(func.getFunc_id() + ",");
			}
			System.out.println();
		}

	}
}
