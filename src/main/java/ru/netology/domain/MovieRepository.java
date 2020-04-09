package ru.netology.domain;

public class MovieRepository {
    private Movie[] movies = new Movie[0];

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

    public Movie[] findById(int id) {
        int length = movies.length;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        return new Movie[index];
    }

    public int[] removeAll() {
        int [] movies = new int[0];
        return movies;
    }


}

