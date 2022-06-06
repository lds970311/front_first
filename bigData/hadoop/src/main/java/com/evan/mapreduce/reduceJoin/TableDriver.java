// Author : evan lee
// Time ： 2022-06-06  15:22
// FILENAME : TableDriver.java
// STATEMENT: 

package com.evan.mapreduce.reduceJoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class TableDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(TableDriver.class);

        //关联mapper reducer
        job.setMapperClass(TableMapper.class);
        job.setReducerClass(TableReducer.class);

        //设置map输出的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(TableBean.class);

        //设置最终输出类型
        job.setOutputKeyClass(TableBean.class);
        job.setOutputValueClass(NullWritable.class);

        //设置输入输出路径
        FileInputFormat.setInputPaths(job, new Path("F:\\Java\\front_first\\bigData\\hadoop\\src\\test\\resources\\inputtable"));
        FileOutputFormat.setOutputPath(job, new Path("F:\\Java\\front_first\\bigData\\hadoop\\src\\test\\resources\\results1"));

        boolean completion = job.waitForCompletion(true);
        System.exit(completion ? 0 : 1);
    }
}
