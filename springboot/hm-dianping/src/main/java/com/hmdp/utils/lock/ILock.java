// Author : evan lee
// Time ： 2022-05-24  20:17
// FILENAME : ILock.java
// STATEMENT: 

package com.hmdp.utils.lock;

public interface ILock {

    /**
     * 尝试获取分布式锁
     *
     * @param timeoutSeconds 超时时间
     * @return 成功/失败
     */
    boolean tryLock(long timeoutSeconds);

    /**
     * 释放锁
     */
    void unlock();
}
