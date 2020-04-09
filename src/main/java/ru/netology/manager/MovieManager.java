package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {

    private Movie[] movies = new Movie[0];
    private int amountOfMovie = 5;
    private int maxAmountOfMovie = 10;
    private int minAmountOfMovie = 1;
    private Movie movie1 = new Movie(1, "movie1", "http://...", "thriller");
    private Movie movie2 = new Movie(2, "movie2", "http://...", "thriller");
    private Movie movie3 = new Movie(3, "movie3", "http://...", "thriller");
    private Movie movie4 = new Movie(4, "movie4", "http://...", "thriller");
    private Movie movie5 = new Movie(5, "movie5", "http://...", "thriller");

    public MovieManager() {
    }

    public MovieManager(int amountOfMovie) {
        this.amountOfMovie = amountOfMovie;
    }

    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getLastsTenAdded(int amountOfMovie) {
        Movie[] result = new Movie[movies.length];
        if (amountOfMovie >= maxAmountOfMovie) {
            return result;
        }
        if (amountOfMovie <= minAmountOfMovie) {
            return result;
        }
        for (int i = 0; i < result.length; i++) {
            if (amountOfMovie > i) {
                return result;
            }
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        this.amountOfMovie = amountOfMovie;

        return result;
    }
}
