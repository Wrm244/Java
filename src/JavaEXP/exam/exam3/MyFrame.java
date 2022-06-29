package JavaEXP.exam.exam3;

import javax.swing.*;


public class MyFrame extends JFrame{
	JTextField text1 = new JTextField();
	JTextField text2 = new JTextField();
	JTextField text3 = new JTextField();
	JTextField text4 = new JTextField();
	JTextField text5 = new JTextField();
	public MyFrame(String titel) {
		super(titel);
		JPanel root = new JPanel();
		this.add(root);
		root.setLayout(null);
		JLabel label1 = new JLabel("请输入方程 Ax^2+Bx+C = 0的相关系数");
		JLabel label2 = new JLabel("ֵA");
		JLabel label3 = new JLabel("B");
		JLabel label4 = new JLabel("ֵC");
		JLabel label5 = new JLabel("X1");
		JLabel label6 = new JLabel("X2");
		
		
		
		JButton button1 = new JButton("计算");
		JButton button2 = new JButton("清空");

		root.add(label1);
		root.add(label2);
		root.add(label3);
		root.add(label4);
		root.add(label5);
		root.add(label6);
		label1.setBounds(50,0,250,50);
		label2.setBounds(50,100,100,50);
		label3.setBounds(150,100,100,50);
		label4.setBounds(250,100,100,50);
		label5.setBounds(75,200,100,50);
		label6.setBounds(200,200,100,50);
		
		root.add(text1);
		root.add(text2);
		root.add(text3);
		root.add(text4);
		root.add(text5);
		text1.setBounds(50,150,50,50);
		text2.setBounds(150,150,50,50);
		text3.setBounds(250,150,50,50);
		text4.setBounds(125,205,50,30);
		text5.setBounds(250,205,50,30);
		
		root.add(button1);
		root.add(button2);
		button1.setBounds(75,50,75,35);
		button2.setBounds(175,50,75,35);
		this.setLocationRelativeTo(null);
		
		button1.addActionListener(e-> {

				String a = text1.getText();
				String b = text2.getText();
				String c = text3.getText();
				try {
					Integer.valueOf(a);
					double a1 = Double.parseDouble(a.trim());
					double b1 = Double.parseDouble(b.trim());
					double c1 = Double.parseDouble(c.trim());
					if (TVE.panduan(a1, b1, c1))
					{
						JOptionPane.showMessageDialog(this,"没有解");
						System.out.println("exit!");
					}
					else
					{
						String x1 = TVE.jisuan1(a1, b1, c1);
						String x2 = TVE.jisuan2(a1, b1, c1);
						text4.setText(x1+"");
						text5.setText(x2+"");
					}
				}catch (Exception e1) {

					JOptionPane.showMessageDialog(this, "请输入数字噢");
					System.exit(0);
				}

		});
		button2.addActionListener(e->{

				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");

		});
	}
	
}
