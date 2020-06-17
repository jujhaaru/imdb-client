package com.lunatech.assignment.imdb.client.repository;


import com.lunatech.assignment.imdb.client.entity.TitleBasic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TitleBasicRepo extends CrudRepository<TitleBasic, String> {

    @Query("Select tb.originalTitle from TitleBasic tb,TitleRating tr where tb.tconst=tr.tconst and tb.genres like %:genre%")
    List<String> getListOfTopRatedMovie(@Param("genre") String genre);


    @Query("Select tb.genres from TitleBasic tb where tb.tconst in :titleList ")
    List<String> getGenresByTitle(@Param("titleList") List<String> titleList);


}

