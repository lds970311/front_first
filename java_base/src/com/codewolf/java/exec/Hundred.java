// Author : evan lee
// Time ： 2022-01-01  23:10
// FILENAME : Hundred.java

/*
  我国古代数学家张丘建在《算经》一书中提出的数学问题：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。   百钱
  买百鸡，问鸡翁、鸡母、鸡雏各几何
 */

package com.codewolf.java.exec;

public class Hundred {
    public static void test() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 33; j++) {
                int k = 100 - i - j;
                if (k % 3 == 0 && 5 * i + 3 * j + k / 3 == 100) {
                    System.out.printf("鸡翁%d 鸡母%d 鸡雏%d\n", i, j, k);
                }
            }
        }
    }

    public static void main(String[] args) {
        test();
    }
}
