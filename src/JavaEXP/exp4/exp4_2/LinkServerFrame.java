package JavaEXP.exp4.exp4_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkServerFrame extends JFrame {
    private LinkServerFrame() {
        setLayout( null );
        setBounds(540,200, 400,250 );
        setVisible( true );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        JLabel lbIP = new JLabel( "������ IP ��ַ��" );
        lbIP.setBounds( 10,10,100,30 );
        lbIP.setVisible( true );
        JLabel userName = new JLabel( "�û�����" );
        userName.setBounds( 40,60,50,30 );
        userName.setVisible( true );
        JTextField jfIP = new JTextField(  ); // IP ��ַ�����
        jfIP.setBounds( 110,10,250,30 );
        jfIP.setVisible( true );
        JTextField jfUser = new JTextField(  );
        jfUser.setBounds( 110,60,250,30 );
        jfUser.setVisible( true );
        JButton btn = new JButton( "���ӷ�����" );
        btn.setBounds( 120,100,100,20 );
        btn.setVisible( true );
        btn.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jfIP.getText().equals( "" ) && !jfUser.getText().equals( "" )) {
                    dispose(); // ���ٵ�ǰ����
                    // �����ͻ��˴��岢����
                    ClientFrame clientFrame = new ClientFrame( jfIP.getText().trim(), jfUser.getText().trim() );
                } else {
                    JOptionPane.showMessageDialog( null,"�ı���������ݲ���Ϊ�գ�","����",JOptionPane.WARNING_MESSAGE );
                }
            }
        } );
        Container center = getContentPane();
        center.add(lbIP);
        center.add( jfIP );
        center.add( userName );
        center.add( jfUser );
        center.add( btn );
        center.setBackground( Color.WHITE );
    }

    public static void main(String[] args) {
        new LinkServerFrame();
    }
}
