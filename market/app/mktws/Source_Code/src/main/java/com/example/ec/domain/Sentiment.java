package com.example.ec.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Sentiment implements Serializable{
    @Id
    private String code;

    @Column
    private String title;

    @Column
    private Integer Popularity;

    @Column
    private Integer NumberOfOpening;


    public Sentiment(String code, String title, Integer Popularity,
                     Integer NumberOfOpening) {

        this.code = code;
        this.title = title;
        this.Popularity = Popularity;
        this.NumberOfOpening = NumberOfOpening;
    }

    protected Sentiment() {
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public Integer getPopularity() {
        return Popularity;
    }

    public void setPopularity(Integer Popularity) {
        this.Popularity = Popularity;
    }


    public Integer getNumberOfOpening() {
        return NumberOfOpening;
    }

    public void setNumberOfOpening(Integer NumberOfOpening) {
        this.NumberOfOpening = NumberOfOpening;
    }

    @Override
    public String toString() {
        return "Sentiment{" +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", Popularity='" + Popularity + '\'' +
                ", NumberOfOpening='" + NumberOfOpening + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentiment sentiment = (Sentiment) o;
        return Objects.equals(code, sentiment.code) &&
                Objects.equals(title, sentiment.title) &&
                Objects.equals(Popularity, sentiment.Popularity) &&
                Objects.equals(NumberOfOpening, sentiment.NumberOfOpening);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title, Popularity, NumberOfOpening);
    }
}
