package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
        private MovieManager manager;
        private Movie first;
        private Movie second;
        private Movie third;


    @Test
    public void setUpManager() {
        MovieManager manager = new MovieManager();
        Movie first = new Movie();
        Movie second = new Movie();
        Movie third = new Movie();

        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void getLastsTenAdded() {
    }
}