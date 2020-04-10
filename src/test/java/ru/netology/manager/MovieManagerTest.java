package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieManagerTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
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


    public void setUp() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);
        manager.add(movie8);
        manager.add(movie9);
        manager.add(movie10);
    }

    @Test
    public void shouldGetFiveLasts() {
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        manager.getLastsTenAdded(5);

        Movie[] expected = new Movie[]{movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = manager.getLastsTenAdded(5);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTenMovies() {

        manager.getLastsTenAdded(10);

        Movie[] expected = new Movie[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = manager.getLastsTenAdded(10);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetOneMovie() {

        manager.getLastsTenAdded(1);

        Movie[] expected = new Movie[]{movie1};
        Movie[] actual = manager.getLastsTenAdded(1);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotGetLastsMoreTen() {

        manager.getLastsTenAdded(100);

        Movie[] expected = new Movie[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};;
        Movie[] actual = manager.getLastsTenAdded(100);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotGetZero() {

        manager.getLastsTenAdded(0);

        Movie[] expected = new Movie[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};;
        Movie[] actual = manager.getLastsTenAdded(0);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotGetValueWithMinus() {

        manager.getLastsTenAdded(-10);

        Movie[] expected = new Movie[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};;
        Movie[] actual = manager.getLastsTenAdded(-10);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 2;

        Movie[] returned = new Movie[]{movie1, movie3};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{movie3, movie1};
        Movie[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        Movie[] returned = new Movie[]{movie1, movie2, movie3};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{movie3, movie2, movie1};
        Movie[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }
}
