// Author : evan lee
// Time ： 2022-06-06  14:37
// FILENAME : TableMapper.java
// STATEMENT: 

package com.evan.mapreduce.mapjoin;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class TableMapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    private Text outKey = new Text();
    private Map<String, String> pdMap = new HashMap<>();

    @Override
    protected void setup(Mapper<LongWritable, Text, Text, NullWritable>.Context context) throws IOException, InterruptedException {
        //获取缓存文件, 读取内容
        URI[] cacheFiles = context.getCacheFiles();
        FileSystem fileSystem = FileSystem.get(context.getConfiguration());
        FSDataInputStream inputStream = fileSystem.open(new Path(cacheFiles[0]));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line;
        while (StringUtils.isNotEmpty(line = bufferedReader.readLine())) {
            //切割
            String[] r = line.split("\t");
            pdMap.put(r[0], r[1]);
        }
        IOUtils.closeStream(bufferedReader);
    }

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] fields = line.split("\t");
        //获取pid
        String pName = this.pdMap.get(fields[1]);
        outKey.set(fields[0] + "\t" + pName + "\t" + fields[2]);
        context.write(outKey, NullWritable.get());
    }
}
