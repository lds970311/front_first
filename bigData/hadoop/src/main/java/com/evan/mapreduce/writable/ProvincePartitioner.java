// Author : evan lee
// Time ： 2022-06-03  9:48
// FILENAME : ProvincePartitioner.java
// STATEMENT: 

package com.evan.mapreduce.writable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

//分区, 按照省份划分
public class ProvincePartitioner extends Partitioner<Text, FlowBean> {

    @Override
    public int getPartition(Text text, FlowBean flowBean, int i) {
        //获取手机号前三位 prePhone
        String phone = text.toString();
        String prePhone = phone.substring(0, 3);
        //定义一个分区号变量 partition,根据 prePhone 设置分区号
        int partition;
        if ("135".equals(prePhone)) {
            partition = 0;
        } else if ("137".equals(prePhone)) {
            partition = 1;
        } else if ("139".equals(prePhone)) {
            partition = 2;
        } else {
            partition = 3;
        }
        //最后返回分区号 partition
        return partition;
    }
}
