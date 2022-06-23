package JavaEXP.exam.LiveExam;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Files {
    static String filename = "User.txt";

    static List<User> userlist = new ArrayList<User>();

    public static void writeEm(List<User> userlist) {
        try {
            ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(filename));
            oout.writeObject(userlist); //对象的序列化
            oout.close();
        } catch (Exception e) {
            System.out.println("写对象错误");
        }
    }
    public static void appendEm(User em) {
        userlist = readEm();
        userlist.add(em);
        try {
            ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(filename));
            oout.writeObject(userlist); //对象的序列化
            oout.close();
        } catch (Exception e) {
            System.out.println("写对象错误");
        }
    }
    public static List<User> readEm() {
        try {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(filename));
            userlist = (List<User>) oin.readObject(); //将输入流转换为对象(对象的反序列化)
        } catch (Exception e) {
            System.out.println("没有文件");
        }
        User.user = userlist.size();
        return userlist;
    }

    public static User searchUsername(String ID) {
        //System.out.println("searchObjID");
        userlist = readEm();
        System.out.println("现有人数：" + userlist.size());
        for (int index = 0; index < userlist.size(); index++) {
            if (userlist.get(index) != null) {
                System.out.println(userlist.get(index).getUserName());
                if (userlist.get(index).getUserName() != null && userlist.get(index).getUserName().equals(ID))
                    return userlist.get(index);
            }
        }
        System.out.println("没找到");
        return null;
    }

//    public File openFile(String fileNames) {
//        File file = new File(fileNames);
//
//        if (!file.exists()) {
//
//            try {
//
//                file.createNewFile(); //如果文件不存在则创建文件
//
//            } catch (IOException e) {
//
//                e.printStackTrace();
//
//            }
//
//        }
//        return file;
//    }
//
//    private static void writeInFile(File file, String content) {
//
//        Writer writer = null;
//
//        StringBuilder outputString = new StringBuilder();
//
//        try {
//            outputString.append(content + "\r\n");
//
//            writer = new FileWriter(file, true); // true表示追加
//
//            writer.write(outputString.toString());
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        } finally {
//
//            try {
//
//                writer.close();
//
//            } catch (IOException e2) {
//
//                e2.printStackTrace();
//
//            }
//
//        }
//
//    }
}
