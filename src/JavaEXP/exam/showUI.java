package JavaEXP.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author 河山
 * @version 1.0.0
 * @date 2022/06/23
 */
public class showUI extends JFrame  {
    JPanel jp1,jp2,jp3,jp4,jp5,jp6;

     JTextField jtf1;
     JTextField jtf2;
     JTextField jtf3;

     JTextField jtf4,jtf5;
    JButton jb1,jb2;
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5;

    /**
     * 显示用户界面
     */
    public showUI(){
        this.setTitle("学号姓名");
        this.setSize(400,300);

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();
        jp5=new JPanel();
        jp6=new JPanel();

        jlb1=new JLabel("a");
        jlb2=new JLabel("b");
        jlb3=new JLabel("c");
        jlb4=new JLabel("周长");
        jlb5=new JLabel("面积");

        jb1=new JButton("计算");
        jb2=new JButton("清空");

        jtf1=new JTextField(10);
        jtf2=new JTextField(10);
        jtf3=new JTextField(10);
        jtf4=new JTextField(10);
        jtf5=new JTextField(10);
        jtf4.setEditable(false);
        jtf5.setEditable(false);
        this.setLayout(new GridLayout(6,2));

        jp1.add(jlb1);jp1.add(jtf1);
        jp2.add(jlb2);jp2.add(jtf2);
        jp3.add(jlb3);jp3.add(jtf3);
        jp4.add(jb1);jp4.add(jb2);

        jp5.add(jlb4);jp5.add(jtf4);
        jp6.add(jlb5);jp6.add(jtf5);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);this.add(jp5);this.add(jp6);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        jb1.addActionListener(e -> {
            try{
                double edg1 = Double.parseDouble(jtf1.getText());
                double edg2 = Double.parseDouble(jtf2.getText());
                double edg3 = Double.parseDouble(jtf3.getText());
                if(edg1+edg2 <= edg3 || edg2+edg3 <= edg1 || edg1+edg3 <= edg2) {
                    throw new MyException();
                }  else {
                    Triangles triangles =new Triangles(edg1,edg2,edg3);
                    jtf4.setText(String.valueOf(triangles.perimeterCalculation()));
                    jtf5.setText(String.format("%.2f",triangles.areaCalculation()));
                }
            }catch (NumberFormatException e1){
                showMessageDialog(null,"请输入信息噢");
            }catch (MyException e2){
                showMessageDialog(null,"你输入的不是三角形噢");
            }

        });
        jb2.addActionListener(e -> {
           jtf1.setText("");jtf2.setText("");jtf3.setText("");jtf4.setText("");jtf5.setText("");
        });


        jtf1.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if(!(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)){
                    showMessageDialog(null,"请不要输入其他字符");
                    e.consume();
                }
            }
        });
    }

}
