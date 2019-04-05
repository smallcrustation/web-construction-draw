package com.krill.spring.dao;

import java.util.List;

import com.krill.spring.entity.Draw;
import com.krill.spring.entity.Job;


public interface JobDAO {	
	public List<Job> getJobList();

	public void save(Job job);

	public Job getJob(int jobId);

	public void delete(Job job);
	
	public List<Draw> getDrawList(int jobId);
	
}
