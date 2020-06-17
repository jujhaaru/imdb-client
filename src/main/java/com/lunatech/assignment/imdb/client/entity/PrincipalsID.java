package com.lunatech.assignment.imdb.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalsID implements Serializable {


    @Column
    private String tconst;

    @Column
    private String ordering;


}


