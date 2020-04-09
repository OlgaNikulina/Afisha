package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.domain.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieManagerTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager;
    private Movie gentlemen = new Movie(1, "gentlemen", "https://www.kinopoisk.ru/film/1143242/", "criminal", 10);
    private Movie invisibleMan = new Movie(2, "invisible man", "https://www.kinopoisk.ru/film/420454/", "horror", 10);
    private Movie bloodshot = new Movie(3, "bloodshot", "https://www.kinopoisk.ru/film/512673/", "fantastic", 10);


    @BeforeEach
    public void setUp() {
        MovieManager manager = new MovieManager(repository);
        manager.add(gentlemen);
        manager.add(invisibleMan);
        manager.add(bloodshot);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        Movie[] returned = new Movie[]{invisibleMan, bloodshot};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{invisibleMan, bloodshot};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4 ;
        Movie[] returned = new Movie[]{gentlemen, invisibleMan, bloodshot};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{bloodshot, invisibleMan, gentlemen};
        Movie[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }
}
