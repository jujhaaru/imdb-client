package com.lunatech.assignment.imdb.client.dao;

import java.util.List;

public interface ImdbDao {
    List<String> readTopRatedMovieByGenre(String genre);

    List<String> getGenresForActor(String name);

    List<String> getTitlesForPerson(String name);

    List<String> getCharactersByTitles(List<String> titles);
}
