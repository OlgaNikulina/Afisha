package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;
import ru.netology.domain.AfishaRepository;

public class AfishaManagerTest {
    private AfishaRepository repository;
    private AfishaManager manager;
    private Afisha gentlemen = new Afisha(1, "gentlemen", "https://www.kinopoisk.ru/film/1143242/", "criminal", 10);
    private Afisha invisibleMan = new Afisha(2, "invisible man", "https://www.kinopoisk.ru/film/420454/", "horror", 10);
    private Afisha bloodshot = new Afisha(3, "bloodshot", "https://www.kinopoisk.ru/film/512673/", "fantastic", 10);


    @Test
    public void setUpManager() {
        AfishaManager manager = new AfishaManager(repository);
        Afisha first = new Afisha();
        Afisha second = new Afisha();
        Afisha third = new Afisha();

        manager.add(first);
        manager.add(second);
        manager.add(third);
    }
}