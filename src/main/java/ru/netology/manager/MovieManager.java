package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {

    private Movie[] movies = new Movie[]{};
    private int amountOfMovie = 5;
    private int maxAmountOfMovie = 10;
    private int minAmountOfMovie = 1;
    private Movie movie1 = new Movie(1, "movie1", "http://...", "thriller");
    private Movie movie2 = new Movie(2, "movie2", "http://...", "thriller");
    private Movie movie3 = new Movie(3, "movie3", "http://...", "thriller");
    private Movie movie4 = new Movie(4, "movie4", "http://...", "thriller");
    private Movie movie5 = new Movie(5, "movie5", "http://...", "thriller");
    private Movie movie6 = new Movie(6, "movie6", "http://...", "thriller");
    private Movie movie7 = new Movie(7, "movie7", "http://...", "thriller");
    private Movie movie8 = new Movie(8, "movie8", "http://...", "thriller");
    private Movie movie9 = new Movie(9, "movie9", "http://...", "thriller");
    private Movie movie10 = new Movie(10, "movie10", "http://...", "thriller");

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
        Movie[] result = new Movie[movies.length];
        if (amountOfMovie > maxAmountOfMovie) {
            return null;
        }
        if (amountOfMovie < minAmountOfMovie) {
            return null;
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
