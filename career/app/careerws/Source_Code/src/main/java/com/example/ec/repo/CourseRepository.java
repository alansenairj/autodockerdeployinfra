package com.example.ec.repo;

import com.example.ec.domain.Course;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CourseRepository extends CrudRepository<Course,Integer> {
    List<Course> findByCareerPathCode(String code);
    List<Course> findAll();
}
