// Author : evan lee
// Time ： 2022-02-20  19:32
// FILENAME : TransactionTest.java
// STATEMENT: 

package com.codewolf.newfeature.jdk8;

import com.codewolf.newfeature.jdk8.bean.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionTest {
    private static List<Transaction> transactions = null;

    static {
        Transaction.Trader raoul = new Transaction.Trader("Raoul", "Cambridge");
        Transaction.Trader mario = new Transaction.Trader("Mario", "Milan");
        Transaction.Trader alan = new Transaction.Trader("Alan", "Cambridge");
        Transaction.Trader brian = new Transaction.Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //找出2011年发生的所有交易， 并按交易额排序（从低到高）
    @Test
    public void testA() {
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);
    }

    //交易员都在哪些不同的城市工作过？
    @Test
    public void getCities() {
        List<String> collect = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    //查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void getTraders() {
        transactions.stream()
                .filter((t) -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Transaction.Trader::getName))
                .distinct()
                .forEach(System.out::println);
    }

    //返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void sortNames() {
        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .forEach(System.out::println);
    }

    //有没有交易员是在米兰工作的？
    @Test
    public void findAny() {
        boolean milan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }

    //打印生活在剑桥的交易员的所有交易额
    @Test
    public void getSum() {
        Integer cambridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum)
                .get();
        System.out.println(cambridge); //2650
    }

    //所有交易中，最高的交易额是多少
    @Test
    public void getMax() {
        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.naturalOrder())
                .get();
        System.out.println(max);
    }

    //找到交易额最小的交易
    @Test
    public void getMin() {
        Integer min = transactions.stream()
                .map(Transaction::getValue)
                .min(Comparator.naturalOrder())
                .get();
        System.out.println(min);
    }
}
