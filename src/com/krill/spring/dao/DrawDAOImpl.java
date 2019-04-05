package com.krill.spring.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.krill.spring.entity.Draw;
import com.krill.spring.entity.LineItem;

@Repository
public class DrawDAOImpl implements DrawDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Draw getDraw(int drawId) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get draw by id
		Draw draw = currentSession.get(Draw.class, drawId);
		
		return draw;
	}

	@Override
	public void saveDraw(Draw draw) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save draw to database
		currentSession.saveOrUpdate(draw);
		
	}

//	@Override
//	public List<LineItem> getLineItems(int drawId) {
//		// current session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		// query all line items associated with this draw
//		Query<LineItem> query = currentSession.createQuery("");
//		
//		return null;
//	}
//	
	

}
