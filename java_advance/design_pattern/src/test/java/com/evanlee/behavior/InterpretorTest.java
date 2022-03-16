// Author : evan lee
// Time ： 2022-03-15  0:00
// FILENAME : InterpretorTest.java
// STATEMENT: 

package com.evanlee.behavior;

import com.evanlee.behavior.interpretor.*;
import org.junit.jupiter.api.Test;

public class InterpretorTest {
    @Test
    void interpret() {
        Context context = new Context();

        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");
        Variable e = new Variable("e");
        //Value v = new Value(1);

        context.assign(a, 1);
        context.assign(b, 2);
        context.assign(c, 3);
        context.assign(d, 4);
        context.assign(e, 5);

        AbstractExpression expression = new Minus(new Plus(new Plus(new Plus(a, b), c), d), e);
        int result = expression.interpret(context);
        System.out.println(expression + "= " + result);
    }
}
