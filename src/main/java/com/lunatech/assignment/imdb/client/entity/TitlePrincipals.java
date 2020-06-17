package com.lunatech.assignment.imdb.client.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "TITLE_PRINCIPALS")
@NoArgsConstructor
public class TitlePrincipals implements Serializable {


    @EmbeddedId
    private PrincipalsID pId;

    @Column
    private String nConst;

    @Column
    private String category;

    @Column
    private String job;

    @Column
    private String characters;


    public TitlePrincipals(List<String> rawList) {
        this.setPId(new PrincipalsID(rawList.get(0), rawList.get(1)));
        this.setNConst(rawList.get(2));
        this.setCategory(rawList.get(3));
        this.setJob(rawList.get(4));
        this.setCharacters(rawList.get(5));
    }
}
