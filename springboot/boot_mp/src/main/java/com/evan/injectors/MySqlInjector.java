// Author : evan lee
// Time ： 2022-02-15  20:20
// FILENAME : MySqlInjector.java
// STATEMENT: 

package com.evan.injectors;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;

import java.util.ArrayList;
import java.util.List;

public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        //获取父类中的集合
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        List<AbstractMethod> abstractMethodList = new ArrayList<>(methodList);
        //扩充自定义方法
        abstractMethodList.add(new FindByAge());
        return abstractMethodList;
    }
}
