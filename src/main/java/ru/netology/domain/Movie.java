package ru.netology.domain;

public class Movie {
    private int id;
    private String name;
    private String imageUrl;
    private String genre;

    public Movie(int id, String name, String imageUrl, String genre) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.genre = genre;
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

}
