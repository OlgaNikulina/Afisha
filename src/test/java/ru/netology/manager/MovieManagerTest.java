package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private Movie[] movie1, movie2, movie3, movie4, movie5;
    private MovieManager manager;

    @BeforeEach
    @Test
    public void shouldNotGetLastsMoreTen() {
        MovieManager manager = new MovieManager(5);
        manager.getLastsTenAdded(5);
        Movie[] actual = manager.getLastsTenAdded(5);
        Movie[][] expected = new Movie[][]{movie5, movie4, movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }
}