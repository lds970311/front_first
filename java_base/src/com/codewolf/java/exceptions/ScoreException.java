// Author : evan lee
// Time ： 2022-01-04  20:03
// FILENAME : ScoreException.java
// STATEMENT: 

package com.codewolf.java.exceptions;

public class ScoreException extends Exception {
    static final long serialVersionUID = -5564897190745766939L;

    public ScoreException() {
    }

    public ScoreException(String message) {
        super(message);
    }
}
