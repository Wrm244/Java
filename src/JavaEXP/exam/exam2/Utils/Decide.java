package JavaEXP.exam.exam2.Utils;

/**
 * pack_name examination.Liuxuan
 *
 * @pro_name java_study
 * @author X·M·L
 * @create 2022-06-18 19:40
 */


import JavaEXP.exam.exam2.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ClassName: Decide
 * Date:      2022/6/18 19:40
 * author:    X_L
 * version:   V1.0
 */
public class Decide {
    public static void getEquationSolution(Equation equation){
        if(equation.getCoefficientA() == 0){
            double x ;
            x = -equation.getCoefficientC()/ equation.getCoefficientB();
            MessageManager.Inf("方程的解为："+format(x),"方程为一元一次方程");
        }
        else {
            double data = equation.getCoefficientB() * equation.getCoefficientB() - 4 * equation.getCoefficientA() * equation.getCoefficientC();
            if (data >= 0) {
                double x1 = ((-equation.getCoefficientB() + Math.sqrt(equation.getCoefficientB() * equation.getCoefficientB() - 4 * equation.getCoefficientA() * equation.getCoefficientC())) / (2 * equation.getCoefficientA()));//运用求根公式，并且Math.sqrt()为开平方根
                double x2 = ((-equation.getCoefficientB() - Math.sqrt(equation.getCoefficientB() * equation.getCoefficientB() - 4 * equation.getCoefficientA() * equation.getCoefficientC())) / (2 * equation.getCoefficientA()));//运用求根公式，并且Math.sqrt()为开平方根
                System.out.print("x1=" + x1 + "\n" + "x2=" + x2);//输出两个根的结果

                if (x1 != x2) {
                    MessageManager.Inf("方程的两个解为" + format(x1) + "   " + format(x2), "方程有实数解");
                } else {
                    MessageManager.Inf("方程的两个解相同为：" + format(x1), "方程有实数解");

                }
            }
            if (data < 0) {
                double realPart = -equation.getCoefficientB() / (2 * equation.getCoefficientA());
                double imaginaryPart= Math.sqrt(-data) / (2 * equation.getCoefficientA());

                MessageManager.Inf("方程的两个解为：" + "\n" + "  "+format(realPart) + " + " + format(imaginaryPart) + "i" + "\n" + "  " + format(realPart) +  " + " + format(imaginaryPart) + "i", "方程有虚数解");
            }
        }
        }
    /**
     * 控制Double变量输出格式方法
     * @param value double变量
     * @return      格式化后的值
     */
    public static String format(double value) {
        //控制输出格式
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }
}