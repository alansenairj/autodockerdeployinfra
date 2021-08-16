package com.example.ec.service;

import com.example.ec.domain.CareerPath;
import com.example.ec.repo.CareerPathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CareerPathService {
    private CareerPathRepository careerPathRepository;

    @Autowired
    public CareerPathService(CareerPathRepository careerPathRepository) {
        this.careerPathRepository = careerPathRepository;
    }

    public CareerPath createCareerPath(String code, String name) {
        if (careerPathRepository.findOne(code) == null) {
            return careerPathRepository.save(new CareerPath(code, name));
        } else {
            return null;
        }
    }
    public Iterable<CareerPath> lookup(){
        return careerPathRepository.findAll();
    }
    public long total() {
        return careerPathRepository.count();
    }
}

