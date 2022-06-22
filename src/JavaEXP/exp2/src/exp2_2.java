package JavaEXP.exp2.src;

public class exp2_2 {
    // Main method
    public static void main(String[] args) {
        // Create two comparable circles
        Circle1 circle1 = new Circle1(5);
        Circle1 circle2 = new Circle1(4);
    try{
        System.out.println(5/1);
    }catch (ArithmeticException e){
    System.out.println("sss");
    }
        // Display the max circle
        Circle1 circle = (Circle1)GeometricObject1.max(circle1, circle2);
        System.out.println("The max circle's radius is " +
                circle.getRadius());
        System.out.println(circle);
    }
}

abstract class GeometricObject1 implements Comparable {
// Implement it
    public static Circle1 max(Circle1 circle1, Circle1 circle2){
        if(circle1.compareTo(circle2)>=1){
            return circle1;
        }
        else return circle2;
    }
}
class Circle1 extends GeometricObject1 {
    private double R;
    public Circle1(double R){
        this.R = R;
    }

    @Override
    public int compareTo(Object o) {
        Circle1 cir = (Circle1) o;
        if(R>cir.R) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public double getRadius(){
        return R;
    }
}