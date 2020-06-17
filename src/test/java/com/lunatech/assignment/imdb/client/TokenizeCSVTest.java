package com.lunatech.assignment.imdb.client;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TokenizeCSVTest {

    public static void main(String[] args) throws Exception {


        //StringTokenizer st = new StringTokenizer(value, "\t");

        //TSVUtils utils = new TSVUtils();
        //  List<List<String>> value = utils.tokenizeTSVToPojo("Z:\\imdb-client\\src\\main\\resources\\title_principals_test.tsv");
        Path path = Paths.get("Z:\\imdb-client\\src\\main\\resources\\name_basic.tsv");
//        Stream<String> lines1 = Files.lines(path);
//        List<String> lines = lines1.collect(Collectors.toList());
//        lines1.close();
        // lines.stream().limit(100).collect(Collectors.toList()).forEach(System.out::println);

        // value.forEach(System.out::print);
        // Collections.list(st).stream().map(token -> (String) token).collect(Collectors.toList()).forEach(System.out::print);

        //String fileName = ...;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int count = 0;
            String line;
            while ((line = reader.readLine()) != null /*&& count!=100*/) {
                StringTokenizer st = new StringTokenizer(line, "\t");
                Collections.list(st).stream().map(token -> ((String) token).replace("\\N", "null")).collect(Collectors.toList()).forEach(System.out::println);
                System.out.println();
                count++;
            }

        }
    }

}


