package com.jy.flowSort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowSortMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        System.out.println("map!");

        String[] split = value.toString().split("\t");
        String phoneNum = split[0];
        FlowBean bean = new FlowBean();

        bean.setUpFlow(Integer.parseInt(split[1]));
        bean.setDownFlow(Integer.parseInt(split[2]));
        bean.setSumFlow(Integer.parseInt(split[3]));
        System.out.println(bean);
        context.write(bean, new Text(phoneNum));

    }
}
