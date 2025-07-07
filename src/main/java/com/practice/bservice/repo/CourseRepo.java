package com.practice.bservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.practice.bservice.entity.CourseMaster;

public interface CourseRepo extends CrudRepository<CourseMaster, Long>{
	
}
