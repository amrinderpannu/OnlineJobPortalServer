package com.onlineJobPortal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long jobId;
	public String jobTitle;
	public String jobLocation;
	private String companyName;
	private String companyId;
	private int salary;
	private String jobRole;
	private String skillsRequired;
	private String jobDescription;
	
	
	
	public Job() {
		
	}
	

	
	public Job(Long jobId, String jobTitle, String jobLocation, String companyName, String companyId, int salary,
			String jobRole, String skillsRequired, String jobDescription) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobLocation = jobLocation;
		this.companyName = companyName;
		this.companyId = companyId;
		this.salary = salary;
		this.jobRole = jobRole;
		this.skillsRequired = skillsRequired;
		this.jobDescription = jobDescription;
	}
	public Long getJobid() {
		return jobId;
	}
	public void setJobid(Long jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	
	
	

}
