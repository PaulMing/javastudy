/**
 * 两个数组内元素对应位置互换
 * array1{1,2,3,4}
 * array2{5,6,7,8}
 */
public class Demo3 {
  public static void main(String[] args) {
    int[] arr1 = new int[]{1,2,3,4};
    int[] arr2 = new int[]{5,6,7,8};
    // 方法1：直接进行数组内元素两两互换：两者长度相等时互换成功，若长度不相等则需要处理边界情况，因为很容易产生数组越界异常
    // 方法2：直接进行数组引用互换即可 -> 巧妙利用引用数据类型内存存储方式：栈区存放引用，堆区存放数据
    int[] arr = new int[]{};
    arr = arr1;
    arr1 = arr2;
    arr2 = arr;
    for(int item:arr1) {
      System.out.println(item);
    } 

    for(int item:arr2) {
      System.out.println(item);
    } 
  }
}