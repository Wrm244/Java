package JavaEXP.exp4.exp4_2;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientFrame extends JFrame {
    private JTextField tfMessage; // ��Ϣ�����ı���
    private JTextArea textArea; // ��Ϣ�����ı���
    private ChatRoomClient client; // �ͻ������Ӷ���

    // ���췽��
    public ClientFrame(String ip, String userName) {
        super("���߳�������");
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setLayout( null );
        setBounds( 100,50,800,680 );
        Container c = getContentPane();
        // �û�����
        this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent atg0) {
                int op = JOptionPane.showConfirmDialog( ClientFrame.this,
                        "ȷ��Ҫ�˳���������", "ȷ��", JOptionPane.YES_NO_OPTION); // ������ʾ��
                if (op == JOptionPane.YES_OPTION) {
                    client.sendMessage( "%EXIT%:"+userName ); // ������Ϣ
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    client.close();
                    System.exit( 0 );
                }
            }
        } );
        // ���Ͱ�ť
        JButton btnSend = new JButton( "����" );
        btnSend.setBounds( 680,550,100,30 );
        btnSend.setVisible( true );
        btnSend.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                SimpleDateFormat df = new SimpleDateFormat( "yyyy��MM��dd�� HH:mm:ss" ); // �趨���ڸ�ʽ
                client.sendMessage( userName+" "+df.format( date )+": \n"+tfMessage.getText() ); // �������������Ϣ
                tfMessage.setText(""); // �����Ϊ��
            }
        } );
        // ʵ�����ͻ��˶���
        try {
            client = new ChatRoomClient( ip,4569 ); // �����ͻ��˶���
        } catch(UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadMessageThread messageThread = new ReadMessageThread(); // ������ȡ�ͻ�����Ϣ���߳������
        messageThread.start();
        // �ؼ���ʼ��
        JLabel text = new JLabel( "��Ϣ�Ի���:" );
        text.setBounds( 10,0,200,30 );
        text.setVisible( true );
        // ��Ϣ�Ի���
        textArea = new JTextArea(  );
        textArea.setBounds( 10,30,750,420 );
        textArea.setVisible( true );
        textArea.setBackground( Color.LIGHT_GRAY);
        textArea.setFont(new Font("�꿬��", Font.BOLD, 16)); //���õ�ǰ���塣
        // ��ʾ�û���
        JLabel lblUserName = new JLabel( userName );
        lblUserName.setBounds( 10,550,50,30 );
        lblUserName.setVisible( true );
        tfMessage = new JTextField(  );
        tfMessage.setBounds( 50,550,600,30 );
        tfMessage.setVisible( true );
        // �·����
        c.add(text);
        c.add(textArea);
        c.add(lblUserName);
        c.add(tfMessage);
        c.add(btnSend);
        c.setBackground( Color.WHITE );
        setVisible( true );
    }
    private class ReadMessageThread extends Thread{
        private ReadMessageThread() {
        }

        public void run() {
            while (true) {
                String str = client.receiveMessage(); // �ͻ����յ��������������ı�����
                textArea.append( str+"\n" ); // ���ı����������
            }
        }
    }

}
