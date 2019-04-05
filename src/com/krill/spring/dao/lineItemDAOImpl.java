package com.krill.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.krill.spring.entity.LineItem;

@Repository
public class lineItemDAOImpl implements LineItemDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public LineItem getLineItem(int id) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get lineItem w/ id
		LineItem lineItem = currentSession.get(LineItem.class, id);
		
		return lineItem;
	}

	@Override
	public void save(LineItem lineItem) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the line item
		currentSession.saveOrUpdate(lineItem);
		
	}

}
