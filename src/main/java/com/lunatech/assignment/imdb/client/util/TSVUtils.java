package com.lunatech.assignment.imdb.client.util;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Component
public class TSVUtils {


    private static final int LARGE_NUMBER = 50000;


    public List<List<String>> tokenizeTSVToPojo(String url) throws Exception {

        List<List<String>> responseObject = new ArrayList<>();
        Path path = Paths.get(url);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int count = 0;
            String line;
            while ((line = reader.readLine()) != null && count != LARGE_NUMBER) {
                StringTokenizer st = new StringTokenizer(line, "\t");
                responseObject.add(Collections.list(st).stream().map(token -> ((String) token).replace("\\N", "null")).collect(Collectors.toList()));
                count++;
            }
        }
        return responseObject;
    }

}
