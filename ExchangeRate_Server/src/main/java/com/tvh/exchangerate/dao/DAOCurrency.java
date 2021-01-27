package com.tvh.exchangerate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tvh.exchangerate.vo.Currency;


@Repository
@Transactional(rollbackFor = Exception.class)
public class DAOCurrency {
	@Autowired
	private SessionFactory sessionFactory;
	public void updateCurrency(Currency cur) {
//		System.out.println("start update currency");
		Session session = sessionFactory.getCurrentSession();
		session.update(cur);
	}
	
	public List<Currency> getCurrencys(){
		Session session = sessionFactory.getCurrentSession();
		Query<Currency> q = session.createQuery("From Currency c where c.exchangeRate > -1 order by c.ranking DESC,c.sumName ASC, c.exchangeRate ASC", Currency.class);
		return q.getResultList();
	}
	
	public Currency getCurrency(int id) {
		Session session = sessionFactory.getCurrentSession();
		Currency cur = session.get(Currency.class, id);
		return cur;
	}
	
	public Currency getCurrency(String sum) {
		Session session = sessionFactory.getCurrentSession();
		Query<Currency> q = session.createQuery("From Currency c where c.sumName = :sum_name", Currency.class);
		q.setParameter("sum_name", sum);
		List<Currency> re = q.getResultList();
		if(re.size() == 1) {
			return re.get(0);
		}else {
			return null;
		}
	}
	
	public void addCurrency(Currency cur) {
//		System.out.println("start add currency");
		Session session = sessionFactory.getCurrentSession();
		session.save(cur);
	}
	
	public void deleteAll() {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("Delete From Currency").executeUpdate();
	}
}
