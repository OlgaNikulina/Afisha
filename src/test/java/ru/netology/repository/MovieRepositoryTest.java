package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private Movie starWars = new Movie();
    private MovieRepository repository = new MovieRepository();
    private MovieManager manager = new MovieManager(repository);
    private Movie gentlemen = new Movie(1, "gentlemen", "https://www.kinopoisk.ru/film/1143242/", "criminal", 10);
    private Movie invisibleMan = new Movie(2, "invisible man", "https://www.kinopoisk.ru/film/420454/", "horror", 10);
    private Movie bloodshot = new Movie(3, "bloodshot", "https://www.kinopoisk.ru/film/512673/", "fantastic", 10);


    @Test
    void shouldSave() {
        repository.save(starWars);

        Movie[] expected = new Movie[]{starWars};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void removeAll() {
        MovieManager manager = new MovieManager(repository);

            manager.add(gentlemen);
            manager.add(invisibleMan);
            manager.add(bloodshot);

            repository.removeAll();

            Movie[] expected = new Movie[]{};
            Movie[] actual = repository.removeAll();

            assertArrayEquals(expected, actual);
        }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;

        manager.add(gentlemen);
        manager.add(invisibleMan);
        manager.add(bloodshot);

        repository.removeById(idToRemove);

        Movie[] expected = new Movie[]{gentlemen, bloodshot};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.add(gentlemen);
        manager.add(invisibleMan);
        manager.add(bloodshot);

        repository.removeById(idToRemove);

        Movie[] expected = new Movie[]{gentlemen, invisibleMan, bloodshot};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}
