// Author : evan lee
// Time ： 2022-06-06  14:29
// FILENAME : TableBean.java
// STATEMENT: 

package com.evan.mapreduce.reduceJoin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@NoArgsConstructor
@Getter
@Setter
public class TableBean implements Writable {

    private String id;
    private String pid; //商品id
    private int amount; //商品数量
    private String pname; //商品名称
    private String flag; //标记是什么表 order pd


    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(id);
        dataOutput.writeUTF(pid);
        dataOutput.writeInt(amount);
        dataOutput.writeUTF(pname);
        dataOutput.writeUTF(flag);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readUTF();
        this.pid = dataInput.readUTF();
        this.amount = dataInput.readInt();
        this.pname = dataInput.readUTF();
        this.flag = dataInput.readUTF();
    }

    @Override
    public String toString() {
        return
                id + '\t' + amount + '\t' + pname;

    }
}
