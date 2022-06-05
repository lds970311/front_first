// Author : evan lee
// Time ： 2022-06-04  16:27
// FILENAME : LogDriver.java
// STATEMENT: 

package com.evan.mapreduce.outputformat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class LogDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(LogDriver.class);

        //关联mapper reducer
        job.setMapperClass(LogMapper.class);
        job.setReducerClass(LogReducer.class);

        //设置map输出的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        //设置最终输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        //设置outputformat
        job.setOutputFormatClass(LogOutputFormat.class);

        //设置输入输出路径
        FileInputFormat.setInputPaths(job, new Path("F:\\Java\\front_first\\bigData\\hadoop\\src\\test\\resources\\words\\log.txt"));
        FileOutputFormat.setOutputPath(job, new Path("F:\\Java\\front_first\\bigData\\hadoop\\src\\test\\resources\\results"));

        boolean completion = job.waitForCompletion(true);
        System.exit(completion ? 0 : 1);
    }
}
