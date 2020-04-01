package ru.netology.manager;

import ru.netology.domain.Afisha;

public class AfishaManager {
    private Afisha[] movies = new Afisha[0];

    public void add(Afisha movie) {
        int length =  movies.length + 1;
        Afisha[] tmp = new Afisha[length];
        for (int i = 0; i < movies.length ; i++) {
            tmp[i] = movies[i];
        }
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Afisha[] getMovies() {
        Afisha[] result = new Afisha[movies.length];
        for (int i = 0; i < result.length ; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
        }
        return result;
    }

    public Afisha[] getLastsTenAdded() {
        Afisha[] result = new Afisha[movies.length];
        for (int i = 0; i < result.length ; i++) {
            int amountOfMovie = 5;
            if (i < amountOfMovie) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        return result;
    }
}
