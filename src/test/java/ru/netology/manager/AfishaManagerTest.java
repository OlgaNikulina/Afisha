package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Afisha;
import ru.netology.domain.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaRepository manager;
    private Afisha gentlemen = new Afisha(1, "gentlemen", "https://www.kinopoisk.ru/film/1143242/", "criminal", 10);
    private Afisha invisibleMan = new Afisha(2, "invisible man", "https://www.kinopoisk.ru/film/420454/", "horror", 10);
    private Afisha bloodshot = new Afisha(3, "bloodshot", "https://www.kinopoisk.ru/film/512673/", "fantastic", 10);


    @BeforeEach
    public void setUp() {
        AfishaManager manager = new AfishaManager(repository);
        manager.add(gentlemen);
        manager.add(invisibleMan);
        manager.add(bloodshot);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        Afisha[] returned = new Afisha[]{invisibleMan, bloodshot};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Afisha[] expected = new Afisha[]{invisibleMan, bloodshot};
        Afisha[] actual = manager.findAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4 ;
        Afisha[] returned = new Afisha[]{gentlemen, invisibleMan, bloodshot};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Afisha[] expected = new Afisha[]{bloodshot, invisibleMan, gentlemen};
        Afisha[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }
}
}