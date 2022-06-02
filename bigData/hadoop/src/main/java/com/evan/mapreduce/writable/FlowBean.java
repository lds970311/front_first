// Author : evan lee
// Time ： 2022-06-01  9:43
// FILENAME : FlowBean.java
// STATEMENT: 

package com.evan.mapreduce.writable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@NoArgsConstructor
public class FlowBean implements Writable {

    @Getter
    @Setter
    private Long upFlow; //上行流量
    @Getter
    @Setter
    private Long downFlow;
    @Getter
    private Long totalFlow;

    public void setTotalFlow() {
        this.totalFlow = upFlow + downFlow;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upFlow);
        dataOutput.writeLong(downFlow);
        dataOutput.writeLong(totalFlow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        upFlow = dataInput.readLong();
        downFlow = dataInput.readLong();
        totalFlow = dataInput.readLong();
    }

    @Override
    public String toString() {
        return upFlow + "\t" + downFlow + "\t" + totalFlow;
    }
}
