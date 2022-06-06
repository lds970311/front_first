// Author : evan lee
// Time ： 2022-06-06  15:06
// FILENAME : TableReducer.java
// STATEMENT: 

package com.evan.mapreduce.reduceJoin;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TableReducer extends Reducer<Text, TableBean, TableBean, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<TableBean> values, Reducer<Text, TableBean, TableBean, NullWritable>.Context context) throws IOException, InterruptedException {
        List<TableBean> orderList = new ArrayList<>();
        TableBean tableBean = new TableBean();
        for (TableBean value : values) {
            if ("order".equals(value.getFlag())) {
                //订单表
                TableBean tempBean = new TableBean();
                try {
                    BeanUtils.copyProperties(tempBean, value);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                orderList.add(tempBean);
            } else {
                //pd表
                try {
                    BeanUtils.copyProperties(tableBean, value);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //遍历order, 把pid替换成pname
        for (TableBean bean : orderList) {
            bean.setPname(tableBean.getPname());
            context.write(bean, NullWritable.get());
        }
    }
}
