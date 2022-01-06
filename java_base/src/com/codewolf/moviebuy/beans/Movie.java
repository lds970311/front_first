// Author : evan lee
// Time ： 2022-01-06  11:43
// FILENAME : Movie.java
// STATEMENT: 电影类 Movie类包含：片名、主演、评分、时长、票价、余票

package com.codewolf.moviebuy.beans;

import lombok.Data;

import java.util.Date;

@Data
public class Movie {
    private String name;
    private String actor;
    private double rating;
    private Double time;
    private Double price;
    private Integer tickCount;
    private Date startTime;

    public Movie() {
    }

    public Movie(String name, String actor, double rating, Double time, Double price, Integer tickCount, Date startTime) {
        this.name = name;
        this.actor = actor;
        this.rating = rating;
        this.time = time;
        this.price = price;
        this.tickCount = tickCount;
        this.startTime = startTime;
    }
}
