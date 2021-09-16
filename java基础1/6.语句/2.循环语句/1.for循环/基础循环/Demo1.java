/**
 * 鸡兔同笼问题：总数50只,脚总数160只
 * 小结：实际很多问题我们通过常识、数学方法可以很快得到正确答案，计算机却只能通过'逐个尝试'的方法，很笨拙，计算机本来就是执行指令的工具而已，其的优势是处理'问题规模较大'的问题
 */
public class Demo1 {
  public static void main(String[] args) {
    // 设鸡有i只
    for(int i=1; i<50; i++) {
      if(2*i + 4*(50-i) == 160) {
        System.out.println("鸡个数：" + i);
        System.out.println("兔个数：" + (50-i));
      }
    }
  }
}