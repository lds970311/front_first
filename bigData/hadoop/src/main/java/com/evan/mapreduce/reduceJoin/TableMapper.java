// Author : evan lee
// Time ： 2022-06-06  14:37
// FILENAME : TableMapper.java
// STATEMENT: 

package com.evan.mapreduce.reduceJoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class TableMapper extends Mapper<LongWritable, Text, Text, TableBean> {
    private String fileName;
    private Text outKey = new Text();
    private TableBean outValue = new TableBean();

    @Override
    protected void setup(Mapper<LongWritable, Text, Text, TableBean>.Context context) throws IOException, InterruptedException {
        FileSplit inputSplit = (FileSplit) context.getInputSplit();
        this.fileName = inputSplit.getPath().getName();
    }

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, TableBean>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        //判断是哪个文件
        if (this.fileName.contains("order")) {
            String[] r = line.split("\t");
            //封装kv
            outKey.set(r[1]);
            outValue.setId(r[0]);
            outValue.setPid(r[1]);
            outValue.setAmount(Integer.parseInt(r[2]));
            outValue.setPname("");
            outValue.setFlag("order");
        } else {
            //pd表
            String[] r = line.split("\t");
            outKey.set(r[0]);
            outValue.setFlag("pd");
            outValue.setPname(r[1]);
            outValue.setPid(r[0]);
            outValue.setId("");
            outValue.setAmount(0);
        }
        context.write(outKey, outValue);
    }
}
