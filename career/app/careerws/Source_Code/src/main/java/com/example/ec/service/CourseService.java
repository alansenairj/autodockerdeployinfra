package com.example.ec.service;

import com.example.ec.domain.CareerPath;
import com.example.ec.domain.Course;
import com.example.ec.domain.Difficulty;
import com.example.ec.repo.CareerPathRepository;
import com.example.ec.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    private CareerPathRepository careerPathRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, CareerPathRepository careerPathRepository) {
        this.courseRepository = courseRepository;
        this.careerPathRepository = careerPathRepository;
    }

    /**
     * Create a new Course Object and persist it to the Database.
     *
     * @param coursecode
     * @param title
     * @param description
     * @param price
     * @param Author
     * @param careerPathName
     * @param difficulty
     * @return Course Entity
     */
    public Course createTour(Integer coursecode, String title, String description, Integer price,
                             String Author, String careerPathName, Difficulty difficulty) {
        CareerPath careerPath = careerPathRepository.findByName(careerPathName);
        if (careerPath == null) {
            throw new RuntimeException("Course package does not exist: " + careerPathName);
        }
        return courseRepository.save(new Course(coursecode, title, description, price, Author, careerPath, difficulty));
    }

    public long total() {
        return courseRepository.count();
    }

}

