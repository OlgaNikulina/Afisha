package ru.netology.manager;

import ru.netology.domain.Afisha;
import ru.netology.domain.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    public AfishaManager(AfishaRepository repository){
        this.repository = repository;
    }

    private Afisha[] movies = new Afisha[0];

    public void add (Afisha movie) {
        int length =  movies.length + 1;
        Afisha[] tmp = new Afisha[length];
        for (int i = 0; i < movies.length ; i++) {
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Afisha[] getLastsTenAdded() {
        Afisha[] result = new Afisha[movies.length];

        for (int i = 0; i < result.length ; i++) {
            int amountOfMovie = 10;
            if (i < amountOfMovie) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
        }
        return result;

    }
}
