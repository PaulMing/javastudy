## 枚举 -> JDK1.5引入
> 背景：开发中需要定义系列常量，枚举可以更好的管理这些'同类型常量'
> 本质：枚举依旧是类，隐式继承java.lang.Enum，每个被枚举的成员就是该枚举类型的实例 -> 它们默认使用public static final修饰，因此使用方法就是枚举名.枚举成员 => 开发中尽量不要使用枚举的高级特性，高级特性都可使用普通类实现，引入枚举会增加程序复杂性

### 枚举定义
```java
/*
  枚举：
    枚举本质是类，因此需要定义在外部
    枚举定义：
        enum 枚举名{
          枚举体（常量列表）
        }
*/
// 季节
enum Season {
  SPRING,
  SUMMER,
  AUTUMN,
  WINTER
}

// 星期
enum Week {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
  SUNDAY
}
```