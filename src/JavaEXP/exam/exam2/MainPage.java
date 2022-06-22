package JavaEXP.exam.exam2;

import JavaEXP.exam.exam2.Utils.Decide;
import JavaEXP.exam.exam2.Utils.MessageManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setAutoRequestFocus(false);
		setTitle("学号：2000300219 姓名： 刘璇");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("华文行楷", Font.PLAIN, 23));
		btnNewButton.setBounds(556, 249, 127, 59);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("请输入一元二次方程 Ax^2+Bx+C = 0的相关系数");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel.setBounds(29, 21, 443, 70);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("计算");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				calculate();
			}
		});
		btnNewButton_1.setFont(new Font("华文行楷", Font.PLAIN, 19));
		btnNewButton_1.setBounds(556, 85, 127, 55);
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(29, 171, 133, 59);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("系数A");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(29, 135, 58, 15);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(215, 171, 133, 59);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(390, 171, 133, 59);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("系数B");
		lblNewLabel_1_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(215, 135, 58, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("系数C");
		lblNewLabel_1_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(390, 135, 58, 15);
		panel.add(lblNewLabel_1_2);
	}

	public void calculate(){
		try {
			Equation equation = new Equation(Integer.parseInt(textField.getText().trim()),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_2.getText()));
			Decide.getEquationSolution(equation);
		}catch (Exception e){
			System.out.println(e);
			MessageManager.Warning(e.getMessage()+"输入的不是数字","输入错误，报错如下");
		}
	}
}
