package JavaEXP.exam.LiveExam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static JavaEXP.exam.LiveExam.showUI.jb2;
import static javax.swing.JOptionPane.showMessageDialog;

public class Listeners  implements ActionListener,KeyListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jb2) {
            try {

                String UserName = showUI.getJTextField().getText(); //getJTextField()是静态方法
                String PassWord = String.valueOf(showUI.getJPasswordField().getPassword());
                Files file = new Files();
                System.out.println(file.read(UserName, PassWord));
                if (file.read(UserName, PassWord) == 1) {
                    JOptionPane.showMessageDialog(null, "登录成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
                }

               if (file.read(UserName, PassWord) == 2) {
                    JOptionPane.showMessageDialog(null, "密码错误，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);
                    showUI.getJTextField().setText("");  //清空用户名密码
                    showUI.getJPasswordField().setText("");

                }
               if (file.read(UserName, PassWord) == 3) {
                    JOptionPane.showMessageDialog(null, "不存在该用户！", "提示消息", JOptionPane.WARNING_MESSAGE);
                    showUI.getJTextField().setText("");
                    showUI.getJPasswordField().setText("");
                }

            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "读取数据库失败！", "提示消息", JOptionPane.WARNING_MESSAGE);
            }
        }
        //注册事件
        if (e.getActionCommand().equals("注册")) {
            try {
                String[] message = new String[2];
                message[0] = showUI.getJTextField().getText();
                message[1] = String.valueOf(showUI.getJPasswordField().getPassword());
                Files file = new Files();
                if(file.read(message[0],message[1])!=3){
                    throw new MyException("用户已存在，不用再次注册");
                }
                if (new User(message[0], message[1]).checkPassword()) {
                    file.write(message);   //调用UserMseeage的write方法进行写操作， 将信息格式化存入
                    JOptionPane.showMessageDialog(null, "注册成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "密码请包含大小写字母与数字！", "提示消息", JOptionPane.WARNING_MESSAGE);
                }
            }catch(IOException e1){
                JOptionPane.showMessageDialog(null, "读取数据库失败！", "提示消息", JOptionPane.WARNING_MESSAGE);
            }catch (MyException e2){
                JOptionPane.showMessageDialog(null, e2.getMessage(), "提示消息", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) { //用户名key事件
        int keyChar = e.getKeyChar();
        if(!(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) && !(keyChar == KeyEvent.VK_BACK_SPACE)){
            showMessageDialog(null,"请输入学号，请不要输入其他字符");
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
