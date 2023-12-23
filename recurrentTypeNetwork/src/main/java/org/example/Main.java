package org.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main {
    public static void main(String[] args) {
        //Gateway to spark
        SparkSession spark = SparkSession
                .builder()
                .master("local[*]")
                .config("spark.sql.warehouse.dir", "/tmp/spark")
                .appName("SurvivalPredictionMLP")
                .getOrCreate();
        //Reading the training set and getting a glimpse of it
        Dataset<Row> df = spark.sqlContext()
                .read()
                .format("com.databricks.spark.csv")
                .option("header", "true")
                .option("inferSchema", "true")
                .load("data/train.csv");
        df.show();
    }
}