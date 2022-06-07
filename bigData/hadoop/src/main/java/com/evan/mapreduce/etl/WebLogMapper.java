// Author : evan lee
// Time ： 2022-06-06  19:01
// FILENAME : WebLogMapper.java
// STATEMENT: 

package com.evan.mapreduce.etl;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WebLogMapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split(" ");
        if (split.length > 13) {
            context.write(value, NullWritable.get());
        }
    }
}
