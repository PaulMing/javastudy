package com.mi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect5 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.mi.reflect.User");

        // 构造对象
        User user = (User)c1.newInstance();//构造对象，默认调用无参构造器
        System.out.println(user);

        Constructor constructor = c1.getConstructor(String.class,int.class,int.class);
        User user1 = (User)constructor.newInstance("a",1,1);
        System.out.println(user1);


        Method setName = c1.getDeclaredMethod("setName",String.class);
        setName.invoke(user,"a");// 参数：对象，参数值 -> invoke:激活
        System.out.println(user.getName());


        Field name = c1.getDeclaredField("name");

        name.setAccessible(true);//状态监测关掉 -> true为关掉，关掉才可操作私有属性
        name.set(user,"b");




    }

}
