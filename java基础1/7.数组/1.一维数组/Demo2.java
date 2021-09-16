/**
 * 输出数组元素的平均值 
 * array{1,2,3,4,5,6,7,8}
 */
public class Demo2 {
  public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5,6,7,8};
    double sum = 0;
    int len = array.length;
		
		for(int i=0; i<len; i++){
      sum += array[i];
		}
    double avarage = sum/len;
    System.out.println(sum);
    System.out.println("平均值："+ avarage);
  }
}