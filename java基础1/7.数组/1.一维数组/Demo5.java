/**
 * 数组合并
 * array1{1,2,3,4}
 * array2{5,6,7,8}
 */
public class Demo5 {
  public static void main(String[] args) {
    int[] arr1 = new int[]{1,2,3,4};
    int[] arr2 = new int[]{5,6,7,8};
    int len1 = arr1.length;
    int len2 = arr2.length;
    int[] arr = new int[len1 + len2];

    for(int i=0; i<len1; i++) {
      arr[i] = arr1[i];
    }

    for(int i=0; i<len2; i++) {
      arr[len1 + i] = arr2[i];
    }

    for(int item:arr) {
      System.out.println(item);
    } 
  }
}