package com.callRing.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.io.Serializable;
import java.util.*;

/**
 * Created by kcz on 2017/4/8.
 */
@Service
public class WordCount implements Serializable {
	private static final Logger logger = LoggerFactory.getLogger(WordCount.class);
	private static final long serialVersionUID = 732298285848234061L;
	public static final Map<String, Integer> map = new HashMap<>();

	public Map wordCount(List<String> wordList) {
		JavaSparkContext sc = null;
		SparkConf conf = new SparkConf().setAppName("WordCountLocal").setMaster("local");
		sc = new JavaSparkContext(conf);
		try {
			JavaRDD<String> lines = sc.parallelize(wordList);
			// JavaRDD<String> lines = sc.textFile("C:\\Users\\kcz\\Desktop\\test.txt");

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
					WordCount.map.put(wordCount._1, wordCount._2);
					System.out.println("成功了" + wordCount._1 + wordCount._2);
				}

			});
		} catch (Exception e) {
			logger.error("转换数据异常", e);
		} finally {
			sc.close();
		}

		return map;
	}

}
