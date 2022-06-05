// Author : evan lee
// Time ： 2022-06-04  16:27
// FILENAME : LogReducer.java
// STATEMENT: 

package com.evan.mapreduce.outputformat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class LogReducer extends Reducer<Text, NullWritable, Text, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<NullWritable> values, Reducer<Text, NullWritable, Text, NullWritable>.Context context) throws IOException, InterruptedException {
        //防止相同数据丢失
        for (NullWritable value : values) {
            context.write(key, NullWritable.get());
        }
    }
}
