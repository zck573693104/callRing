package com.callRing.spark;

import org.apache.spark.api.java.function.VoidFunction;

import org.junit.Test;
import scala.Tuple2;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kcz on 2017/4/8.
 */
public class TestSpark implements Serializable {

    private static final long serialVersionUID = 732298285848234061L;

    @Test
    public void test (){
        SparkConf conf = new SparkConf()
                .setAppName("WordCountLocal")
                .setMaster("local");
        List list = new ArrayList();
        list.add("1");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> lines=   sc.parallelize(list);
     //   JavaRDD<String> lines = sc.textFile("C:\\Users\\kcz\\Desktop\\test.txt");


        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {

            private static final long serialVersionUID = 1L;


            public Iterable<String> call(String line) throws Exception {
                return Arrays.asList(line.split(" "));
            }

        });


        JavaPairRDD<String, Integer> pairs = words.mapToPair(

                new PairFunction<String, String, Integer>() {

                    private static final long serialVersionUID = 1L;


                    public Tuple2<String, Integer> call(String word) throws Exception {
                        return new Tuple2<String, Integer>(word, 1);
                    }

                });

        JavaPairRDD<String, Integer> wordCounts = pairs.reduceByKey(

                new Function2<Integer, Integer, Integer>() {

                    private static final long serialVersionUID = 1L;


                    public Integer call(Integer v1, Integer v2) throws Exception {
                        return v1 + v2;
                    }

                });


        wordCounts.foreach(new VoidFunction<Tuple2<String, Integer>>() {

            private static final long serialVersionUID = 1L;


            public void call(Tuple2<String, Integer> wordCount) throws Exception {
                System.out.println(wordCount._1 + " appeared " + wordCount._2 + " times.");
            }

        });

        sc.close();
    }
}
