public class Demo {
  public static void main(String[] args) {
    Generic<String> generic = new Generic<>();
    generic.setFlag("HelloWorld");
    System.out.println(generic.getFlag());

    Generic<Integer> generic1 = new Generic<>();
    generic1.setFlag(10);
    System.out.println(generic1.getFlag());
  }
}