package JavaEXP.exam.LiveExam;

public class User {
    private String UserName;
    private String PassWord;
    static public int user = 0;
    public User(String UserName, String PassWord){
        user++;
        this.UserName=UserName;
        this.PassWord=PassWord;
    }

    public  boolean checkPassword() {
        int xiaoxie=0,daxie=0,num=0;
        char[] c=this.PassWord.toCharArray();
        for(int i=0;i<this.PassWord.length();i++){
            if(c[i]>='a'&&c[i]<='z'){
                xiaoxie++;
            }else if(c[i]>='A'&&c[i]<='Z'){
                daxie++;
            }else if(c[i]>='0'&&c[i]<='9'){
                num++;
            }
        }
        return xiaoxie > 0 && daxie > 0 && num > 0;
    }
    public String getPassWord(){
        return PassWord;
    }
    public String getUserName() {
        return UserName;
    }
}
