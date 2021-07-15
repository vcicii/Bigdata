package com.jy.flowCount;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowSumReduce extends Reducer<Text, FlowBean, Text, FlowBean> {
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        System.out.println("reduce!");
        Integer upFlow = 0;
        Integer downFlow = 0;
        Integer sumFlow = 0;
        for (FlowBean value : values) {
            upFlow += value.getUpFlow();
            downFlow += value.getDownFlow();
        }
        sumFlow = upFlow + downFlow;
        FlowBean bean = new FlowBean();
        bean.setUpFlow(upFlow);
        bean.setDownFlow(downFlow);
        bean.setSumFlow(sumFlow);
        context.write(key, bean);

    }
}
