package com.tatchik.cs.homework6.arrays.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Cinema {
    private Map<Integer, List<Movie>> moviesByYear;

    public Cinema() {
        this.moviesByYear = new LinkedHashMap<>();
    }

    // Метод для добавления фильма в кинотеатр
    public void addMovie(Movie movie) {
        int year = movie.getYear();
        moviesByYear.computeIfAbsent(year, k -> new ArrayList<>()).add(movie);
    }

    // Метод для получения всех фильмов по году
    public List<Movie> getMoviesByYear(int year) {
        List<Movie> result = moviesByYear.get(year);
        return result != null ? new ArrayList<>(result) : Collections.emptyList();
    }

    // Метод для получения всех фильмов по году и месяцу
    public List<Movie> getMoviesByYearAndMonth(int year, int month) {
        List<Movie> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Movie>> entry : moviesByYear.entrySet()) {
            if (entry.getKey() == year) {
                for (Movie movie : entry.getValue()) {
                    if (movie.getMonth() == month) {
                        result.add(movie);
                    }
                }
            }
        }
        return result;
    }

    // Метод для получения всех фильмов по жанру
    public List<Movie> getMoviesByGenre(String genre) {
        List<Movie> result = new ArrayList<>();
        for (List<Movie> movies : moviesByYear.values()) {
            for (Movie movie : movies) {
                if (movie.getGenre().equals(genre)) {
                    result.add(movie);
                }
            }
        }
        return result;
    }

    // Метод для получения ТОП-10 фильмов по рейтингу
    public List<Movie> getTop10MoviesByRating() {
        List<Movie> allMovies = new ArrayList<>();
        for (List<Movie> movies : moviesByYear.values()) {
            allMovies.addAll(movies);
        }

        allMovies.sort(Comparator.comparing(Movie::getRating).reversed());

        return allMovies.size() > 10 ? allMovies.subList(0, 10) : allMovies;
    }

}
