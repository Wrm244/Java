package JavaEXP.exam.exam3;

public class TVE {

	public static boolean panduan(double a,double b,double c) {

		double der = b*b-4*a*c;
		if (der < 0)
			return true;
		else
			return false;
	}
	public static String jisuan1(double a,double b,double c) {

		double der = b*b-4*a*c;
		double x1;
		x1 = (-b + Math.sqrt(der))/(2*a);
		return String.format("%.3f", x1);
	}
	public static String jisuan2(double a,double b,double c) {

		double der = b*b-4*a*c;
		double x2;
		x2 = (-b - Math.sqrt(der))/(2*a);
		return String.format("%.3f", x2);
	}
}
