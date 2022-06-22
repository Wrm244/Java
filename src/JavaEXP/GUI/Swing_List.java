package GUI;
import java.awt.*;
import javax.swing.*;
public class Swing_List extends JFrame{

    JPanel jp1,jp2,jp3,jp4;
    //定义基本组件
    JLabel jl1 = null;
    JLabel jl2 = null;
    JLabel jl3 = null;
    JLabel jl4 = null;
    JLabel jl5 = null;
    JTextField jtf = null;
    JButton jb = null;
    JRadioButton jr = null;

    //定义面板组件
    // JPanel jp = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Swing_List js = new Swing_List();
    }

    public Swing_List() {
        //创建面板组件
        jp1=new JPanel();    //创建三个面板
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();
        //创建其它组件
        jl1 = new JLabel("文本框：");
        jl2 = new JLabel("按钮：");
        jb = new JButton("确认");

        jl3 = new JLabel("选择框：");
        jtf = new JTextField(10);

        jl4 = new JLabel("单选按钮:");
        //jr = new JRadioButton("男");
        //复选按钮组件JCheckBox
        JCheckBox[] hobby = {new JCheckBox("喜欢音乐"), new JCheckBox("喜欢旅游"), new JCheckBox("喜欢足球")};
        String[] petStrings = { "音乐天地", "Cat", "Dog", "Rabbit", "Pig" };

        this.setLayout(new GridLayout(4,1));
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        //添加组件到面板
        jp1.add(jl1);
        jp1.add(jtf);
        jp1.add(jl2);
        jp1.add(jb);

        jp2.add(jl3);
        jp2.add(hobby[0]);
        jp2.add(hobby[1]);
        jp2.add(hobby[2]);

        jp3.add(jl4);
        jp3.add(new JRadioButton("男"));
        jp3.add(new JRadioButton("女"));
        jp3.add(new JLabel("下拉选择："));
        jp3.add(new JComboBox(petStrings));

        jp4.add(new JLabel("文本区"));
        jp4.add(new JTextArea(3,6));

        //添加面板到窗体（框架）
        this.setTitle("swing窗体");
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}