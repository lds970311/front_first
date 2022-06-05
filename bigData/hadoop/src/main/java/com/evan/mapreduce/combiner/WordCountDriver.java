// Author : evan lee
// Time ： 2022-05-31  21:57
// FILENAME : WordCountDriver.java
// STATEMENT: 

package com.evan.mapreduce.combiner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //获取job
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(WordCountDriver.class);

        //关联mapper reducer
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        //设置map输出的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //设置最终输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setCombinerClass(WordCountCombiner.class);

        //设置输入输出路径
        FileInputFormat.setInputPaths(job, new Path("F:\\Java\\front_first\\bigData\\hadoop\\src\\test\\resources\\words\\hello.txt"));
        FileOutputFormat.setOutputPath(job, new Path("F:\\Java\\front_first\\bigData\\hadoop\\src\\test\\resources\\results"));

        boolean completion = job.waitForCompletion(true);
        System.exit(completion ? 0 : 1);
    }
}
