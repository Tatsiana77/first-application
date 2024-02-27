package com.tatchik.cs.homework6.arrays.task3;

import java.time.Month;
import java.util.Objects;

public class Movie  {
    private int id;
    private int year;
    private Month month;
    private Genre genre;
    private double rating;

    public Movie(int id, int year, Month month, Genre genre, double rating) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.genre = genre;
        this.rating = rating;
    }

    public Movie(int id, int year, com.tatchik.cs.homework6.arrays.task3.Month month, Genre genre, double rating) {
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && year == movie.year && Double.compare(rating, movie.rating) == 0 && month == movie.month && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, genre, rating);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }

}
