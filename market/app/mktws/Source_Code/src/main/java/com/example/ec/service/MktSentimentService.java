package com.example.ec.service;

import com.example.ec.domain.Sentiment;
import com.example.ec.repo.SentimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MktSentimentService {
    private SentimentRepository sentimentRepository;

    @Autowired
    public MktSentimentService(SentimentRepository sentimentRepository) {
        this.sentimentRepository = sentimentRepository;
    }


    public Sentiment createTour(String code, String title, Integer Popularity, Integer NumberOfOpening) {
//        Sentiment mktSentiment = sentimentRepository.findByName(title);
//        if (mktSentiment == null) {
//            throw new RuntimeException("Sentiment package does not exist: " + title);
//        }
        return sentimentRepository.save(new Sentiment(code, title, Popularity, NumberOfOpening));
    }

    public long total() {
        return sentimentRepository.count();
    }

}

