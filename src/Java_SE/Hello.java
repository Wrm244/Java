package Java_SE;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Hello{
    public static void main(String[] args) {
        Integer integer= 24;
        ArrayList dates = new ArrayList();
        dates.add(new Date());
        //dates.add(new String("hello"));
        Date da = (Date)dates.get(0);
        "ABV".compareTo("Abc");
        //B text =new B();
        B.m1();

    }
}

interface A{
    static void m1() {

    }
}
class B implements A{

    public static void m1(){
        System.out.println("Hello");
    }
}
