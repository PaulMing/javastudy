/**
 * 递归遍历目录结构 -> 树状展示
 */
import java.io.File;
public class Demo {
  public static void main(String[] args){
    File file = new File("d:/movies");
    printFile(f,0); 
  }

  /**
   * 打印文件信息
   * @param file 文件名称
   * @param level 层次数
   */
  static void printFile(File file, int level) {
    // 输出层次数
    for(int i=0; i<level; i++) {
      System.out.print("-");
    }

    // 输出文件名
    System.out.println(file.getName());

    // 若file是目录，则获取子文件列表并对每个子文件进行相同操作
    if(file.isDirectory()) {
      File[] files = file.listFiles();
      for(File temp: files) {
        printFile(temp,level+1);
      }
    }
  }
}