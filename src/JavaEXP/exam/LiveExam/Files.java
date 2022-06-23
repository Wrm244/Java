package JavaEXP.exam.LiveExam;
import java.io.*;

public class Files {

    public void write(String[] message)throws IOException
    {
        File file=new File("Message.txt");
        String messagesum="";
        for (int i=0; i<2; i++)  //将信息格式化存储
            messagesum+=message[i]+"~";
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,true); //建立输出对象，true表示追加
        StringBuffer sb=new StringBuffer();      //创建字符串流
        sb.append(messagesum+"\n");				//向字符串流中添加信息
        out.write(sb.toString().getBytes("gb2312"));         //将字符串流中的信息写入文本
        out.close();			//关闭
    }
    public int read(String countname,String pwd) throws IOException{

        File file=new File("Message.txt");   //创建文件类
        if(!file.exists()||file.isDirectory()) //判断文件是否存在
            //throw new FileNotFoundException();
            file.createNewFile();
        BufferedReader br=new BufferedReader(new FileReader(file)); //创建读入缓冲流，按行读入
        String temp;
        // StringBuffer sb=new StringBuffer();
        int number = 0;
        temp=br.readLine();   //先读取一行
        while(temp!=null){
            String sbstring = temp.toString();   //转化为string
            int n = sbstring.length();            //测字符串长度
            String []message = new String[5];     //按~拆分 成5个字符串数组，按账号和密码进行信息验证
            int k=0;

            for (int i=0; i<2; i++)
                message[i]="";
            //我们在写入用户时用~分割， 所以我们利用~在分割开来
            for (int i=0; i<n; i++)
            {
                if(sbstring.charAt(i)=='~')
                {
                    //System.out.println("@"+message[k]);
                    k++;
                }
                else
                {
                    message[k] += sbstring.charAt(i);
                }
            }

            if (countname.equals(message[0]))//比较账户密码是否相等
            {
                if(pwd.equals(message[1])) {
                    return 1; //登录成功
                }
                else{
                    return 2;//密码错误
                }
            }
            temp=br.readLine();
        }
        return 3;
    }
}
