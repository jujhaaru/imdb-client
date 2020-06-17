package com.lunatech.assignment.imdb.client.service.impl;

import com.lunatech.assignment.imdb.client.dao.ImdbDao;
import com.lunatech.assignment.imdb.client.service.ImdbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ImdbServiceImpl implements ImdbService {

    private static final String KEVIN_BACON = "Kevin Bacon";
    @Autowired
    private ImdbDao imdbDao;


    @Override
    public List<String> getTopRatedMoviesByGenre(String genre, Long count) {
        log.debug("ImdbServiceImpl.getTopRatedMoviesByGenre invoked with genre : {} and count : {}", genre, count);
        List<String> topMovies = imdbDao.readTopRatedMovieByGenre(genre);
        if (count != null) {
            log.debug("ImdbServiceImpl.getTopRatedMoviesByGenre executed with List", topMovies);
            return topMovies.stream().limit(count).collect(Collectors.toList());
        }
        log.debug("ImdbServiceImpl.getTopRatedMoviesByGenre executed with List", topMovies);
        return topMovies;
    }

    @Override
    public boolean checkIfTypeCasted(String name) {
        log.debug("ImdbServiceImpl.checkIfTypeCasted invoked with actor : {}", name);
        List<String> allGenres = imdbDao.getGenresForActor(name);
        Map<String, Long> count = allGenres.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String key = count.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

        boolean isTypeCasted = (((float) count.get(key) / allGenres.size())) > .5 ? true : false;
        log.debug("ImdbServiceImpl.checkIfTypeCasted executed with value : {}", isTypeCasted);
        return isTypeCasted;
    }

    @Override
    public Integer getDegreeOfSeperation(String name) {
        log.debug("ImdbServiceImpl.getDegreeOfSeperation invoked with actor : {}", name);
        Integer degree = 0;
        List<String> titles = imdbDao.getTitlesForPerson(name);
        List<String> characters = imdbDao.getCharactersByTitles(titles);
        characters.forEach(System.out::println);
        if (characters.contains(KEVIN_BACON)) {
            return degree;
        }
        log.debug("ImdbServiceImpl.getDegreeOfSeperation executed with actor : {}", name);
        return degree;
    }


}
