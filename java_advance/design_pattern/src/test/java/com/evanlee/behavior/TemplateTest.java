// Author : evan lee
// Time ： 2022-03-07  20:48
// FILENAME : TemplateTest.java
// STATEMENT: 

package com.evanlee.behavior;

import com.evanlee.behavior.template.ConcreteClass_BaoCai;
import com.evanlee.behavior.template.ConcreteClass_CaiXin;
import org.junit.jupiter.api.Test;

//模板方法测试
public class TemplateTest {
    @Test
    void template() {
        ConcreteClass_CaiXin caiXin = new ConcreteClass_CaiXin();
        caiXin.cookProcess();
        /* 倒油
          热油
        下锅的蔬菜是菜心
        下锅的酱料是蒜蓉
        炒啊炒啊炒到熟啊*/

        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        baoCai.cookProcess();
        /*
        倒油
        热油
        下锅的蔬菜是包菜
        下锅的酱料是辣椒
        炒啊炒啊炒到熟啊
         */
    }
}
