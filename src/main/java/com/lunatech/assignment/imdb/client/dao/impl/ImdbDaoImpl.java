package com.lunatech.assignment.imdb.client.dao.impl;

import com.lunatech.assignment.imdb.client.dao.ImdbDao;
import com.lunatech.assignment.imdb.client.repository.NameBasicRepo;
import com.lunatech.assignment.imdb.client.repository.TitleBasicRepo;
import com.lunatech.assignment.imdb.client.repository.TitlePrincipalsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Repository
public class ImdbDaoImpl implements ImdbDao {

    @Autowired
    private TitleBasicRepo titleBasicRepo;

    @Autowired
    private NameBasicRepo nameBasicRepo;

    @Autowired
    private TitlePrincipalsRepo titlePrincipalsRepo;


    @Override
    public List<String> readTopRatedMovieByGenre(String genre) {
        log.trace("ImdbDaoImpl.readTopRatedMovieByGenre(String) : {}", genre);
        List<String> topMovies = titleBasicRepo.getListOfTopRatedMovie(genre);
        return topMovies;
    }

    @Override
    public List<String> getGenresForActor(String name) {
        log.trace("ImdbDaoImpl.getGenresForActor(String) invoked : {}", name);
        List<String> listOfTitles = Arrays.asList(nameBasicRepo.findByPrimaryName(name).getKnownForTitles().split(","));
        List<String> genreByTitle = titleBasicRepo.getGenresByTitle(listOfTitles);
        log.trace("ImdbDaoImpl.getGenresForActor(String) executed : {}", genreByTitle);
        return genreByTitle;
    }

    @Override
    public List<String> getTitlesForPerson(String name) {
        List<String> allTitlesForPerson = nameBasicRepo.getTitlesForPerson(name);
        return allTitlesForPerson;
    }

    @Override
    public List<String> getCharactersByTitles(List<String> titles) {
        return titlePrincipalsRepo.findAllCharactersByTite(titles);
    }
}
