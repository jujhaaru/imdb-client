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
@Entity
@Table(name = "Title_Rating")
@NoArgsConstructor
public class TitleRating implements Serializable {
    @Id
    @Column
    private String tconst;

    @Column
    private String averageRating;

    @Column
    private String numVotes;

    public TitleRating(List<String> rawList) {
        this.setTconst(rawList.get(0));
        this.setAverageRating(rawList.get(1));
        this.setNumVotes(rawList.get(2));
    }


}
