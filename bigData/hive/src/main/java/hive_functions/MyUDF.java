// Author : evan lee
// Time ： 2022-07-19  11:56
// FILENAME : MyUDF.java
// STATEMENT: 

package hive_functions;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

public class MyUDF extends GenericUDF {

    /**
     * 校验数据参数个数
     *
     * @param objectInspectors
     * @return
     * @throws UDFArgumentException
     */
    @Override
    public ObjectInspector initialize(ObjectInspector[] objectInspectors) throws UDFArgumentException {
        if (objectInspectors.length != 1) {
            throw new UDFArgumentException("参数个数不为1!");
        }
        return PrimitiveObjectInspectorFactory.javaIntObjectInspector;
    }

    /**
     * 处理数据
     *
     * @param deferredObjects
     * @return
     * @throws HiveException
     */
    @Override
    public Object evaluate(DeferredObject[] deferredObjects) throws HiveException {
        //取出输入数据
        String input = deferredObjects[0].get().toString();
        //判读输入数据是否为null
        if (input == null) return 0;
        return input.length();
    }

    /**
     * @param strings
     * @return
     */
    @Override
    public String getDisplayString(String[] strings) {
        return "";
    }
}
