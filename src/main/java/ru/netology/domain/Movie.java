package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    private String id;
    private String name;
    private String imageUrl;
    private String genre;
    private int amountOfMovie = 10;
}

