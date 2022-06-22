package Java_SE.basis.ProgramExamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Number;

/**
 * 读文件示例
 *
 * @author RiverMountion
 * @date 2021/08/12
 */
public class ReadFileExample {
    public static void main(String[] args) {

        //读取文本文件的内容
        Scanner scanner = null;
        try {   //try (Scanner scanner = new Scanner(new File("test.txt")))
            scanner = new Scanner(new File("./IO模型.md"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

}

