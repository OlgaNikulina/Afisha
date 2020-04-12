package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {
    private Movie[] movies = new Movie[]{};

    public Movie[] save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
        return tmp;
    }

    public Movie[] findAll() {
        int length = movies.length;
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < tmp.length; i++) {
            int index = movies.length - i - 1;
            tmp[i] = movies[index];
            }
        return tmp;
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

    public Movie[] findById(int id) {
        int length = movies.length;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
            movies = tmp;
        }
        Movie[] movie = new Movie[id];
        return new Movie[id];
    }

    public Movie[] removeAll() {

        return new Movie[0];
    }
}

