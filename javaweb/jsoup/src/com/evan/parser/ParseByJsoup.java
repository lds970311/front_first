// Author : evan lee
// Time ： 2022-01-18  20:42
// FILENAME : ParseByJsoup.java
// STATEMENT: 

package com.evan.parser;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ParseByJsoup {
    @Test
    public void parse() {
        URL url = ParseByJsoup.class.getClassLoader().getResource("student.xml");
        String path = null;
        if (url != null) {
            path = url.getPath();
        }
        //解析文档
        try {
            if (path != null) {
                Document document = Jsoup.parse(new File(path), "utf-8");
                Elements elements = document.getElementsByTag("name");
                elements.forEach(element -> {
                    String text = element.text();
                    System.out.println(text);
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse2() {
        URL url = ParseByJsoup.class.getClassLoader().getResource("student.xml");
        String path = null;
        if (url != null) {
            path = url.getPath();
        }
        //解析文档
        try {
            if (path != null) {
                Document document = Jsoup.parse(new File(path), "utf-8");
                //3.根据document对象，创建JXDocument对象
                JXDocument jxDocument = new JXDocument(document);
                List<JXNode> jxNodeList = jxDocument.selN("//student/name");// 获取所有name节点
                jxNodeList.forEach(ele -> {
                    Element element = ele.getElement();
                    System.out.println(element.text());
                });
            }

        } catch (IOException | XpathSyntaxErrorException e) {
            e.printStackTrace();
        }
    }
}
