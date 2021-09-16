/**
 * 数组元素头尾互换位置
 * array{1,2,3,4,5,6,7,8}
 */
public class Demo4 {
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5,6,7,8};
    int len = arr.length;

    for(int i=0; i<len/2; i++) {
      int j = 0;
      j = arr[i];
      arr[i] = arr[len-(i+1)];
      arr[len-(i+1)] = j;
    }
    
    for(int item:arr) {
      System.out.println(item);
    }
  }
}