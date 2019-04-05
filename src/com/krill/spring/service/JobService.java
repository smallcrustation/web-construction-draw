package com.krill.spring.service;

import java.util.List;

import com.krill.spring.entity.Draw;
import com.krill.spring.entity.Job;

public interface JobService {
	public List<Job> getJobList();

	public void saveJob(Job job);

	public Job getJob(int jobId);

	public void delete(Job job);
	
	public List<Draw> getDrawList(int jobId);
}
