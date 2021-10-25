package com.andrey.demo.model;

import java.net.URL;

public class Book {
    private long id;
    private String author;
    private String title;
    private String genre;
    private URL coverUrl;
    private int year;
    private String description;

    public Book(String author, String title, String genre, URL coverUrl, int year, String description) {
        this(0, author, title, genre, coverUrl, year, description);
    }

    public Book(long id, String author, String title, String genre, URL coverUrl, int year, String description) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.coverUrl = coverUrl;
        this.year = year;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public URL getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(URL coverUrl) {
        this.coverUrl = coverUrl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", coverUrl=" + coverUrl +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }
}
