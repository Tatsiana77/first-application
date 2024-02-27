package com.tatchik.cs.homework6.arrays.task3;

import java.util.*;


public class Cinema {
    private Map<Integer, List<Movie>> moviesByYearMap;

    public Cinema() {
        this.moviesByYearMap = new LinkedHashMap<>();
    }

    // Метод для добавления нового фильма в кинотеатр
    public void addMovie(Movie movie) {
        // Проверка наличия фильма с таким же ID в кинотеатре
        for (List<Movie> movies : moviesByYearMap.values()) {
            for (Movie m : movies) {
                if (m.equals(movie)) {
                    System.out.println("Фильм с таким ID уже существует в кинотеатре.");
                    return;
                }
            }
        }

        // Добавление фильма в соответствующий год
        moviesByYearMap.computeIfAbsent(movie.getYear(), k -> new ArrayList<>()).add(movie);
    }

    // Метод для получения всех фильмов по заданному году
    public List<Movie> getMoviesByYear(int year) {
        return moviesByYearMap.getOrDefault(year, Collections.emptyList());
    }

    // Метод для получения всех фильмов по заданному году и месяцу
    public List<Movie> getMoviesByYearAndMonth(int year, Month month) {
        List<Movie> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Movie>> entry : moviesByYearMap.entrySet()) {
            if (entry.getKey() == year) {
                for (Movie movie : entry.getValue()) {
                    if (movie.getMonth().equals(month)) {
                        result.add(movie);
                    }
                }
            }
        }
        return result;
    }

    // Метод для получения всех фильмов по заданному жанру
    public List<Movie> getMoviesByGenre(Genre genre) {
        List<Movie> result = new ArrayList<>();
        for (List<Movie> movies : moviesByYearMap.values()) {
            for (Movie movie : movies) {
                if (movie.getGenre() == genre) {
                    result.add(movie);
                }
            }
        }
        return result;

    }

    public List<Movie> getTop10MoviesByRating() {
        // Метод для получения ТОП-10 фильмов по рейтингу
        List<Movie> allMovies = new ArrayList<>();
        for (List<Movie> movies : moviesByYearMap.values()) {
            allMovies.addAll(movies);
        }
        allMovies.sort(Comparator.comparingDouble(Movie::getRating).reversed());
        return allMovies.subList(0, Math.min(10, allMovies.size()));
    }
}

