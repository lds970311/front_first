// Author : evan lee
// Time ： 2022-06-01  9:43
// FILENAME : FlowReducer.java
// STATEMENT: 

package com.evan.mapreduce.writableComparable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class FlowReducer extends Reducer<FlowBean, Text, Text, FlowBean> {

    private final FlowBean outValue = new FlowBean();

    @Override
    protected void reduce(FlowBean key, Iterable<Text> values, Reducer<FlowBean, Text, Text, FlowBean>.Context context) throws IOException, InterruptedException {
        Iterator<Text> iterator = values.iterator();
        while (iterator.hasNext()) {
            Text next = iterator.next();
            context.write(next, key);
        }
    }
}
