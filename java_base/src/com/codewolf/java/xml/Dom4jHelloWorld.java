// Author : evan lee
// Time ： 2022-01-09  21:56
// FILENAME : Dom4jHelloWorld.java
// STATEMENT: 

package com.codewolf.java.xml;

import lombok.Data;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Data
class Contact {
    private String name;
    private String gender;
    private String email;

    public Contact() {
    }

    public Contact(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }
}

public class Dom4jHelloWorld {

    public static void parseXML() {
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = Dom4jHelloWorld.class.getResourceAsStream("/com/codewolf/java/xml/Contact.xml");
        try {
            Document document = saxReader.read(inputStream);
            Element root = document.getRootElement();
            //获取子元素
            List<Element> elements = root.elements("contact");
            for (Element element : elements) {
                System.out.println(element.getName());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将Contact.xml文件中的联系人数据封装成List集合，其中每个元素是实体类Contact。打印输出 List 中的每个元素
     */
    @Test
    public void xmlToList() {
        SAXReader saxReader = new SAXReader();
        InputStream stream = this.getClass().getResourceAsStream("/com/codewolf/java/xml/Contact.xml");
        try {
            Document document = saxReader.read(stream);
            Element root = document.getRootElement();
            List<Element> elements = root.elements("contact");
            List<Contact> contactList = new ArrayList<>();
            elements.forEach(element -> {
                contactList.add(new Contact(element.element("name").getText(),
                        element.element("gender").getText(),
                        element.element("email").getText()));
            });
            System.out.println(contactList);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseXML();
    }
}
