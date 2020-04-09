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
    @InjectMocks
    private MovieManager manager;
    private MovieRepository repository;
    private Movie gentlemen;
    private Movie invisibleMan;
    private Movie bloodshot;


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
