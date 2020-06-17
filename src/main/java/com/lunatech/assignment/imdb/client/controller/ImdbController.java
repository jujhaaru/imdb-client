package com.lunatech.assignment.imdb.client.controller;

import com.lunatech.assignment.imdb.client.service.ImdbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
@Slf4j
@Api(value = "imdb-query-engine", description = "Operations on IMDB dataset with different search query")
public class ImdbController {

    @Autowired
    private ImdbService imdbService;


    @GetMapping(value = "/top/rated/genre/{genre}")
    @ApiOperation(value = "Top rated movies: Given a query by the user, this provide what are the top rated movies for a genre", response = List.class)
    ResponseEntity<List<String>> getTopRatedMovies(@PathVariable("genre") String genre, @RequestParam(value = "count", required = false) Long count) {
        log.info("ImdbController.getTopRatedMovies(String,String) invoked for genre : {} and count : {}", genre, count);
        List<String> movieList = imdbService.getTopRatedMoviesByGenre(genre, count);
        log.info("ImdbController.getTopRatedMovies(String,String) executed");
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PostMapping(value = "/check/typecasted")
    @ApiOperation(value = "Given a query by the user, where he/she provides an actor/actress name, the system determines if that person has become typecasted", response = Boolean.class)
    ResponseEntity<Boolean> checkIfTypeCasted(@RequestParam String name) {
        log.info("ImdbController.checkIfTypeCasted(String) invoked for actor : {} ", name);
        boolean isTypeCasted = imdbService.checkIfTypeCasted(name);
        log.info("ImdbController.checkIfTypeCasted(String) executed");
        return new ResponseEntity<>(isTypeCasted, HttpStatus.OK);
    }

    @PostMapping(value = "/degree/seperation")
    @ApiOperation(value = "Given a query by the user,this provides the degree of separation between the person (e.g. actor or actress) the user has entered and Kevin Bacon.", response = Integer.class)
    ResponseEntity<Integer> getDegreeOfSeperation(@RequestParam String name) {
        log.info("ImdbController.getDegreeOfSeperation(String) invoked for actor : {} ", name);
        Integer degree = imdbService.getDegreeOfSeperation(name);
        log.info("ImdbController.getDegreeOfSeperation(String) executed");
        return new ResponseEntity<>(degree, HttpStatus.OK);
    }


}
