package com.codewolf.java.scanner;

// Author : CSR丶SUSE
// Time ： 2022-01-01  0:17
// TOOLS : INTELLIJ IDEA
// FILENAME : Input.java
// STATEMENT: 


import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String str = scanner.nextLine();
        System.out.println(a);
    }
}
