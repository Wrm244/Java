package JavaEXP.exp3;

import java.io.Serializable;

//职工信息（职工工号、姓名、出生年月、基本工资、email）
public class Employee implements Serializable {
    private String ID;
    private String name;
    private String born;
    private double salary;
    private String email;
    //static String filename="D:/Employee.txt";
    static public int persons = 0;
    static public int lastindex = 0;
    private static final long serialVersionUID = 67800;

    public Employee(String strindex, String name, String born, double salary, String email) {
        //if (checkEmail(email)){
        persons++;
        this.ID = strindex;
        this.name = name;
        this.born = born;
        this.salary = salary;
        this.email = email;
        //}
        //else
        //    JOptionPane.showMessageDialog(null,"email输入错误！","信息消息提示框", JOptionPane.INFORMATION_MESSAGE);
        //System.out.println("email输入错误！");
    }

    public static boolean checkEmail(String email) {
        int index = email.indexOf("@");
        //System.out.println(email.length()+"index="+index);
        if (index <= 0 || index >= email.length() - 1) {
            return false;
        } else
            return true;
    }

    private void setID() {

    }

    public String getID() {
        return ID;
    }


    public String getName() {
        return name;
    }

    public String getBorn() {
        return born;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public void showEmployee() {
        System.out.println("ID: " + ID + "\n" + "Name: " + name + "\n" + "Born: " + born + "\n" + "Salary: " + salary + "\n" + "Email: " + email);
        System.out.println();
    }
}