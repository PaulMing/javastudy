public class ShowMsg {
  // 无界通配符
  public void showFlag(Generic<?> generic) {
    System.out.println(generic.getFlag());
  }

  // 上限限定符
  public void showFlagUp(Generic<? extends Number> generic) {
    System.out.println(generic.getFlag());
  }

  // 下限限定符
  public void showFlagDown(Generic<? super Integer> generic) {
    System.out.println(generic.getFlag());
  }
}