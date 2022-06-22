package JavaEXP.exp4.exp4_1.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import JavaEXP.exp4.exp4_1.myframe.MyFrame;

public class P_C {
    public static Lock lock = new ReentrantLock();
    public static Condition full = lock.newCondition();
    public static Condition empty = lock.newCondition();
    //�������������߳�����
    public static int pro_threadnum,con_threadnum;
    public static int productive=100;//��Ʒ����
    //����ش�С
    public static int catchMAX;
    //���������ּ���
    public static int namepro=1;
    //���������ּ���
    public static int namecon=1;
    /**
     * @return
     * productive getter
     */
    public static int getproduceive() {
        return productive;
    }
    /**
     * ���ٿ���������
     */
    public static void lessproduceive() {
        productive--;
    }

    //��Ŀһ ��������˿ʹ����߳���ϵ
    public P_C() {
        MyFrame.pro_list.clear();
        //��ʼ����������
        for(int i=0;i<productive;i++) {
            MyFrame.pro_list.add(new String(String.valueOf(i)));
        }
    }
    /**
     * @param pro
     * @param con
     * @param catchmax
     * ���������ߣ������ߣ�����ش�С
     */
    public void setThreadnum(int pro,int con,int catchmax) {
        pro_threadnum=pro;
        con_threadnum=con;
        catchMAX=catchmax;
    }
    /**
     * ���������ߣ��������߳����������߳�
     */
    public void run() {
        int max,min,decive;
        if(pro_threadnum>=con_threadnum) {
            max=pro_threadnum;
            min=con_threadnum;
            decive=max-min;
            for(int i=0;i<min;i++) {
                new producer().start();
                new consumer().start();
            }
            for(int i=0;i<decive;i++) {
                new producer().start();
            }
        }
        else {
            min=pro_threadnum;
            max=con_threadnum;
            decive=max-min;
            for(int i=0;i<min;i++) {
                new producer().start();
                new consumer().start();
            }
            for(int i=0;i<decive;i++) {
                new consumer().start();
            }
        }
        namepro=1;
        namecon=1;
    }
}

