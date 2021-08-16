package com.example.ec.repo;

import com.example.ec.domain.Sentiment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SentimentRepository extends CrudRepository<Sentiment,Integer> {
    List<Sentiment> findBycode(String title);
}
