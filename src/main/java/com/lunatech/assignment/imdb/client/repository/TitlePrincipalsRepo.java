package com.lunatech.assignment.imdb.client.repository;


import com.lunatech.assignment.imdb.client.entity.TitlePrincipals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TitlePrincipalsRepo extends CrudRepository<TitlePrincipals, String> {

    @Query("Select tp.nConst from TitlePrincipals tp where tp.pId.tconst in :titles")
    List<String> findAllCharactersByTite(List<String> titles);
}

