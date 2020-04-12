package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private Movie starWars = new Movie(50, "starWars", "http://...", "fantastic");
    private MovieRepository repository = new MovieRepository();
    private MovieManager manager = new MovieManager(repository);
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

    @Test
    void shouldSave() {
        repository.save(starWars);

        Movie[] expected = new Movie[]{starWars};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        int idToFind = 3;

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        repository.findAll();

        Movie[] expected = new Movie[]{movie3};
        Movie[] actual = repository.findById(idToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

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

        Movie[] expected = new Movie[]{movie3, movie1};
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
