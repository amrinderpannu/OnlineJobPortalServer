package com.onlineJobPortal.services.job;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.onlineJobPortal.entity.Job;
import com.onlineJobPortal.repo.JobRepo;
import com.onlineJobPortal.repo.UserRepo;
import com.onlineJobPortal.responce.GeneralResponse;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepo jobRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public GeneralResponse addJob(Job job) {
		// TODO Auto-generated method stub
		
		boolean jobAdded = false;
		GeneralResponse response = new GeneralResponse();
		//if(jobRepo.findById(job.getJobid())!=null) {
		if(!jobAdded) {
			jobRepo.save(job);
			response.setMessage("Job Added Successfully");
			response.setStatus(HttpStatus.CREATED);
			jobAdded = true;
		}
		else {
			response.setStatus(HttpStatus.NOT_ACCEPTABLE);
			response.setMessage("Job Not added");
		}
		return response;
	}
	
	
	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return jobRepo.findAll(); 
	}
	
	@Override
	public void deleteJob(Long jobId) {
		// TODO Auto-generated method stub
		Optional<Job> optionalJob = jobRepo.findById(jobId);
		if(optionalJob.isPresent()) {
			jobRepo.delete(optionalJob.get());
		}
	}
	
	public void updateJob (Job job, Long jobId) {
		
		//GeneralResponse response = new GeneralResponse();
		
		List<Job> jobList = jobRepo.findAll();
		for(Job j:jobList) {
		
			if(j.getJobid().equals(jobId))
			{
				System.out.println("equals");
				j.setJobid(jobId);
				j.setCompanyId(job.getCompanyId());
				j.setCompanyName(job.getCompanyName());
				j.setJobDescription(job.getJobDescription());
				j.setJobLocation(job.getJobLocation());
				j.setJobRole(job.getJobRole());
				j.setJobTitle(job.getJobTitle());
				j.setSalary(job.getSalary());
				j.setSkillsRequired(job.getSkillsRequired());
				jobRepo.save(j);
				break;
			}
			else {
				System.out.println("cannot find id");
			}
		}
		
		
		/*
		if(jobRepo.findById(jobId) != null) {
			job.setJobid(jobId);
			jobRepo.save(job);
			response.setData(job);
			response.setMessage("Job Updated Successfully");
			response.setStatus(HttpStatus.NOT_ACCEPTABLE);
			return response;
			
		}
		else {
			 response.setMessage("Cannot find Job with this id");
			 return response;
		}
		*/
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
