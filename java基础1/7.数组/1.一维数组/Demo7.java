/**
 * 冒泡排序：每次都冒出一个值，遍历轮次即可
 * array{10,20,50,30,40,70,60,80}
 */

// 升序
// public class Demo7 {
//   public static void main(String[] args) {
//     int[] arr = new int[]{10,20,50,30,40,70,60,80};

//     for(int j=0; j<arr.length; j++) {
//       for(int i=0; i<arr.length-1; i++) {
//         int temp;
//         if(arr[i] > arr[i+1]) {
//           temp = arr[i];
//           arr[i] = arr[i+1];
//           arr[i+1] = temp;
//         }
//       }
//     }

//     for(int item: arr) {
//       System.out.println(item);
//     }
//   }
// }

// 降序
// public class Demo7 {
//   public static void main(String[] args) {
//     int[] arr = new int[]{10,20,50,30,40,70,60,80};

//     for(int j=0; j<arr.length; j++) {
//       for(int i=0; i<arr.length-1; i++) {
//         int temp;
//         if(arr[i] < arr[i+1]) {
//           temp = arr[i];
//           arr[i] = arr[i+1];
//           arr[i+1] = temp;
//         }
//       }
//     }

//     for(int item: arr) {
//       System.out.println(item);
//     }
//   }
// }

/*
  优化版：
    1.外循环轮次：不用遍历最后一圈，因为最后一个元素也不涉及比较 -> j<arr.length-1
    2.内循环轮次：外层没循环一次，内部循环都可以少循环一次，因为已经比较过了 -> i<arr.length-1-j
*/
public class Demo7 {
  public static void main(String[] args) {
    int[] arr = new int[]{10,20,50,30,40,70,60,80};

    for(int j=0; j<arr.length-1; j++) {
      for(int i=0; i<arr.length-1-j; i++) {
        int temp;
        if(arr[i] > arr[i+1]) {
          temp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] = temp;
        }
      }
    }

    for(int item: arr) {
      System.out.println(item);
    }
  }
}