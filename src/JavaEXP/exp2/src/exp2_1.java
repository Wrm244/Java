package JavaEXP.exp2.src;

public class exp2_1 {
    public static void main(String[] args) {
        ChinaPeople chinaPeople=new ChinaPeople();
        AmericanPeople americanPeople=new AmericanPeople();
        BeijingPeople beijingPeople=new BeijingPeople();
        chinaPeople.speakHello();
        americanPeople.speakHello();
        beijingPeople.speakHello();
        chinaPeople.averageHeight();
        americanPeople.averageHeight();
        beijingPeople.averageHeight();
        chinaPeople.averageWeight();
        americanPeople.averageWeight();
        beijingPeople.averageWeight();
        chinaPeople.chinaGongfu();
        americanPeople.americanBoxing();
        beijingPeople.beijingOpera() ;
        beijingPeople.chinaGongfu();
    }
}
class People {
    protected double weight,height;
    public void speakHello() {
        System.out.println("yayayaya");
    }
    public void averageHeight() {
        height=173;
        System.out.println("average height:"+height);
    }
    public void averageWeight() {
        weight=70;
        System.out.println("average weight:"+weight);
    }
}
class ChinaPeople extends People {
    public void speakHello() {
        System.out.println("����");
    }

    public void averageHeight() {
        height = 168.78;
        System.out.println("�й��˵�ƽ�����:" + height + " ����");
    }

    @Override
    public void averageWeight() {
        System.out.println("�й��˵�ƽ�����أ�65����");
    }

    public void chinaGongfu() {
        System.out.println("������,վ����,˯�繭");
    }
}
    class AmericanPeople extends People {
        public void speakHello(){
            System.out.println("How do you do");
        }
        //������2����дpublic void speakHello()���������"How do you do"
        public void averageHeight(){
            System.out.println("American's average height:176 cm");
        }
        //������3�� ��дpublic void averageHeight()���������"American's average height:176 cm"
        public void averageWeight() {
            weight = 75;
            System.out.println("American's average weight:"+weight+" kg");
        }
        public void americanBoxing() {
            System.out.println("ֱȭ����ȭ�����ȭ");
        }
    }

    class BeijingPeople extends ChinaPeople {
        public void averageHeight(){
            System.out.println("�����˵�ƽ�����: 172.5����");
        }
        //������4����дpublic void averageHeight()����,���:"�����˵�ƽ�����: 172.5����"
        public void averageWeight(){
            System.out.println("�����˵�ƽ�����أ�70����");
        }
        //������5����дpublic void averageWeight()����,���:"�����˵�ƽ�����أ�70����"
        public void beijingOpera() {
            System.out.println("���������¡�����������");
        }
    }

