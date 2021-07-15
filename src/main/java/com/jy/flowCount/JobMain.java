package com.jy.flowCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class JobMain extends Configured implements Tool {
    @Override
    public int run(String[] strings) throws Exception {
        System.out.println("run1");
        Job job = Job.getInstance(super.getConf(),"flowsort");
        job.setJarByClass(JobMain.class);

        job.setInputFormatClass(TextInputFormat.class);
//        TextInputFormat.addInputPath(job, new Path("file:////Users/vcicii/Desktop/flow_in"));
        TextInputFormat.addInputPath(job, new Path("hdfs://jikehadoop01:8020/user/student/wjy/input"));

        System.out.println("run2");
        job.setMapperClass(FlowSumMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        System.out.println("run3");

        job.setReducerClass(FlowSumReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);
        System.out.println("run4");

        job.setOutputFormatClass(TextOutputFormat.class);
//        TextOutputFormat.setOutputPath(job, new Path("file:////Users/vcicii/Desktop/flow_out1"));
        TextOutputFormat.setOutputPath(job, new Path("hdfs://jikehadoop01:8020/user/student/wjy/output"));
        System.out.println("run5");

        boolean res = job.waitForCompletion(true);
        return res ? 0:1;
    }


    public static void main(String[] args) throws Exception {
        //1. 获取配置信息
        Configuration conf = new Configuration();

        //2. 获取命令行参数，封装成String[]

        //3. 运行run方法，运行结果response
        int response = ToolRunner.run(conf, new JobMain(), args);

        if(response == 0){
            System.out.println("Job is successfully completed... ");
        }else{
            System.out.println("Job failed... ");
        }

        System.exit(response);

    }
}
