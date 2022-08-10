package com.onlineJobPortal.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineJobPortal.entity.Job;
import com.onlineJobPortal.entity.User;
import com.onlineJobPortal.repo.JobRepo;
import com.onlineJobPortal.repo.UserRepo;
import com.onlineJobPortal.responce.GeneralResponse;
import com.onlineJobPortal.services.job.JobService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobService jobService;
	
	@Autowired
	private JobRepo jobRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("addJob")
	public GeneralResponse addJob(@RequestBody Job job){
		
		
		
		GeneralResponse response = new GeneralResponse();
		
		try {
			//return jobService.addJob(job);
			jobRepo.save(job);
			response.setMessage("Job Added");
			response.setData(jobRepo.save(job));
			response.setStatus(HttpStatus.OK);
			return response;
			
		}catch(Exception ex) {
			response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
            return response;
		}
		
	}
	
	@DeleteMapping("{id}")
	public GeneralResponse deleteBook(@PathVariable Long id) {
		GeneralResponse response = new GeneralResponse();
		try {
			jobService.deleteJob(id);
			response.setStatus(HttpStatus.OK);
            return response;
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
            return response;
        }
	}
	

	@GetMapping("getAllJobs")
	public List<Job> getAllBooks(){
		
		return jobService.getAllJobs();
	}
	
	@GetMapping("getAllUsers")
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	@PutMapping("updateJob/{id}")
	public Job updateJob(@RequestBody Job job,@PathVariable("id") Long jobId
			) {
		
		//GeneralResponse response  = new GeneralResponse();		
		//try {
			this.jobService.updateJob(job, jobId);
			//job.setJobid(id);
			//Job updatedJob =  this.jobRepo.save(job);
			//updatedJob.setJobid(id);
			//response.setMessage("Job Updated Successfully");
			return job;
		//}catch(Exception ex) {
			//response.setMessage("Cannot Update the Job");
			//return response;
		//}
		
	}
	
}
	
	/*
	@GetMapping("getAllJobs")
	public List<Job> getAllBooks() {
		return jobService.getAllJobs();
		//Job job = new Job();
		//job = jobRepo.findAll();
	
		//return jobRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Job getJob(@PathVariable Long id) {
		Job job = null;
		job = jobRepo.getById(id);
		return job;
		
	}
	*/

