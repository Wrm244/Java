package JavaEXP.exp3;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    JLabel jlTitle = null;
    //JLabel jlTitle2=null;
    //JLabel jlTitle3=null;
    JButton jbAppend = null;
    JButton jbView = null;

    JPanel jp = null;
    JPanel jp1 = null;
    JPanel jp2 = null;
    JPanel jp3 = null;

    public MainWindow() {
        System.out.println("主窗口");
        jlTitle = new JLabel(new ImageIcon("Title.png"));

        jbAppend = new JButton("添加");
        jbView = new JButton("浏览");


        jp = new JPanel();

        jp.setLayout(null);
        jlTitle.setBounds(0, 0, 400, 100);
        jbAppend.setBounds(30, 180, 140, 40);
        jbView.setBounds(200, 180, 140, 40);

        jp.add(jlTitle);
        jp.add(jbAppend);
        jp.add(jbView);

        jp.setBackground(Color.WHITE);

        jbAppend.addActionListener(new Listeners());
        jbView.addActionListener(new Listeners());

        this.add(jp);
        this.setTitle("实验三 职工信息管理系统 ");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null); //设置窗体剧中显示

        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}