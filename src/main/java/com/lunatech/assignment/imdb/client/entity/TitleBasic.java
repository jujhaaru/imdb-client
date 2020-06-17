package com.lunatech.assignment.imdb.client.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "Title_Basic")
@Entity
public class TitleBasic implements Serializable {
    @Column
    @Id
    @ApiModelProperty(notes = "alphanumeric unique identifier of the title")
    private String tconst;

    @Column
    @ApiModelProperty("the type/format of the title (e.g. movie, short, tvseries, tvepisode, video, etc)")
    private String titleType;

    @Column
    @ApiModelProperty("the more popular title / the title used by the filmmakers")
    private String primaryTitle;

    @Column
    @ApiModelProperty("original title, in the original language")
    private String originalTitle;

    @Column
    @ApiModelProperty("0: non-adult title; 1: adult title")
    private String isAdult;

    @Column
    @ApiModelProperty("represents the release year of a title. In the case of TV Series, it is the series start year")
    private String startYear;

    @Column
    @ApiModelProperty("TV Series end year. ‘\\N’ for all other title types")
    private String endYear;

    @Column
    @ApiModelProperty("primary runtime of the title, in minutes")
    private String runtimeMinutes;

    @Column
    @ApiModelProperty("includes up to three genres associated with the title")
    private String genres;

    public TitleBasic(List<String> rawList) {
        this.setTconst(rawList.get(0));
        this.setTitleType(rawList.get(1));
        this.setPrimaryTitle(rawList.get(2));
        this.setOriginalTitle(rawList.get(3));
        this.setIsAdult(rawList.get(4));
        this.setStartYear(rawList.get(5));
        this.setEndYear(rawList.get(6));
        this.setRuntimeMinutes(rawList.get(7));
        this.setGenres(rawList.get(8));
    }


}
