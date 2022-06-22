package JavaEXP.exp4.exp4_1.myframe;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import JavaEXP.exp4.exp4_1.thread.P_C;
public class MyFrame extends JFrame{
    private static final long serialVersionUID = 1222538739701278727L;
    //������ĸ�������
    @SuppressWarnings("unused")
    private  JPanel toprightpanel,topleftpanel,midpanel,buttonpanel;
    //�м���ʾ������
    public static MyShowPanel showpanel;
    private  JButton beginbutton;
    private static  JTextArea textcout;
    private  JScrollPane scrollpane;
    //ѡ��������
    private  JComboBox<String> catch_choice;
    private  JComboBox<String> pro_choice;
    private JComboBox<String> con_choice;
    //���������ѣ��������
    public static  LinkedList<String> pro_list;
    public static LinkedList<String> con_list;
    public static LinkedList<String> catch_list;
    //����ش�С������������������������
    public static int catch_num,pro_num,con_num;
    //�����״̬
    private static  boolean empty;
    private static boolean full;
    //�Ӵ�����ʾ������������״̬
    private static JFrame subFrame;
    //��ʾ�����������ߵĻ���
    public static sumpanel subPanel;
    //�����������ߵ�״̬����
    public static boolean[] prostate;
    public static boolean[] constate;

    /**
     * @return
     * empty getter
     */
    public static boolean isempty() {
        return empty;
    }
    /**
     * @param is
     * empty setter
     */
    public static void setempty(boolean is) {
        empty=is;
    }
    /**
     * @return
     * full getter
     */
    public static boolean isfull() {
        return full;
    }
    /**
     * @param is
     * full setter
     */
    public static void setfull(boolean is) {
        full=is;
    }

