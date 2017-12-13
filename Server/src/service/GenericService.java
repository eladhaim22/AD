package service;

import org.hibernate.Session;

import hbt.HibernateUtil;

public class GenericService {
	protected void openSession() {
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
	}
	protected void commitAndCloseSession() {
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		HibernateUtil.getSessionFactory().getCurrentSession().close();
	}
}
