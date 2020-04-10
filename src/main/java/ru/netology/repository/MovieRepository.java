package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {
    private Movie[] movies = new Movie[0];
    private Movie gentlemen = new Movie(1, "gentlemen", "https://www.kinopoisk.ru/film/1143242/", "criminal", 10);
    private Movie invisibleMan = new Movie(2, "invisible man", "https://www.kinopoisk.ru/film/420454/", "horror", 10);
    private Movie bloodshot = new Movie(3, "bloodshot", "https://www.kinopoisk.ru/film/512673/", "fantastic", 10);


    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public int findById(int id) {
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                index++;
            }
        }
        return index;
    }

    public Movie[] removeAll() {
        Movie[] result = new Movie[]{};

        return result;
    }


}

