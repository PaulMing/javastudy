public class Demo {
  public static void main(String[] args) {
    Generic<Integer> generic = new Generic<>();
    generic.setFlag(20);
    ShowMsg showMsg = new ShowMsg();
    showMsg.showFlag(generic);

    Generic<Number> generic1 = new Generic<>();
    generic1.setFlag(20.002);
    ShowMsg showMsg1 = new ShowMsg();
    showMsg1.showFlag(generic1);

    Generic<String> generic2 = new Generic<>();
    generic2.setFlag("Hello");
    ShowMsg showMsg2 = new ShowMsg();
    showMsg2.showFlag(generic2);
  }
}