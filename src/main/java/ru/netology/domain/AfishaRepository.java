package ru.netology.domain;

public class AfishaRepository {
    private Afisha[] movies = new Afisha[0];

    public void save(Afisha movie) {
        int length = movies.length + 1;
        Afisha[] tmp = new Afisha[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Afisha[] findAll() {
        return movies;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Afisha[] tmp = new Afisha[length];
        int index = 0;
        for (Afisha movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public Afisha[] findById(int id) {
        int length = movies.length;
        Afisha[] tmp = new Afisha[length];
        int index = 0;
        for (Afisha movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        return new Afisha[index];
    }

    public int[] removeAll() {
        int [] movies = new int[0];
        return movies;
    }
}

