package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {

    private Movie[] movies = new Movie[]{};

    private int maxAmountOfMovie = 10;
    private int minAmountOfMovie = 1;

    public MovieManager() {
    }

    public Movie[] add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
        return tmp;
    }

    public Movie[] getLastsTenAdded(int amountOfMovie) {
        if (amountOfMovie > maxAmountOfMovie) {
            amountOfMovie = maxAmountOfMovie;
        }
        if (amountOfMovie < minAmountOfMovie) {
            amountOfMovie = maxAmountOfMovie;
        }
        Movie[] result = new Movie[amountOfMovie];
        for (int i = 0; i < result.length; i++) {

            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
            return result;
        }
    }

