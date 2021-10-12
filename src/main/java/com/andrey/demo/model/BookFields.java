package com.andrey.demo.model;

public final class BookFields {
    private boolean id;
    private boolean author;
    private boolean title;
    private boolean genre;
    private boolean cover;
    private boolean year;
    private boolean description;

    private BookFields(boolean id, boolean author, boolean title, boolean genre, boolean cover, boolean year, boolean description) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.cover = cover;
        this.year = year;
        this.description = description;
    }

    public static BookFields withoutAny() {
        return new BookFields(false, false, false, false, false, false, false);
    }

    public static BookFields withAll() {
        return new BookFields(true, true, true, true, true, true, true);
    }

    public boolean isId() {
        return id;
    }

    public BookFields setId(boolean id) {
        this.id = id;
        return this;
    }

    public boolean isAuthor() {
        return author;
    }

    public BookFields setAuthor(boolean author) {
        this.author = author;
        return this;
    }

    public boolean isTitle() {
        return title;
    }

    public BookFields setTitle(boolean title) {
        this.title = title;
        return this;
    }

    public boolean isGenre() {
        return genre;
    }

    public BookFields setGenre(boolean genre) {
        this.genre = genre;
        return this;
    }

    public boolean isCover() {
        return cover;
    }

    public BookFields setCover(boolean cover) {
        this.cover = cover;
        return this;
    }

    public boolean isYear() {
        return year;
    }

    public BookFields setYear(boolean year) {
        this.year = year;
        return this;
    }

    public boolean isDescription() {
        return description;
    }

    public BookFields setDescription(boolean description) {
        this.description = description;
        return this;
    }
}
