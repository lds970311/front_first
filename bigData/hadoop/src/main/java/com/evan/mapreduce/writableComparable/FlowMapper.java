// Author : evan lee
// Time ： 2022-06-01  9:43
// FILENAME : FlowMapper.java
// STATEMENT: 

package com.evan.mapreduce.writableComparable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class FlowMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
    private FlowBean outKey = new FlowBean();
    private Text outValue = new Text();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, FlowBean, Text>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split("\t");
        //封装数据
        outValue.set(split[0]);
        outKey.setUpFlow(Long.parseLong(split[1]));
        outKey.setDownFlow(Long.parseLong(split[2]));
        outKey.setTotalFlow();

        context.write(outKey, outValue);
    }
}
