public class Demo {
  public static void main(String[] args) {
    // 空指针异常 NullPointerException
    // int[][] arr = new int[3][];
    // arr[0][0] = 20;//定义时第二个length可为空，但不能为空后还去操作

    int[][] arr = new int[3][];
    arr[0] = new int[3];
    arr[1] = new int[]{1,2};
    arr[2] = new int[4];
    
    for(int[] item: arr) {
      for(int value: item) {
        System.out.println("取值："+value);
      }
    }
  }
}