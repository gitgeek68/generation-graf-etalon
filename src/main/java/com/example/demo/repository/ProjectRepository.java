package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.hello.Projects;

public interface ProjectRepository extends CrudRepository<Projects, Integer>
{
	List<Projects> findByName(String name);
	//List<Projects> findById(Integer id);
	
}


