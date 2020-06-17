package com.lunatech.assignment.imdb.client;

import com.lunatech.assignment.imdb.client.service.ImdbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ImdbClientApplicationTests {


    @Mock
    ImdbService imdbService;


    @Test
    public void givenGenre_When_Romance_then_ListMovies() {

        //given->genre=Romance,count=10

        List<String> moviesByGenre = Arrays.asList(
                "Pauvre Pierrot",
                "Miss Jerry",
                "La belle et la bête",
                "The Kiss in the Tunnel",
                "The Magic Sword",
                "The Messenger Boy's Mistake",
                "Raffles, the Amateur Cracksman",
                "Kathleen Mavourneen",
                "Kameliadamen",
                "Otello"
        );
        when(imdbService.getTopRatedMoviesByGenre(any(String.class), any(Long.class))).thenReturn(moviesByGenre);

        //when
        List<String> result = imdbService.getTopRatedMoviesByGenre("Romance", 10l);

        //then'
        assertThat(result).isEqualTo(moviesByGenre);

    }

    @Test
    public void givenActorNmae_When_Available_then_returnTypeCasted() {

        //given->actor=Kevin Spacey
        boolean isTypeCasted = true;
        when(imdbService.checkIfTypeCasted(any(String.class))).thenReturn(true);

        //when
        boolean result = imdbService.checkIfTypeCasted("Kevin Spacey");

        //then'
        assertThat(result).isEqualTo(isTypeCasted);
    }


    @Test
    public void givenAct_When_Available_then_returnDegreeSeperation() {

        //given value
        Integer type = 0;
        when(imdbService.getDegreeOfSeperation(any(String.class))).thenReturn(type);

        //when
        Integer result = imdbService.getDegreeOfSeperation("Kevin Spacey");

        //then'
        assertThat(result).isEqualTo(type);
    }


}
