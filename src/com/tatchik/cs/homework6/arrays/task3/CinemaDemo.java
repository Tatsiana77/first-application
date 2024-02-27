package com.tatchik.cs.homework6.arrays.task3;

import java.util.List;
/**
 Даны 2 класса:
 - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив, где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 Добавить функционал в кинотеатр таким образом, чтобы можно было:
 - добавлять в него новый фильм
 - получить все фильмы по переданному году
 - получить все фильмы по переданному году и месяцу
 - получить все фильмы по переданному жанру
 - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 Учесть следующее:
 - в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть порядок значения ассоциативного массива)
 - не должен добавляться фильм, если такой уже есть в кинотеатре
 Продемонстрировать работу кинотеатра в отдельном классе.
 */

public class CinemaDemo {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        // Добавление фильмов в кинотеатр
        cinema.addMovie(new Movie(1, 2022, Month.JANUARY, Genre.ACTION, 8.5));
        cinema.addMovie(new Movie(2, 2023, Month.FEBRUARY, Genre.COMEDY, 7.8));
        cinema.addMovie(new Movie(3, 2022, Month.MARCH, Genre.DRAMA, 9.0));
        cinema.addMovie(new Movie(4, 2022, Month.APRIL, Genre.ROMANCE, 8.2));

        // Получение фильмов по году
        List<Movie> moviesByYear = cinema.getMoviesByYear(2022);
        System.out.println("Фильмы по году 2022: " + moviesByYear);

        // Получение фильмов по году и месяцу
        List<Movie> moviesByYearAndMonth = cinema.getMoviesByYearAndMonth(2022, Month.MARCH);
        System.out.println("Фильмы по году 2022 и месяцу Март: " + moviesByYearAndMonth);

        // Получение фильмов по жанру
        List<Movie> moviesByGenre = cinema.getMoviesByGenre(Genre.ACTION);
        System.out.println("Фильмы по жанру ACTION: " + moviesByGenre);

        // Получение ТОП-10 фильмов по рейтингу
        List<Movie> top10MoviesByRating = cinema.getTop10MoviesByRating();
        System.out.println("ТОП-10 фильмов по рейтингу: " + top10MoviesByRating);
    }
}
