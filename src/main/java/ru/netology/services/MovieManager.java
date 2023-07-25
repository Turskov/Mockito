package ru.netology.services;

import java.util.Arrays;

public class MovieManager {

    private final int limit;
    private final String[] movies;
    private int size;

    public MovieManager() {
        this.limit = 5;
        this.movies = new String[limit];
        this.size = 0;
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new String[limit];
        this.size = 0;
    }

    public void save(String movie) {
        if (size == limit) {
            System.arraycopy(movies, 1, movies, 0, size - 1);
            movies[size - 1] = movie;
        } else {
            movies[size] = movie;
            size++;
        }
    }

    public String[] findAll() {
        return Arrays.copyOf(movies, size);
    }

    public String[] findLast() {
        int resultLength = Math.min(limit, size);
        return Arrays.copyOfRange(movies, size - resultLength, size);
    }
}