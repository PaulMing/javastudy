import java.io.File;
public class Demo {
  public static void main(String[] args) throws Exception{
    /*
      File类创建：-> 目录 && 文件
        File file = new File(pathname)
          绝对路径：new File("d:/a.txt");//默认放到D盘
          相对路径：new File("a.txt");//默认放到user.dir目录下 ->  user.dir指代当前项目的目录 System.getProperty("user.dir");
          -> 仅定义文件存放位置，需要调用创建文件方法才会'真正创建'

          // 文件
          file.createNewFile();//创建文件
          file.delete();//删除文件
          file.getPath();//文件目录路径
          file.getName();//文件名
          file.length();//文件大小
          file.lastModified();//文件最后修改时间
          file.isFile();//是否为文件
          file.exists();//是否存在

          // 目录
          file.mkdir();//创建一个目录 -> 若中间某目录缺失则创建失败
          file.mkdirs();//创建多个目录 -> 若中间某目录缺失则会创建缺失目录
          file.isDirectory();//是否为目录
    */
    System.out.println(System.getProperty("user.dir"));
    File file = new File("a.txt");//仅定义文件存放位置，需要调用创建文件方法才会'真正创建'
    file.createNewFile();
    // file1.delete();
    System.out.println(file.getPath());
    System.out.println(file.getName());
    System.out.println(file.length());
    System.out.println(file.lastModified());
    System.out.println(file.isFile());
    System.out.println(file.isDirectory());
    System.out.println(file.exists());


    File file1 = new File("d:/test/java/file/func");//仅创建目录，d:/test/java/file/func/a.txt -> a.txt会被当作目录创建
    boolean flag = file1.mkdir();
    boolean flag1 = file1.mkdirs();
    System.out.println(flag);
    System.out.println(flag1); 
  }
}