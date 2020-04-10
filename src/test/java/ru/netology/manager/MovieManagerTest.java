package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
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

    private MovieManager manager = new MovieManager();



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

        manager.getLastsTenAdded(10);

        Movie[] expected = new Movie[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = manager.getLastsTenAdded(10);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetOneMovie() {
        manager.add(movie1);

        manager.getLastsTenAdded(1);

        Movie[] expected = new Movie[]{movie1};
        Movie[] actual = manager.getLastsTenAdded(1);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotGetLastsMoreTen() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        manager.getLastsTenAdded(100);

        Movie[] expected = null;
        Movie[] actual = manager.getLastsTenAdded(100);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotGetZero() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        manager.getLastsTenAdded(0);

        Movie[] expected = null;
        Movie[] actual = manager.getLastsTenAdded(0);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotGetValueWithMinus() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        manager.getLastsTenAdded(-10);

        Movie[] expected = null;
        Movie[] actual = manager.getLastsTenAdded(-10);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSetUp(){

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
    }

    @Test
    public void shouldAddMovie() {

        manager.add(movie6);

        Movie[] expected = new Movie[]{movie1, movie2, movie3, movie4, movie5, movie6};
        Movie[] actual = manager.add(movie6);

        assertArrayEquals(expected, actual);
    }
}