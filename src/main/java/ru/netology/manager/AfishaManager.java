package ru.netology.manager;

import ru.netology.domain.Afisha;
import ru.netology.domain.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository){
        this.repository = repository;
    }

    public void add(Afisha movie) {
        repository.save(movie);
    }

    public Afisha[] getAll() {
        Afisha[] movies = repository.findAll();
        Afisha[] result = new Afisha[movies.length];
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
}
