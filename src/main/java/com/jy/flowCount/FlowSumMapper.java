package com.jy.flowCount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowSumMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        System.out.println("map!");
        String[] split = value.toString().split("\t");
        String phoneNum = split[1];
        FlowBean bean = new FlowBean();

        bean.setUpFlow(Integer.parseInt(split[8]));
        bean.setDownFlow(Integer.parseInt(split[9]));
        context.write(new Text(phoneNum), bean);


    }
}
