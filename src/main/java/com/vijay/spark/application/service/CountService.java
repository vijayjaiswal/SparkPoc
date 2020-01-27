package com.vijay.spark.application.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CountService {
    @Autowired
    private SparkSession sparkSession;



    @Autowired
    JavaSparkContext sc;

    public Map<String, Long> count() {
        String input = "hello world hello hello hello";
        String[] _words = input.split(" ");
        List<String> wordList = Arrays.stream(_words).map(String::new).collect(Collectors.toList());

        JavaRDD<String> words = sc.parallelize(wordList);
        Map<String, Long> wordCounts = words.countByValue();
        return wordCounts;
    }
}
