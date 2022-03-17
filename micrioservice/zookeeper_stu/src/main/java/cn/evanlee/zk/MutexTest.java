// Author : evan lee
// Time ： 2022-03-17  3:10
// FILENAME : MutexTest.java
// STATEMENT: 

package cn.evanlee.zk;

public class MutexTest {
    public static void main(String[] args) {
        Ticket12306 ticket12306 = new Ticket12306();
        Thread t1 = new Thread(ticket12306, "携程");
        Thread t2 = new Thread(ticket12306, "去哪儿网");
        Thread t3 = new Thread(ticket12306, "飞猪");
        t1.start();
        t2.start();
        t3.start();
    }
}
