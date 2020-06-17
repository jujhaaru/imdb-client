package com.lunatech.assignment.imdb.client.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "Name_Basic")
@Entity
@NoArgsConstructor
public class NameBasic implements Serializable {


    @Column
    String primaryProfession;
    @Column
    String knownForTitles;
    @Id
    @Column
    private String nconst;
    @Column
    private String primaryName;
    @Column
    private String birthYear;
    @Column
    private String deathYear;

    public NameBasic(List<String> rawList) {
        this.setNconst(rawList.get(0));
        this.setPrimaryName(rawList.get(1));
        this.setBirthYear(rawList.get(2));
        this.setDeathYear(rawList.get(3));
        this.setPrimaryProfession(rawList.get(4));
        this.setKnownForTitles(rawList.get(5));
    }


}
