package com.onlineJobPortal.services.job;

import java.util.List;

import com.onlineJobPortal.entity.Job;
import com.onlineJobPortal.responce.GeneralResponse;

public interface JobService {

	GeneralResponse addJob(Job job);
	List<Job> getAllJobs();
	void deleteJob(Long jobId);
	void updateJob(Job job, Long joId);
	
}
