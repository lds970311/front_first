// Author : evan lee
// Time ： 2022-07-19  17:26
// FILENAME : MyUDTF.java
// STATEMENT: 

package hive_functions;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;
import java.util.List;

public class MyUDTF extends GenericUDTF {

    //输出数据的集合
    private ArrayList<String> outPutList = new ArrayList<>();

    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {

        //输出数据的默认列名,可以别别名覆盖
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("word");

        //输出数据的类型
        List<ObjectInspector> fieldOIs = new ArrayList<>();
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        //最终返回值
        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);
    }


    /**
     * 处理输入数据
     *
     * @param objects
     * @throws HiveException
     */
    @Override
    public void process(Object[] objects) throws HiveException {
        String input = objects[0].toString();
        String[] words = input.split(",");
        for (String word : words) {
            //清空集合
            outPutList.clear();
            outPutList.add(word);
            forward(outPutList);
        }
    }

    /**
     * 收尾
     *
     * @throws HiveException
     */
    @Override
    public void close() throws HiveException {

    }
}
