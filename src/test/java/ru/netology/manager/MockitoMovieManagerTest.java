package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MockitoMovieManagerTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
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
    public void shouldRemoveIfExists() {
        int idToRemove = 2;
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] returned = new Movie[]{movie1, movie3};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        repository.removeById(idToRemove);
        Movie[] expected = new Movie[]{movie3, movie1};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] returned = new Movie[]{movie1, movie2, movie3};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        repository.removeById(idToRemove);
        Movie[] expected = new Movie[]{movie3, movie2, movie1};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }
}