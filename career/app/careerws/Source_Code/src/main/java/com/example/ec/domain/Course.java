package com.example.ec.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Course implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer coursecode;

    @Column
    private String title;

    @Column(length = 2000)
    private String description;

    @Column
    private Integer price;

    @Column
    private String Author;

    @ManyToOne
    private CareerPath careerPath;

    @Column
    private Difficulty difficulty;


    public Course(Integer coursecode, String title, String description, Integer price,
                  String Author, CareerPath careerPath, Difficulty difficulty) {

        this.coursecode = coursecode;
        this.title = title;
        this.description = description;
        this.price = price;
        this.Author = Author;
        this.careerPath = careerPath;
        this.difficulty = difficulty;
    }

    protected Course() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(Integer coursecode) {
        this.coursecode = coursecode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public String getAuthor() {
        return Author;
    }

    public CareerPath getCareerPath() {
        return careerPath;
    }

    public void setCareerPath(CareerPath careerPath) {
        this.careerPath = careerPath;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", coursecode='" + coursecode + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", Author='" + Author + '\'' +
                ", careerPath=" + careerPath +
                ", difficulty=" + difficulty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(coursecode, course.coursecode) &&
                Objects.equals(title, course.title) &&
                Objects.equals(description, course.description) &&
                Objects.equals(price, course.price) &&
                Objects.equals(Author, course.Author) &&
                Objects.equals(careerPath, course.careerPath) &&
                difficulty == course.difficulty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coursecode, title, description, price, Author, careerPath, difficulty);
    }
}
