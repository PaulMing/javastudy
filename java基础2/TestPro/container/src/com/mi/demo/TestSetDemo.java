/**
 * 产生1-10之间的随机数[1,10]，将不重复的10个随机数放入容器
 */
package com.mi.demo;

import java.util.Set;
import java.util.HashSet;

public class TestSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        while(true) {
            int num = (int)(Math.random()*10 + 1);

            set.add(num);

            if(set.size() == 10) {
                break;
            }
        }

        for(int num: set) {
            System.out.println(num);
        };//遍历结果居然是有序的，但HashSet容器并不具备排序能力 -> 原因：其是根据哈希算法确定位置，整数比较特殊，哈希算法得到的位置正好是正序排列的
    }
}