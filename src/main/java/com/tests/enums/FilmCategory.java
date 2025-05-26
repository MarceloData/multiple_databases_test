package com.tests.enums;

public enum FilmCategory {
    ACTION("Action"),
    ANIMATION("Animation"),
    CHILDREN("Children"),
    CLASSICS("Classics"),
    COMEDY("Comedy"),
    DOCUMENTARY("Documentary"),
    DRAMA("Drama"),
    FAMILY("Family"),
    FOREIGN("Foreign"),
    GAMES("Games"),
    HORROR("Horror"),
    MUSIC("Music"),
    NEW("New"),
    SCIFI("Sci-fi"),
    SPORTS("Sports"),
    TRAVEL("Travel");

    private String category;

    FilmCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
