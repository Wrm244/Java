package JavaEXP.exam.exam3;

import javax.swing.JFrame;

public class Demo {
	public static void main(String[] args) {
		JFrame frame = new MyFrame("学号姓名");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		frame.setVisible(true);
	}
}
