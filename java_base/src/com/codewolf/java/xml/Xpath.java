// Author : evan lee
// Time ： 2022-01-09  23:06
// FILENAME : Xpath.java
// STATEMENT: 

package com.codewolf.java.xml;

import lombok.SneakyThrows;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Xpath {

    @SneakyThrows
    @Test
    public void parse() {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(this.getClass().getResourceAsStream("/com/codewolf/java/xml/Contact.xml"));
        //检索name
        List<Node> nodes = document.selectNodes("/contactList/contact/name");
        for (Node node : nodes) {
            Element e = (Element) node;
            System.out.println(e.getText());
        }
    }
}
