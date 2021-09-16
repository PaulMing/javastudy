/**
 * 数组的最大值、最小值 -> 极值问题
 * array{10,20,50,30,40,70,60,80}
 */
public class Demo6 {
  public static void main(String[] args) {
    int[] arr = new int[]{10,20,50,30,40,70,60,80};
    int max = arr[0],
        min = arr[0];

    for(int i=1; i<arr.length; i++) {
      if(arr[i]>max) {
        max = arr[i];
      }
      if(arr[i]<min) {
        min = arr[i];
      }
    }
    System.out.println("最大值：" + max);
    System.out.println("最小值：" + min);
  }
}