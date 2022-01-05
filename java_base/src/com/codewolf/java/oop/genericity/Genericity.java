// Author : evan lee
// Time ： 2022-01-05  15:07
// FILENAME : Genericity.java
// STATEMENT: 泛型; 泛型可以在编译阶段约束只能操作某种数据类型。

package com.codewolf.java.oop.genericity;

public class Genericity {
    public <T> void printArray(T[] arr) {
        if (arr != null) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(i == arr.length - 1 ? "" : ", ");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 6, 5, 2, 3};
        Genericity genericity = new Genericity();
        genericity.printArray(arr);
    }
}
