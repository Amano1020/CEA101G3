package com.emp_func.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.emp.model.EmpVO;
import com.func.model.FuncDAO;
import com.func.model.FuncVO;
import com.mysql.fabric.xmlrpc.base.Array;

import hibernate.util.HibernateUtil;

public class EmpFuncDAO implements EmpFuncDAO_interface {

	private static final String GET_ALL_STMT ="from EmpFuncVO order by emp_id";
	private static final String GET_BY_EMP = "from EmpFuncVO where emp_id=?0";
	
	@Override
	public void insert(EmpFuncVO empFuncVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(empFuncVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(String emp_id, String func_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("delete from EmpFuncVO where emp_id=?0 and func_id=?1");
			query.setParameter(0, emp_id);
			query.setParameter(1, func_id);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public List<EmpFuncVO> findByPrimaryKey(String emp_id) {

		List<EmpFuncVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<EmpFuncVO> query = session.createQuery(GET_BY_EMP,EmpFuncVO.class);
			query.setParameter(0, emp_id);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
		
	}

	@Override
	public List<EmpFuncVO> getAll() {
		List<EmpFuncVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<EmpFuncVO> query = session.createQuery(GET_ALL_STMT, EmpFuncVO.class);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public List<String> findFuncs(String emp_id) {
		List<EmpFuncVO> list = null;
		List<String> list2 = new ArrayList<String>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<EmpFuncVO> query = session.createQuery(GET_BY_EMP, EmpFuncVO.class);
			query.setParameter(0,emp_id);
			list = query.getResultList();
			for(EmpFuncVO efVO : list) {
				list2.add(efVO.getFunc_id());
			}
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list2;
	}
	public static void main(String[] args) {
		EmpFuncDAO dao = new EmpFuncDAO();
		EmpFuncVO empFuncVO = new EmpFuncVO();
		
//		empFuncVO.setEmp_id("E10001");
//		empFuncVO.setFunc_id("0010");
//		dao.insert(empFuncVO);
		
		dao.delete("E10001", "0010");
		
		//findByPrimaryKey
//		List<EmpFuncVO> list = dao.findByPrimaryKey("E10001");
//		for(EmpFuncVO empf : list) {
//			System.out.print(empf.getEmp_id()+",");
//			System.out.println(empf.getFunc_id());
//		}

		
//		List<String> list2 = dao.findFuncs("E10001");
//		for(String str : list2)
//			System.out.println(str);
		
		//getAll 
		List<EmpFuncVO> list = dao.getAll();
		for(EmpFuncVO aEmpFunc : list) {
			System.out.print(aEmpFunc.getEmp_id()+ ",");
			System.out.println(aEmpFunc.getFunc_id());
		}
	}

}
