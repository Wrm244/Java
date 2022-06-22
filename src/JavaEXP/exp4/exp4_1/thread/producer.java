package JavaEXP.exp4.exp4_1.thread;

import java.util.Random;

import JavaEXP.exp4.exp4_1.myframe.MyFrame;

public class producer extends Thread{
    private String name;
    producer(){
        this.name=String.valueOf(P_C.namepro++);
    }
    @Override
    public void run() {
        while(P_C.getproduceive()>0) {
            P_C.lock.lock();
            try {
                sleep(3000);
                //�������������
                while(MyFrame.catch_list.size()==P_C.catchMAX) {
                    //����߳�������Ϣ
                    MyFrame.showInfo("����:Full! "+name+"�����������裬��������\n");
                    MyFrame.setfull(true);
                    //�����߱�������������״̬
                    MyFrame.prostate[Integer.parseInt(name)-1]=false;
                    //���º����repaint()ˢ�»���
                    MyFrame.subPanel.repaint();
                    MyFrame.showpanel.repaint();
                    P_C.full.await();
                    //�����߱����ѣ�����״̬
                    MyFrame.prostate[Integer.parseInt(name)-1]=true;
                    //����repaint()ˢ�»���
                    MyFrame.subPanel.repaint();
                    //����߳�������Ϣ
                    MyFrame.showInfo(this.name+"�������߿�ʼ\n");
                }
                //��ʼ����
                MyFrame.prostate[Integer.parseInt(name)-1]=true;
                MyFrame.subPanel.repaint();
                //������������ȡ��
                String str=MyFrame.pro_list.removeLast();
                if(MyFrame.catch_list.add(str)) {
                    MyFrame.showInfo(name+"������������: "+str+"\n");
                    MyFrame.setempty(false);
                    MyFrame.showpanel.repaint();
                    P_C.empty.signal();
                }else {
                    P_C.full.await();
                }
            }catch (InterruptedException ie) {
                //�����쳣˵�����̱��쳣�ж�
                MyFrame.showInfo("�����쳣��ֹ!\n");
            } finally{
                P_C.lock.unlock();
                //���ٿ�����������
                P_C.lessproduceive();
                try {
                    //�߳������ͣ����
                    sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        MyFrame.showInfo("����");
    }

}

