package ru.netology.repository;

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

        Movie actual = repository.findById(3);

        assertEquals(movie3, actual);
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
        Movie[] actual = manager.getAll();

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
        Movie[] actual = manager.getAll();
        assertThrows(expected, ArrayIndexOutOfBoundsException.class, () -> repository.removeById(idToRemove));
    }
}
