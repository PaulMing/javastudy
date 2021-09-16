/**
 * 需求：盛满120立方米的水池，进水管每小时进水18立方米，排水管每小时出水30立方米，两个水管同时开，经过多少小时，水池的水排放干净
 */
public class Demo {
  public static void main(String[] args) {
    int water = 120;
    int hour = 0;
    while(water>0) {
      water+=18;
      water-=30;
      hour++;
    }
    System.out.println("需要多少个小时："+hour);
  }
}