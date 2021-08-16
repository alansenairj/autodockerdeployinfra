package com.example.ec.web;

import com.example.ec.domain.Course;
import com.example.ec.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;


@RestController

public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/cources/all_cources")
    public List<Course> retrieveAllCources() {
        return courseRepository.findAll();
    }

    @GetMapping("/cources/{careerpath}")
    public List<Course> courseByName(@PathVariable("careerpath") String careerpath) {

        try
        {
			
            //Runtime.getRuntime().halt( 1 );

            Thread.sleep(1);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        if (careerpath.equals("AA")){
            throw new ArithmeticException("Throwing an exception for dynatrace demo");
        } else if(careerpath.equals("MA")){
			Runtime.getRuntime().halt( 1 );
		}

        return courseRepository.findByCareerPathCode(careerpath);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }

}
