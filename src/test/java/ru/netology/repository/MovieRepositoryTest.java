package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private Movie starWars = new Movie();
    private MovieRepository repository = new MovieRepository();
    private MovieManager manager = new MovieManager(repository);
    private Movie movie1;
    private Movie movie2;
    private Movie movie3;
    private Movie movie4;
    private Movie movie5;
    private Movie movie6;
    private Movie movie7;
    private Movie movie8;
    private Movie movie9;
    private Movie movie10;

    @Test
    void shouldSave() {
        repository.save(starWars);

        Movie[] expected = new Movie[]{starWars};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        repository.findById(2);

        Movie[] expected = new Movie[]{movie2};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        repository.removeAll();

        Movie[] expected = new Movie[]{};
        Movie[] actual = repository.removeAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        repository.removeById(idToRemove);

        Movie[] expected = new Movie[]{movie2, movie1};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        repository.removeById(idToRemove);

        Movie[] expected = new Movie[]{movie3, movie2, movie1};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}
