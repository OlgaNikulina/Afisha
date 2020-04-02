package ru.netology.domain;

public class Afisha {
    private int id;
    private String name;
    private String imageUrl;
    private String genre;
    private int amountOfMovie = 10;

    public Afisha() {
    }

    public Afisha(int id, String name, String imageUrl, String genre, int amountOfMovie) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.genre = genre;
        this.amountOfMovie = amountOfMovie;
    }

    public Afisha(int amountOfMovie) {
        this.amountOfMovie = amountOfMovie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAmountOfMovie() {
        return amountOfMovie;
    }

    public void setAmountOfMovie(int amountOfMovie) {
        this.amountOfMovie = amountOfMovie;
    }
}

