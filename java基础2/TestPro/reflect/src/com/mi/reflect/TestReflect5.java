/*
   获取泛型信息：-> 了解即可
      JAVA中的泛型在编译完成后会进行类型擦除[确保数据安全 && 免去强制类型转换]，为了通过反射操作这些类型，JAVA新增了4种类型代表不能被归一到Class类中的类型但是又和原始类型齐名的类型
      ParameterizedType: 表示参数化类型，例如Collection<String>
      GenericArrayType: 表示元素类型为参数化类型或类型变量的数组类型
      TypeVariable: 各种类型变量的公共父接口
      WildcardType: 表示通配符类型表达式
*/
package com.mi.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class TestReflect5 {
    public void demo1(Map<String,User> map, List<User> list) {
        System.out.println("test1");
    }

    public Map<String,User> demo2() {
        System.out.println();
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = TestReflect5.class.getMethod("demo1",Map.class,List.class);
        Type[] genericParameterTypes = method.getGenericExceptionTypes();

        for(Type genericParameterType: genericParameterTypes) {
            if(genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType)genericParameterType).getActualTypeArguments();
                for(Type actualTypeArgument: actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        Method method1 = TestReflect5.class.getMethod("demo2",null);
        Type genericReturnType = method1.getGenericReturnType();
        if(genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType)genericReturnType).getActualTypeArguments();
            for(Type actualTypeArgument: actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }
}