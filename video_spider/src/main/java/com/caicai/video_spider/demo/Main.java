package com.caicai.video_spider.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.net.URL;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: Main
 * @Package: com.caicai.video_spider.demo
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/18 14:32
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class Main {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Main.class);
        applicationContext.refresh();

        Main bean = applicationContext.getBean(Main.class);
        //todo
        downLoad();
        applicationContext.close();
    }

    public static File downLoad() throws IOException {
        String link = "https://www.icourse163.org/learn/BZYXY-1461810171?tid=1462614454";
        Document parse = Jsoup.parse(new URL(link), 10000);
        System.out.println("parse = " + parse);
        return null;
    }

}
