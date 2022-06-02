// Author : evan lee
// Time ： 2022-06-01  9:43
// FILENAME : FlowReducer.java
// STATEMENT: 

package com.evan.mapreduce.writable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class FlowReducer extends Reducer<Text, FlowBean, Text, FlowBean> {

    private final FlowBean outValue = new FlowBean();

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Reducer<Text, FlowBean, Text, FlowBean>.Context context) throws IOException, InterruptedException {
        Iterator<FlowBean> iterator = values.iterator();
        long totalUp = 0;
        long totalDown = 0;
        while (iterator.hasNext()) {
            FlowBean flowBean = iterator.next();
            totalUp += flowBean.getUpFlow();
            totalDown += flowBean.getDownFlow();
        }
        //封装outk, outv
        outValue.setUpFlow(totalUp);
        outValue.setDownFlow(totalDown);
        outValue.setTotalFlow();

        context.write(key, outValue);
    }
}
