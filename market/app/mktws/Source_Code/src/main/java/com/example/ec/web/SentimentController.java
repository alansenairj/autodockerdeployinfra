package com.example.ec.web;

import com.example.ec.domain.Sentiment;
import com.example.ec.repo.SentimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
public class SentimentController {

    @Autowired
    private SentimentRepository sentimentRepository;

    @GetMapping("/cources/{code}")
    public List<Sentiment> courseByName(@PathVariable("code") String code) {
        try
        {
            Thread.sleep(100);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        return sentimentRepository.findBycode(code);
    }

//    protected CourseController() {
//
//    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }
}