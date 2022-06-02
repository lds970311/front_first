// Author : evan lee
// Time ： 2022-06-01  9:43
// FILENAME : FlowMapper.java
// STATEMENT: 

package com.evan.mapreduce.writable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    private Text outKey = new Text();
    private FlowBean outValue = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] arr = line.split("\t");
        String phone = arr[1]; //手机号
        String up = arr[arr.length - 3]; //上行流量
        String down = arr[arr.length - 2]; //上行流量
        outKey.set(phone);
        outValue.setUpFlow(Long.parseLong(up));
        outValue.setDownFlow(Long.parseLong(down));
        outValue.setTotalFlow();

        context.write(outKey, outValue);
    }

}
