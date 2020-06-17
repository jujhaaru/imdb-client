package com.lunatech.assignment.imdb.client.repository;

import com.lunatech.assignment.imdb.client.entity.NameBasic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NameBasicRepo extends CrudRepository<NameBasic, String> {

    NameBasic findByPrimaryName(String name);

    @Query("Select nb.knownForTitles from NameBasic nb where nb.primaryName like %:name%")
    List<String> getTitlesForPerson(@Param("name") String name);


}