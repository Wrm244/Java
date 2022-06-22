package JavaEXP.exp4.exp4_1.thread;


import java.util.Random;

import JavaEXP.exp4.exp4_1.myframe.MyFrame;

public class consumer extends Thread{
    private String name;
    consumer(){
        this.name=String.valueOf(P_C.namecon++);
    }
    @Override
    public void run() {
        while(!(P_C.getproduceive()==0 && MyFrame.catch_list.size()==0)) {
            P_C.lock.lock();
            try {
                sleep(1000);
                //����ؿ�������
                while(MyFrame.catch_list.isEmpty()) {
                    MyFrame.showInfo("����: Empty!\n"+name+"������������!\n");
                    MyFrame.setempty(true);
                    //����������״̬Ϊfalse��������
                    MyFrame.constate[Integer.parseInt(name)-1]=false;
                    //ˢ�»���
                    MyFrame.showpanel.repaint();
                    MyFrame.subPanel.repaint();
                    P_C.empty.await();
                    //����������״̬
                    MyFrame.constate[Integer.parseInt(name)-1]=true;
                    //ˢ�»���
                    MyFrame.subPanel.repaint();
                    //����߳�������Ϣ
                    MyFrame.showInfo(name+"�������߿�ʼ\n");
                }
                //��ʼ����
                MyFrame.constate[Integer.parseInt(name)-1]=true;
                MyFrame.subPanel.repaint();
                //�ӻ������ȡ��
                String str=MyFrame.catch_list.removeLast();
                if(MyFrame.con_list.add(str)) {
                    MyFrame.showInfo(name+"��������ȡ��: " + str+"\n");
                    MyFrame.setfull(false);
                    MyFrame.showpanel.repaint();
                    P_C.full.signal();
                }
            }catch (InterruptedException ie) {
                MyFrame.showInfo("�����쳣��ֹ!\n");
            }finally {
                P_C.lock.unlock();
                try {
                    //�߳������ͣ����
                    sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


