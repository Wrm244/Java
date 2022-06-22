package JavaEXP.exp1;

public class exp1_1 {
    public static void main(String[] args) {
        Rectangle k1 = new Rectangle();
        Rectangle k2 = new Rectangle();
        double area1,area2;
        double perimter1,perimter2;
        k1.lenght = 40;
        k1.weight = 4;
        k2.lenght = 35.9;
        k2.weight = 3;
        area1 = k1.getArea();
        area2 = k2.getArea();
        perimter1 = k1.getPerimter();
        perimter2 = k2.getPerimter();
        System.out.println("矩形的宽："+k1.weight+"，矩形的高："+k1.lenght+"，矩形的面积："+area1+"，矩形的周长："+perimter1);
        System.out.println("矩形的宽："+k2.weight+"，矩形的高："+k2.lenght+"，矩形的面积："+area2+"，矩形的周长："+perimter2);
    }
}
class Rectangle{
    double lenght;
    double weight;
    public double getArea() {
        return lenght * weight;
    }
    public double getPerimter() {
        return 2*(lenght+weight);
    }
}