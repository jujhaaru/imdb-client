package com.lunatech.assignment.imdb.client.service;

import java.util.List;

public interface ImdbService {
    List<String> getTopRatedMoviesByGenre(String genre, Long count);

    boolean checkIfTypeCasted(String name);

    Integer getDegreeOfSeperation(String name);
}
