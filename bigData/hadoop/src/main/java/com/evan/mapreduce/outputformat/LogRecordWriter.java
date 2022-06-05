// Author : evan lee
// Time ： 2022-06-04  16:35
// FILENAME : LogRecordWriter.java
// STATEMENT: 

package com.evan.mapreduce.outputformat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class LogRecordWriter extends RecordWriter<Text, NullWritable> {
    private FSDataOutputStream out1;
    private FSDataOutputStream out2;

    public LogRecordWriter(TaskAttemptContext taskAttemptContext) {
        //创建2条流
        try {
            FileSystem fileSystem = FileSystem.get(taskAttemptContext.getConfiguration());
            this.out1 = fileSystem.create(new Path("F:\\Java\\front_first\\bigData\\hadoop\\src\\test\\resources\\results\\evan.txt"));
            this.out2 = fileSystem.create(new Path("F:\\Java\\front_first\\bigData\\hadoop\\src\\test\\resources\\results\\others.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(Text text, NullWritable nullWritable) throws IOException, InterruptedException {
        String line = text.toString();
        if (line.contains("atguigu")) {
            out1.write(line.getBytes());
        } else {
            out2.writeBytes(line + "\n");
        }
    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        IOUtils.closeStream(out2);
        IOUtils.closeStream(out1);
    }
}
