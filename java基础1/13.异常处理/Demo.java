/**
 * 典型代码 - 捕获异常
 * IDEA：使用ctrl+alt+t自动生成try..catch...
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Demo {
  public static void main(String[] args) {
    FileReader reader = null;
    try {
      reader = new FileReader("d:/a.txt");
      char c = (char) reader.read();
      char c2 = (char) reader.read();
      System.out.println("" + c + c2);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}