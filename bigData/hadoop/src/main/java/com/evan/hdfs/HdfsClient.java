// Author : evan lee
// Time ： 2022-05-30  11:56
// FILENAME : HdfsClient.java
// STATEMENT: 

package com.evan.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class HdfsClient {

    private FileSystem fileSystem;

    @Before
    public void initFileSystem() throws URISyntaxException, IOException, InterruptedException {
        Configuration configuration = new Configuration();
        //获取文件系统
        fileSystem = FileSystem.get(new URI("hdfs://hadoop149:8020"), configuration, "evanLee");
    }

    @Test
    public void mkdirTest() throws IOException {
        fileSystem.mkdirs(new Path("/xiyou/huaguoshan/"));
    }

    @Test
    public void putTest() throws IOException {
        Path src = new Path("F:\\Java\\front_first\\bigData\\hadoop\\src\\main\\resources\\log4j.properties");
        Path dest = new Path("/xiyou");
        fileSystem.copyFromLocalFile(false, true, src, dest);
    }

    @Test
    public void downloadTest() throws IOException {
        Path src = new Path("/xiyou/huaguoshan");
        Path dest = new Path("F:\\Java\\front_first\\bigData\\hadoop\\src\\main\\resources\\downloads");
        fileSystem.copyToLocalFile(false, src, dest, false);
    }

    @Test
    public void renameTest() throws IOException {
        fileSystem.rename(new Path("/xiyou/huaguoshan/sunwukong.txt"), new
                Path("/xiyou/huaguoshan/meihouwang.txt"));
    }

    @Test
    public void deleteTest() throws IOException {
        fileSystem.delete(new Path("/xiyou"), true);
    }

    @Test
    public void fileInfoTest() throws IOException {
        RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(new Path("/"), true);
        while (files.hasNext()) {
            LocatedFileStatus fileStatus = files.next();
            System.out.println("========" + fileStatus.getPath() + "=========");
            System.out.println(fileStatus.getPermission());
            System.out.println(fileStatus.getOwner());
            System.out.println(fileStatus.getGroup());
            System.out.println(fileStatus.getLen());
            System.out.println(fileStatus.getModificationTime());
            System.out.println(fileStatus.getReplication());
            System.out.println(fileStatus.getBlockSize());
            System.out.println(fileStatus.getPath().getName());

            // 获取块信息
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            System.out.println(Arrays.toString(blockLocations));
        }
    }

    @Test
    public void fileStatusTest() throws IOException {
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/"));
        for (FileStatus fileStatus : fileStatuses) {
            // 如果是文件
            if (fileStatus.isFile()) {
                boolean directory = fileStatus.isDirectory();
                System.out.println("f:" + fileStatus.getPath().getName());
            } else {
                System.out.println("d:" + fileStatus.getPath().getName());
            }
        }
    }


    @After
    public void close() throws IOException {
        fileSystem.close();
    }
}
