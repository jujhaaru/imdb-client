package com.lunatech.assignment.imdb.client.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ImdbErrorResponse {

    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private List<String> details;
}
