package com.onlineJobPortal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineJobPortal.entity.Job;

public interface JobRepo extends JpaRepository<Job, Long> {
	
	List<Job> findAllByJobId(Long userId);
}
