package com.tatchik.cs.homework6.arrays.task3;

import java.util.List;

public class CinemaDemo {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        // Добавление фильмов в кинотеатр
        cinema.addMovie(new Movie(1, 2022, 1, "Action", 8.5));
        cinema.addMovie(new Movie(2, 2022, 2, "Drama", 7.8));
        cinema.addMovie(new Movie(3, 2021, 12, "Comedy", 6.9));
        cinema.addMovie(new Movie(4, 2021, 11, "Action", 9.0));
        cinema.addMovie(new Movie(5, 2022, 1, "Drama", 8.2));

        // Получение всех фильмов по году
        List<Movie> moviesIn2022 = cinema.getMoviesByYear(2022);
        System.out.println("Фильмы 2022 года:   " + moviesIn2022);
        System.out.println(" ");

        // Получение ТОП-10 фильмов по рейтингу
        List<Movie> top10Movies = cinema.getTop10MoviesByRating();
        System.out.println("Топ-10 фильмов по рейтингу:  " + top10Movies);
    }
}
