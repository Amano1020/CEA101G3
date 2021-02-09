package com.func.model;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;


import hibernate.util.HibernateUtil;

public class FuncDAO implements FuncDAO_interface {

	private static final String GET_ALL_STMT = "from FuncVO order by func_id";

	@Override
	public void insert(FuncVO funcVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(funcVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(FuncVO funcVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(funcVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(String func_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			FuncVO funcVO = new FuncVO();
			funcVO.setFunc_id(func_id);
			session.delete(funcVO);
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
			}

	@Override
	public FuncVO findByPrimaryKey(String func_id) {
		FuncVO funcVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			funcVO = session.get(FuncVO.class, func_id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return funcVO;
	}

	@Override
	public List<FuncVO> getAll() {
		List<FuncVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<FuncVO> query = session.createQuery(GET_ALL_STMT, FuncVO.class);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	public static void main(String[] args) {
		FuncDAO dao = new FuncDAO();
		
		//insert
//		FuncVO vo1 = new FuncVO();
//		vo1.setFunc_id("0099");
//		vo1.setFunc_name("測試用");
//		vo1.setFunc_info("就是沒用");
//		dao.insert(vo1);
		
		//update
//		FuncVO vo2 = new FuncVO();
//		vo2.setFunc_id("0099");
//		vo2.setFunc_name("測試用");
//		vo2.setFunc_info("更沒用");
//		dao.insert(vo2);
		
		//delete
//		FuncVO vo3 = new FuncVO();
//		dao.delete("0099");
		
		//getOne
//		FuncVO vo4 = dao.findByPrimaryKey("0010");
//			System.out.print(vo4.getFunc_id()+",");
//			System.out.print(vo4.getFunc_name()+",");
//			System.out.println(vo4.getFunc_info());
//			
		
		//getAll
		List<FuncVO> list = dao.getAll();
		for(FuncVO aFunc : list) {
			System.out.print(aFunc.getFunc_id()+",");
			System.out.print(aFunc.getFunc_name()+",");
			System.out.println(aFunc.getFunc_info());
		}
	}
	
}
