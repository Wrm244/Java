package JavaEXP.exp3;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.List;

public class ShowEmployeeWindow extends JFrame {
    JLabel jl = null;
    JLabel jlSearchID = null;
    JTextField jtfSearchID = null;
    JButton jbSearchID = null;
    JLabel jlSearchName = null;
    JTextField jtfSearchName = null;
    JButton jbSearchName = null;
    JButton jbModify = null;
    JButton jbStatics = null;
    JTextArea jtaArea = null;
    JScrollPane jsp = null;

    //初始化浏览界面
    public ShowEmployeeWindow() {
        //jtaArea.setVisibleRowCount(10);  //滚动条显示setVisibleRowCount(?)?为显示条数
        jlSearchID = new JLabel("请输入ID");
        jtfSearchID = new JTextField(20);
        jbSearchID = new JButton("按ID查找");

        jlSearchName = new JLabel("请输入姓名");
        jtfSearchName = new JTextField(20);
        jbSearchName = new JButton("按姓名查找");

        jbModify = new JButton("修改");
        jbStatics = new JButton("统计");

        jtaArea = new JTextArea(50, 20);

        List<Employee> userlist = Operatefile.readEm();
        jl = new JLabel("  浏览职工信息,总人数：" + String.valueOf(Employee.persons));

        String emstring = "";
        for (Employee em : userlist) {
            emstring = "  " + em.getID() + "\n" + "  " + em.getName() + "\n" + "  " + em.getBorn() + "\n" + "  " + String.valueOf(em.getSalary()) + "\n" + "  " + em.getEmail();
            //System.out.println(emstring+"\n");
            jtaArea.append("-----------------\n" + emstring + "\n");
        }
        //设置边框
        Border border = BorderFactory.createBevelBorder(1);
        jtaArea.setBorder(border);

        jsp = new JScrollPane(jtaArea);
        this.setLayout(null);
        jlSearchID.setBounds(10, 10, 80, 30);
        jtfSearchID.setBounds(90, 10, 100, 30);
        jbSearchID.setBounds(220, 10, 160, 30);
        jlSearchName.setBounds(10, 50, 80, 30);
        jtfSearchName.setBounds(90, 50, 100, 30);
        jbSearchName.setBounds(220, 50, 160, 30);

        jl.setBounds(2, 95, 590, 20);
        jsp.setBounds(1, 120, 595, 330);
        this.add(jlSearchID);
        this.add(jtfSearchID);
        this.add(jbSearchID);
        this.add(jlSearchName);
        this.add(jtfSearchName);
        this.add(jbSearchName);
        this.add(jl);
        this.add(jsp);

        jbSearchID.addActionListener(new Listeners());
        jbSearchName.addActionListener(new Listeners());
        /********* 注册按姓名查找 事件监听器  begin  *********
         ********* 注册按姓名查找 事件监听器  end  *********/

        this.setSize(605, 500);
        this.setTitle("浏览职工信息");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    }

    //更新显示结果
    public void updateEmployee() {
        List<Employee> userlist = Operatefile.readEm();
        jl.setText("  浏览职工信息, 总人数：" + String.valueOf(Employee.persons));
        String emstring = "";
        jtaArea.setText(null); //清空
        for (Employee em : userlist) {
            emstring = "  " + em.getID() + "\n" + "  " + em.getName() + "\n" + "  " + em.getBorn() + "\n" + "  " + String.valueOf(em.getSalary()) + "\n" + "  " + em.getEmail();
            //System.out.println(emstring+"\n");
            jtaArea.append("-----------------\n" + emstring + "\n");
        }
    }
}