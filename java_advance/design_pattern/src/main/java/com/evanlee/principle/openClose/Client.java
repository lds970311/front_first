// Author : evan lee
// Time ： 2022-02-21  21:10
// FILENAME : Client.java
// STATEMENT: 

package com.evanlee.principle.openClose;

/**
 * 开闭原则
 */
public class Client {
    public static void main(String[] args) {
        SougouInput sougouInput = new SougouInput();
        sougouInput.setSkin(new DefaultSkin());
        sougouInput.display();
        sougouInput.setSkin(new BingdundunSkin());
        sougouInput.display(); //bingdundun skinshowing
    }
}
