// Author : evan lee
// Time ： 2022-07-18  16:10
// FILENAME : GuardedObject.java
// STATEMENT: 

package cn.evan.pattern;

public class GuardedObject {
    private final Object lock = new Object();
    private Object response;

    public Object get() {
        synchronized (lock) {
            // 条件不满足则等待
            while (response == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (lock) {
            // 条件满足，通知等待线程
            this.response = response;
            lock.notifyAll();
        }
    }
}
