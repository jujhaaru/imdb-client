package com.lunatech.assignment.imdb.client.config;

import com.lunatech.assignment.imdb.client.entity.NameBasic;
import com.lunatech.assignment.imdb.client.entity.TitleBasic;
import com.lunatech.assignment.imdb.client.entity.TitlePrincipals;
import com.lunatech.assignment.imdb.client.entity.TitleRating;
import com.lunatech.assignment.imdb.client.repository.NameBasicRepo;
import com.lunatech.assignment.imdb.client.repository.TitleBasicRepo;
import com.lunatech.assignment.imdb.client.repository.TitlePrincipalsRepo;
import com.lunatech.assignment.imdb.client.repository.TitleRatingRepo;
import com.lunatech.assignment.imdb.client.util.TSVFilePath;
import com.lunatech.assignment.imdb.client.util.TSVUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableBatchProcessing
@Slf4j
public class JobFlow {
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private TSVUtils tsvUtils;

    @Autowired
    private NameBasicRepo nameBasicRepo;

    @Autowired
    private StepBuilderFactory steps;


    @Autowired
    private TitleBasicRepo titleBasicRepo;


    @Autowired
    private TitleRatingRepo titleRatingRepo;


    @Autowired
    private TitlePrincipalsRepo titlePrincipalsRepo;

    @Bean
    public Step processNameBasic() {
        return steps.get("processNameBasicStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Writing Name Basic to H2");
                    List<List<String>> rawData = tsvUtils.tokenizeTSVToPojo(TSVFilePath.NAME_BASICS.path());
                    List<NameBasic> parsedData = rawData.stream().filter(obj -> obj.size() == 6).map(obj -> new NameBasic(obj)).collect(Collectors.toList());
                    nameBasicRepo.saveAll(parsedData);
                    return RepeatStatus.FINISHED;
                })
                .build();
    }


    @Bean
    public Step processTitleBasic() {
        return steps.get("processTitleBasic")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Writing Title Basics to H2");
                    List<List<String>> rawData = tsvUtils.tokenizeTSVToPojo(TSVFilePath.TITLE_BASICS.path());
                    List<TitleBasic> parsedData = rawData.parallelStream().filter(obj -> obj.size() == 9).map(obj -> new TitleBasic(obj)).collect(Collectors.toList());
                    titleBasicRepo.saveAll(parsedData);
                    return RepeatStatus.FINISHED;
                })
                .build();
    }


    @Bean
    public Step processTitlePrincipals() {
        return steps.get("processTitlePrincipals")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Writing Title principals to H2");
                    List<List<String>> rawData = tsvUtils.tokenizeTSVToPojo(TSVFilePath.TITLE_PRINCIPALS.path());
                    List<TitlePrincipals> parsedData = rawData.parallelStream().filter(obj -> obj.size() == 6).map(obj -> new TitlePrincipals(obj)).collect(Collectors.toList());
                    titlePrincipalsRepo.saveAll(parsedData);
                    return RepeatStatus.FINISHED;
                })
                .build();
    }


    @Bean
    public Step processTitleRating() {
        return steps.get("processTitleRating")
                .tasklet((contribution, chunkContext) -> {
                    log.info("read title Rating");
                    List<List<String>> rawData = tsvUtils.tokenizeTSVToPojo(TSVFilePath.TITLE_RATINGS.path());
                    List<TitleRating> parsedData = rawData.parallelStream().filter(obj -> obj.size() == 3).map(obj -> new TitleRating(obj)).collect(Collectors.toList());
                    titleRatingRepo.saveAll(parsedData);
                    return RepeatStatus.FINISHED;
                })
                .build();
    }


    @Bean
    public Job job() {
        return jobs.get("job")
                .start(processNameBasic())
                .next(processTitleBasic())
                .next(processTitlePrincipals())
                .next(processTitleRating())
                .build();
    }
}
