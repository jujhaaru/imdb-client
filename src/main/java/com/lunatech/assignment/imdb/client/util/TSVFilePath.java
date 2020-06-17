package com.lunatech.assignment.imdb.client.util;

public enum TSVFilePath {

    NAME_BASICS("Z:\\imdb-client\\src\\main\\resources\\name_basic.tsv"),
    TITLE_BASICS("Z:\\imdb-client\\src\\main\\resources\\title_basic.tsv"),
    TITLE_PRINCIPALS("Z:\\imdb-client\\src\\main\\resources\\title_principals.tsv"),
    TITLE_RATINGS("Z:\\imdb-client\\src\\main\\resources\\title_ratings.tsv");

    private String path;

    TSVFilePath(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }

}
