package com.mi.lamda;

public class TestLamda1 {
    public static void main(String[] args) {
//        ILove love = new Love();
//        love.love(3);


        ILove love = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("love： " + a);
            }
        };
        love.love(3);

        ILove love1 = (int a) -> {
            System.out.println("love： " + a);
        };

        ILove love1 = a -> {
            System.out.println("love： " + a);
        };


        ILove love2 = a -> System.out.println("love： " + a);
        // 参数，语句仅有一句时候，外面的大括号可省略

        // 多个参数可都去掉参数类型





        love1.love(5);




    }
}


interface ILove {
    void love(int a);
}


class Love implements ILove {
    @Override
    public void love(int a) {
        System.out.println("love： " + a);
    }
}