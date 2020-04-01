package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    private Afisha movie1 = new Afisha(1, "movie1", "http://...", "thriller", 5);
    private Afisha movie2 = new Afisha(2, "movie2", "http://...", "thriller", 5);
    private Afisha movie3 = new Afisha(3, "movie", "http://...", "thriller", 5);

    @BeforeEach
    @Test
    public void setUpManager() {
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
    }

    @Test
    public void shouldGetAll() {
        manager.getMovies();
    }

    @Test
    public void shouldGetTenLasts() {
        manager.getLastsTenAdded();
        Afisha[] actual = manager.getMovies();
        Afisha[] expected = new Afisha[]{movie3, movie2, movie1};
        assertArrayEquals(expected,actual);
    }
}