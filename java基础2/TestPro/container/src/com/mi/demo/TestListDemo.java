/**
 * 产生1-10之间的随机数[1,10]，将不重复的10个随机数放入容器
 */
package com.mi.demo;

import java.util.ArrayList;
import java.util.List;

public class TestListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        while(true) {
            // 产生1-10之间的随机数[1,10]
            int num = (int)(Math.random()*10 + 1);

            // 不存在则注入容器
            if(!list.contains(num)) {
                list.add(num);
            }

            // 跳出循环
            if(list.size() == 10) {
                break;
            }
        }

        for(int num: list) {
            System.out.println(num);
        }
    }
}