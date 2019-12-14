package com.xiaoxiao.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author Xiaoyu
 * @date 2019/12/4 - 15:05
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements names = document.getElementsByTag("name");
        System.out.println(names.get(0).text());


    }
}
