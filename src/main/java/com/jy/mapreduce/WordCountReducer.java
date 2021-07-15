package com.jy.mapreduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

    /*
    key : k2
    values : [v2]
     */

    /*
    k2      v2
    hadoop  <1,1,1>
    hello   <1,1>
    java    <1,1,1>
    ----------------
    k3      v3
    hadoop  3
    hello   2
    java    3
     */
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        System.out.println("Reduce!");

        long count = 0;
        for (LongWritable value : values) {
            count += value.get();
        }
        context.write(key,new LongWritable(count));
    }
}