    /**
     * ��ս����״̬
     */
    public void clear() {
        pro_list.clear();
        catch_list.clear();
        con_list.clear();
        setempty(false);
        setfull(false);
    }
    //����
    private static Font font=new Font("����", Font.PLAIN, 20);
    //��̬��ʼ��
    static {
        empty=false;
        full=false;
        pro_num=100;
        pro_list=new LinkedList<>();
        con_list=new LinkedList<>();
        catch_list=new LinkedList<>();
    }
    MyFrame(){
        this.setFont(font);
        //��ʼ���������Ϣ
        topleftpanel();
        scrollpane.setBounds(20, 10, 350, 170);

        toprightpanel();
        toprightpanel.setBounds(400, 10, 350, 170);

        midlabel();
        midpanel.setBounds(20, 190, 800, 20);

        lowpanel();
        buttonpanel.setBounds(20,580,750,40);

        showpanel=new MyShowPanel();
        showpanel.setBounds(0,220,770,350);

        subFrame=new JFrame();
        //������
        this.setLayout(null);
        this.add(toprightpanel);
        this.add(scrollpane);
        this.add(midpanel);
        this.add(buttonpanel);
        this.add(showpanel);

        //���ô�������
        setSize(770, 680);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);//���ڴ�С���ɱ�
        setLocation(200,200);
    }
    /**
     * @param string
     * ���������Ϣ
     */
    public static void showInfo(String string) {
        textcout.append(string);
        //�Զ���������
        textcout.setCaretPosition(textcout.getDocument().getLength());
    }
    /**
     * ���������Ҳ�ѡ�񻭰�
     */
    private void toprightpanel() {
        JLabel toprightprolabel,toprightcatchlabel,toprightconlabel;
        String []numberStr= {"0","1","2","3","4","5","6","7","8","9","10"};

        toprightprolabel=new JLabel();
        toprightprolabel.setText("����������");
        toprightprolabel.setBounds(5,5,80,20);
        pro_choice=new JComboBox<String>(numberStr);
        pro_choice.setBounds(90,5,60,20);
        JPanel pane1=new JPanel();
        pane1.setLayout(null);
        pane1.add(toprightprolabel);
        pane1.add(pro_choice);

        toprightconlabel=new JLabel();
        toprightconlabel.setText("����������");
        toprightconlabel.setBounds(5, 5,80, 20);
        con_choice=new JComboBox<String>(numberStr);
        con_choice.setBounds(90,5,60,20);
        JPanel pane2=new JPanel();
        pane2.setLayout(null);
        pane2.add(toprightconlabel);
        pane2.add(con_choice);

        toprightcatchlabel=new JLabel();
        toprightcatchlabel.setText("����ش�С");
        toprightcatchlabel.setBounds(5, 5,80, 20);
        catch_choice=new JComboBox<String>(numberStr);
        catch_choice.setBounds(90,5,60,20);
        JPanel pane3=new JPanel();
        pane3.setLayout(null);
        pane3.add(toprightcatchlabel);
        pane3.add(catch_choice);


        toprightpanel=new JPanel();
        toprightpanel.setBorder(BorderFactory.createTitledBorder(null, "ѡ��", TitledBorder.LEFT, TitledBorder.TOP));
        toprightpanel.setLayout(new BoxLayout(toprightpanel,BoxLayout.Y_AXIS));
        toprightpanel.add(pane1);
        toprightpanel.add(pane2);
        toprightpanel.add(pane3);
    }
    /**
     * ����������໭��
     */
    private void topleftpanel() {
        textcout=new JTextArea(20,10);
        textcout.setEditable(false);
        scrollpane=new JScrollPane();
        scrollpane.setViewportView(textcout);
        scrollpane.setColumnHeaderView(new JLabel("������ʾ"));
        textcout.setFont(font);

    }
    /**
     * �м�label
     */
    private void midlabel() {
        JLabel prolabel,catchlabel,conlabel;
        //prolabel=new JLabel();
        conlabel=new JLabel();
        catchlabel=new JLabel();

       // prolabel.setText("������");
        conlabel.setText("������");
        catchlabel.setText("�����");

        //prolabel.setBounds(35,5,200,20);
        conlabel.setBounds(535,5,200,20);
        catchlabel.setBounds(285,5,200,20);

        midpanel=new JPanel();
        midpanel.setLayout(null);
       // midpanel.add(prolabel);
        //midpanel.add(conlabel);
        midpanel.add(catchlabel);
    }
    /**
     * �ײ���ť
     */
    private void lowpanel() {
        beginbutton=new JButton();
        beginbutton.setText("��ʼ");
        beginbutton.setBounds(310,1,70,35);
        beginbutton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==beginbutton) {
                    //�Ӵ���
                   pro_num=Integer.valueOf((String)pro_choice.getSelectedItem());
                    catch_num=Integer.valueOf((String)catch_choice.getSelectedItem());
                    con_num=Integer.valueOf((String)con_choice.getSelectedItem());
                    prostate=new boolean[pro_num];
                    constate=new boolean[con_num];
                    setstate();

                    subPanel=new sumpanel(pro_num,con_num);
                    subFrame.setLayout(null);
                    subPanel.setBounds(5, 5, 305, 305);
                    subFrame.setSize(400,400);
                    subFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    subFrame.add(subPanel);
                    subFrame.setLocation(200,200);
                    subFrame.setVisible(true);
                    clear();
                    textcout.setText("");
                    P_C pc=new P_C();

                    pc.setThreadnum(pro_num, con_num,catch_num);
                    pc.run();
                }

            }

        });
        buttonpanel=new JPanel();
        buttonpanel.setLayout(null);
        buttonpanel.add(beginbutton);
    }
    public static void main(String[]args) {
        @SuppressWarnings("unused")
        MyFrame a=new MyFrame();
    }
    /**
     * ��ʼ��������������״̬
     */
    public void setstate() {
        for(int i=0;i<pro_num;i++) {
            prostate[i]=false;
        }
        for(int i=0;i<con_num;i++) {
            constate[i]=false;
        }
    }
    public class MyShowPanel extends JPanel{
        /**
         *
         */
        private static final long serialVersionUID = 4590517425748077768L;
        MyShowPanel(){
            this.setBackground(Color.WHITE);
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.blue);
            for(int i=0;i<pro_list.size();i++) {
                g.fill3DRect(35, i*20+5, 200, 20, true);
                g.drawString(pro_list.get(i), 20, i*20+15);
            }
            if(isfull()) {
                //������������������������������Ļ�������Ϊ��ɫ
                g.setColor(Color.RED);
            }
            g.setColor(Color.gray);
            for(int i=0;i<catch_list.size();i++) {
                g.fill3DRect(285, i*20+5, 200, 20, true);
                g.drawString(catch_list.get(i), 270, i*20+15);
            }

            g.setColor(Color.yellow);
            for(int i=0;i<con_list.size();i++) {
                g.fill3DRect(535, i*20+5, 200, 20, true);
                g.drawString(con_list.get(i), 520, i*20+15);
            }
            if(isempty()) {
                //�����������Ϊ��
                g.setColor(Color.black);
                g.fill3DRect(285, 5, 200, 200, true);
                g.setColor(Color.black);
                g.drawString("��", 385, 100);
            }
        }

    }
    @SuppressWarnings("serial")
    public class sumpanel extends JPanel{
        private int pro_num,con_num;//pro_num��������������con_num������������
        sumpanel(int pro,int con){
            setLayout(null);
            pro_num=pro;
            con_num=con;
            //�Ӵ���������������label����
            JLabel[] prolabel=new JLabel[pro];
            JLabel[] conlabel=new JLabel[con];
            for(int i=0;i<pro;i++) {
                prolabel[i]=new JLabel();
                prolabel[i].setText((i+1)+"��������");
                prolabel[i].setBounds(5, 5+20*i, 100,20 );
                add(prolabel[i]);
            }
            for(int j=0;j<con;j++) {
                conlabel[j]=new JLabel();
                conlabel[j].setText((j+1)+"��������");
                conlabel[j].setBounds(180, 5+20*j, 100, 20);
                add(conlabel[j]);
            }
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.green);
            for(int i=0;i<pro_num;i++) {
                if(prostate[i]==true) {
                    g.fill3DRect(110,5+20*i,10,10,true);
                }
            }
            g.setColor(Color.green);
            for(int i=0;i<con_num;i++) {
                if(constate[i]) {
                    g.fillOval(285, 5+20*i, 10, 10);
                }

            }
        }
    }
}


