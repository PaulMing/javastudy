public class Demo {
  public static void main(String[] args) {
    // 变量定义
    byte a = 1;
    short b = 2;
    int c = 3;
    long d = 2147483648L;//long d = 2147483648 -> 报错，因为常量池中整型默认为int类型4个字节，值范围-2147483648~2147483647，2147483648超出了该范围，所以会报错，可以显示添加后缀L表示其是long类型8个字节
    float e = 3.4F;//float e = 3.4 -> 报错，丢失了精度，因为常量池中浮点型默认为double类型8个字节，赋值给float型变量，其会丢失精度，但是byte a = 1; int类型转换为byte类型1个字节，编译过程并不报错，这是因为浮点型中float是首位表示符号位，接下来9位表示整数位，剩下表示小数位，double是首位表示符号位，接下来19位表示整数位，剩下表示小数位，贸然转换会导致精度丢失，但是byte a = 1; 赋值符号会将int类型转换为byte类型，其可识别，然后将0丢掉，实际并不会丢失精度
    double f = 5.6;
    char g = 'a';
    boolean h = true;
    String i = 'a';//String类虽然是引用数据类型，但其的值为变量
  }
}