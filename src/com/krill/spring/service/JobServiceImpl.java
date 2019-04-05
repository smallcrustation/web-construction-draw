package com.krill.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krill.spring.dao.JobDAO;
import com.krill.spring.entity.Draw;
import com.krill.spring.entity.Job;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;
	
	@Override
	@Transactional
	public List<Job> getJobList() {
		return jobDAO.getJobList();
	}

	@Override
	@Transactional
	public void saveJob(Job job) {
		jobDAO.save(job);
	}

	@Override
	@Transactional
	public Job getJob(int jobId) {
		return jobDAO.getJob(jobId);
	}

	@Override
	@Transactional
	public void delete(Job job) {
		jobDAO.delete(job);	
	}

	@Override
	@Transactional
	public List<Draw> getDrawList(int jobId) {
		
		return jobDAO.getDrawList(jobId);
	}

}
