package com.example.ec.repo;

import com.example.ec.domain.CareerPath;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CareerPathRepository extends CrudRepository<CareerPath, String> {
    CareerPath findByName(@Param("name")String name);
}

