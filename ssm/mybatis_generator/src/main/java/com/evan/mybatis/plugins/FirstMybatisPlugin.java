// Author : evan lee
// Time ： 2022-02-12  19:33
// FILENAME : FirstMybatisPlugin.java
// STATEMENT: 

package com.evan.mybatis.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * 完成插件签名：
 * 告诉MyBatis当前插件用来拦截哪个对象的哪个方法
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "parameterize", args = {Statement.class})
})
public class FirstMybatisPlugin implements Interceptor {

    /**
     * 拦截牧宝对象的目标方法
     *
     * @param invocation
     * @return 执行后的返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("FirstMybatisPlugin: intercept" + invocation.getMethod());
        //执行目标方法
        return invocation.proceed();
    }

    /**
     * 包装目标对象, 为目标对象创建一个代理对象
     *
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("FirstMybatisPlugin: plugin" + target);
        //我们可以借助Plugin的wrap方法来使用当前Interceptor包装我们目标对象
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息：" + properties);
    }
}
