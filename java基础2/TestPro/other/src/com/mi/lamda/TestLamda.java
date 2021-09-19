package com.mi.lamda;

public class TestLamda {
    // 静态内部类
    static class Like1 implements ILike {
        @Override
        public void lamda() {
            System.out.println("lamda1");
        }
    }


    public static void main(String[] args) {

        // 局部内部类
        class Like2 implements ILike {
            @Override
            public void lamda() {
                System.out.println("lamda2");
            }
        };

        // 匿名内部类：无类的名称，必须借助接口或父类
        ILike like3 = new ILike() {
            @Override
            public void lamda() {
                System.out.println("lamda3");
            }
        };
        like3.lamda();

        /*
          lamda表达式：

        */
        ILike like4 = () -> {
            System.out.println("lamda4");
        };
        like4.lamda();






        ILike ilike = new Like();
        ilike.lamda();

        ILike ilike1 = new Like1();
        ilike1.lamda();

        ILike ilike2 = new Like2();
        ilike2.lamda();
    }
}

// 接口
interface ILike {
    void lamda();
}

// 实现类
class Like implements ILike {
    @Override
    public void lamda() {
        System.out.println("lamda");
    }
}
