package JavaEXP.exam.LiveExam;

import JavaEXP.exp3.Employee;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class User {
    private String UserName;
    private String PassWord;
    static public int user = 0;
    public User(String UserName, String PassWord){
        user++;
        this.UserName=UserName;
        this.PassWord=PassWord;
    }

    public static boolean checkPassword(String str) {
        int xiaoxie=0,daxie=0,num=0;
        char[] c=str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(c[i]>='a'&&c[i]<='z'){
                xiaoxie++;
            }else if(c[i]>='A'&&c[i]<='Z'){
                daxie++;
            }else if(c[i]>='0'&&c[i]<='9'){
                num++;
            }
        }
        if (xiaoxie>0 && daxie>0 && num>0) {
            return true;
        } else
            return false;
    }
    public String getPassWord(){
        return PassWord;
    }
    public String getUserName() {
        return UserName;
    }
}
