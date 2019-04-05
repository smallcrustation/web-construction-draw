package com.krill.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.krill.spring.entity.Draw;
import com.krill.spring.entity.Job;

@Repository
public class JobDAOImpl implements JobDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Job> getJobList() {
		// get list from db layer
		// start a session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get all Jobs from db
		Query<Job> query = currentSession.createQuery("from Job order by name", Job.class);
		
		// apply them to java list
		List<Job> jobsList = query.getResultList();
		
		// return list to service layer
		return jobsList;
	}

	@Override
	public void save(Job job) {
		// start session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save job to db
		currentSession.saveOrUpdate(job); // checks if id is already used to see if it updates or creates new
	}

	@Override
	public Job getJob(int jobId) {
		// start session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get job from db w/ id 
		Job job = currentSession.get(Job.class, jobId);
		
		return job;
	}

	@Override
	public void delete(Job job) {
		sessionFactory.getCurrentSession().delete(job);
	}

	@Override
	public List<Draw> getDrawList(int jobId) {
		// start session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// query for draw's (jobId param)
		Query<Draw> drawsQuery = currentSession.createQuery("SELECT d FROM Draw d WHERE d.job = " + jobId, Draw.class);
		
		// turn it into a list
		List<Draw> drawList = drawsQuery.getResultList();
		
		return drawList;
	}
	
	

}
