package com.caicai.jdkdemo.collection.list;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListSplitDemo {


    @Test
    public void ListRetain() {
        //入参
        List<String> list1 = new ArrayList<>();
        list1.add("23");
        list1.add("34");
        list1.add("25");
        list1.add("27");
        //白名单
        List<String> list2 = new ArrayList<>();
        list2.add("25");
        list2.add("26");
        list2.add("27");
        list2.add("28");
        //白名单之内
        List<String> whiteList = list1.stream().filter(l -> list2.contains(l)).collect(Collectors.toList());
        List<String> blackList = list1.stream().filter(l -> !list2.contains(l)).collect(Collectors.toList());
        whiteList.stream().forEach(System.out::println);
        System.out.println("---");
        blackList.stream().forEach(System.out::println);
        System.out.println("---");

        //两次循环中操作； 调整下：
        List<String> whiteList1 = new ArrayList<>();
        List<String> blackList1 = new ArrayList<>();
        list1.forEach(l->{
            if (list2.contains(l)) {
                whiteList1.add(l);
            }else{
                blackList1.add(l);
            }
        });
        whiteList1.stream().forEach(System.out::println);
        System.out.println("---");
        blackList1.stream().forEach(System.out::println);

    }
}
