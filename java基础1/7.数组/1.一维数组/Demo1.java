/**
 * 输出1-100间的偶数
 */
public class Demo1 {
  public static void main(String[] args) {
		int[] array = new int[50];
		
		for(int i=0; i<array.length; i++){
			array[i] = 2*i+2;
		}

		for(int i:array){
			System.out.println(i);
		}
  }
}