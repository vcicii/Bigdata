package com.jy.mapreduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    @Override
    /*
     k1, v1 -> k2, v2
     key : k1
     value : v1
     context : 上下文对象
     */

    /*
    k1   v1
    0  hello,world
    15 hdfs,hadoop
    -----------------
    k2     v2
    hello   1
    hdfs    1
    world   1
     */

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        System.out.println("Map!");
        String[] wordList = value.toString().split(",");
        for (String word : wordList) {
            context.write(new Text(word), new LongWritable(1));
        }
    }
}
