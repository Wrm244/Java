package JavaEXP.exp3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Listeners implements ActionListener {
    static AddEmployeeWindow addEmUI = null;
    static ShowEmployeeWindow showEmUI = null;
    static OperateEmployWindow modfyEmUI = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("添加")) {
            addEmUI = new AddEmployeeWindow();
            addEmUI.init();
            System.out.println("添加职工");
        }
        if (e.getActionCommand().equals("确认添加")) {
            System.out.println("确认添加职工");
            addEmUI.addEmployee();
        }
        if (e.getActionCommand().equals("浏览")) {
            System.out.println("浏览职工信息");
            showEmUI = new ShowEmployeeWindow();
        }
        if (e.getActionCommand().equals("按ID查找")) {
            String ID = showEmUI.jtfSearchID.getText().trim();
            Employee em = Operatefile.searchObjID(ID);
            System.out.println("按ID查找职工信息,ID:" + ID);
            modfyEmUI = new OperateEmployWindow(em, ID, null);
        }
        /************ 按姓名查找 begin ************
         ************* 按姓名查找 end   ***********/
        if (e.getActionCommand().equals("按姓名查找")) {
            String name = showEmUI.jtfSearchName.getText().trim();
            Employee em = Operatefile.searchObjName(name);
            System.out.println("按姓名查找职工信息,name:" + name);
            modfyEmUI = new OperateEmployWindow(em, null, name);
        }


        if (e.getActionCommand().equals("确认修改")) {
            /*****  修改文件内容  begin 	******
             *****  修改文件内容  begin 	******/
            List<Employee> userlist = Operatefile.readEm();
            String ID = modfyEmUI.jtfID.getText().trim();
            System.out.println(ID);
            int index = Operatefile.searchIndexID(ID);
            if (index != -1) {

                // userlist.add(index,);
                //Employee.persons--;
                modfyEmUI.ModifyEmployee(ID,index);
                showEmUI.updateEmployee(); //更新显示结果
                JOptionPane.showMessageDialog(null, "修改成功", "信息消息提示框", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("删除员工序号：" + (index + 1)); //测试
            }
        }
        if (e.getActionCommand().equals("确认删除")) {
            List<Employee> userlist = Operatefile.readEm();
            String ID = modfyEmUI.jtfID.getText().trim(); //showEmUI.jtfSearchID 这个是错误的地方
            int index = Operatefile.searchIndexID(ID);
            if (index != -1) {
                userlist.remove(index);
                Employee.persons--;
                Operatefile.writeEm(userlist);
                showEmUI.updateEmployee(); //更新显示结果
                JOptionPane.showMessageDialog(null, "删除成功", "信息消息提示框", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("删除员工序号：" + (index + 1)); //测试
            }
        }
    }
}