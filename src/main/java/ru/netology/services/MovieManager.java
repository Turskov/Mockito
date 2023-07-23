package ru.netology.services;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private final int limit;
    private final List<String> movies = new ArrayList<>();

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void save(String movie) {
        movies.add(movie);
        if (movies.size() > limit) {
            movies.remove(0);
        }
    }

    public List<String> findAll() {
        return new ArrayList<>(movies);
    }

    public List<String> findLast() {
        int resultLength = Math.min(limit, movies.size());
        return new ArrayList<>(movies.subList(movies.size() - resultLength, movies.size()));
    }
}