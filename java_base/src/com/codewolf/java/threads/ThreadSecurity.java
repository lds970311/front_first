// Author : evan lee
// Time ： 2022-01-08  14:45
// FILENAME : ThreadSecurity.java
// STATEMENT: 线程安全问题

package com.codewolf.java.threads;

import lombok.Data;

@Data
class Account {
    private String id;
    private Double money;

    public Account(String id, Double money) {
        this.id = id;
        this.money = money;
    }

    public synchronized void cosume(double amount) {
        String name = Thread.currentThread().getName();
        if (this.money >= amount) {
            System.out.println(name + "取走了" + amount + "元");
            this.money -= amount;
            System.out.println("账户余额:" + this.money);
        } else {
            System.out.println(name + "显示账户余额不足");
        }
    }
}

class ThreadA implements Runnable {
    private Account account;

    public ThreadA(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.cosume(1000.0);
    }
}

public class ThreadSecurity {
    public static void main(String[] args) {
        Account account = new Account("CCB", 10000.0);
        for (int i = 0; i < 15; i++) {
            String tName = "Thread-" + i;
            new Thread(new ThreadA(account), tName).start();
        }
    }
}
