package com.lunatech.assignment.imdb.client.repository;

import com.lunatech.assignment.imdb.client.entity.TitleRating;
import org.springframework.data.repository.CrudRepository;

public interface TitleRatingRepo extends CrudRepository<TitleRating, String> {
}
