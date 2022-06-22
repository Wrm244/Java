package JavaEXP.exp3;
/*
 * 查询结果
 * 修改
 * 删除
 */

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.List;

public class OperateEmployWindow extends JFrame {
    JLabel jl = null;
    JLabel jlID = null;
    JLabel jlname = null;
    JLabel jlborn = null;
    JLabel jlsalary = null;
    JLabel jlemail = null;
    JTextField jtfID = null;
    JTextField jtfname = null;
    JTextField jtfborn = null;
    JTextField jtfsalary = null;
    JTextField jtfemail = null;
    JPanel jp1 = null;
    JPanel jp2 = null;
    JPanel jp3 = null;
    JPanel jp4 = null;
    JPanel jp5 = null;
    JButton modify = null;
    JButton remove = null;

    public OperateEmployWindow(Employee em, String ID, String name) {
        if (em == null && ID!=null ) {
            jl = new JLabel("  查询结果：");
            String message = "  不存在 ID 为  " + ID + "  的职工.";
            JOptionPane.showMessageDialog(null, message, "信息消息提示框", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (em == null && name!=null){
            jl = new JLabel("  查询结果：");
            String message = "  不存在 name 为  " + name + "  的职工.";
            JOptionPane.showMessageDialog(null, message, "信息消息提示框", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            jl = new JLabel("  如果修改职工信息，请输入员工新信息：");
            jlID = new JLabel("ID:");
            jtfID = new JTextField(20);
            jtfID.setText(em.getID());
            jtfID.setEnabled(false);

            jlname = new JLabel("姓名：");
            jtfname = new JTextField(20);
            jtfname.setText(em.getName());

            jlborn = new JLabel("出生年月：");
            jtfborn = new JTextField(20);
            jtfborn.setText(em.getBorn());

            jlsalary = new JLabel("工资：");
            jtfsalary = new JTextField(20);
            jtfsalary.setText(String.valueOf(em.getSalary()));

            jlemail = new JLabel("Email：");
            jtfemail = new JTextField(20);
            jtfemail.setText(em.getEmail());


            modify = new JButton("确认修改");

            remove = new JButton("确认删除");
            jp1 = new JPanel();
            jp2 = new JPanel();
            jp3 = new JPanel();
            jp4 = new JPanel();
            jp5 = new JPanel();

            jp1.add(jlID);
            jp1.add(jtfID);
            jp2.add(jlname);
            jp2.add(jtfname);
            jp3.add(jlborn);
            jp3.add(jtfborn);
            jp4.add(jlsalary);
            jp4.add(jtfsalary);
            jp5.add(jlemail);
            jp5.add(jtfemail);

            this.setLayout(new GridLayout(7, 1, 0, 3));
            this.add(jl);
            this.add(jp1);
            this.add(jp2);
            this.add(jp3);
            this.add(jp4);
            this.add(jp5);
            JPanel jp = new JPanel();
            jp.add(modify);
            jp.add(remove);
            this.add(jp);



            this.setSize(400, 300);
            this.setTitle("修改、删除职工信息");
            this.setLocationRelativeTo(null); //设置窗体剧中显示

            this.setVisible(true);
            this.setResizable(false);
            this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            modify.addActionListener(new Listeners());
            remove.addActionListener(new Listeners());
        }
    }

    public void ModifyEmployee(String ID, int index) {
        String name = null;
        String born = null;
        double salary = 0;
        String email = null;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        if (jtfborn.getText().equals("")) {
            System.out.println("请输入姓名");
        } else {
            name = jtfname.getText();
            flag1 = true;
        }
        if (jtfborn.getText().equals("")) {
            System.out.println("请输入生日");
        } else {
            born = jtfborn.getText();
            flag2 = true;
        }
        if (jtfsalary.getText().equals("")) {
            System.out.println("请输入工资");
        } else {
            salary = Double.parseDouble(jtfsalary.getText());
            flag3 = true;
        }
        if (jtfemail.getText() == null) {
            System.out.println("请输入Email");
        } else {
            email = jtfemail.getText();
            flag4 = true;
        }
        if (flag1 && flag2 && flag3 && flag4) {
            List<Employee> userlist = Operatefile.readEm();
            int lastIndex;
            String strindex;

            //添加职工
            if (Employee.checkEmail(email)) {
                Employee em = new Employee(ID, name, born, salary, email);
                Operatefile.modifyEm(em, index);
            } else JOptionPane.showMessageDialog(null, "email输入错误！", "信息消息提示框", JOptionPane.INFORMATION_MESSAGE);


            //测试
            Operatefile.showUserList();
            // System.out.println("人数：" + Employee.persons + "\n***************************************\n");
        }

    }
}