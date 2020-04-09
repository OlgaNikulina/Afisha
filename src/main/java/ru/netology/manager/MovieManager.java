package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repository;
    private int amountOfMovie = 5;
    private int maxAmountOfMovie = 10;
    private int minAmountOfMovie = 1;
    Movie[] movies;


    public MovieManager(MovieRepository repository){
        this.repository = repository;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
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
