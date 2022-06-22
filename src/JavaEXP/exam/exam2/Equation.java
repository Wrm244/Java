package JavaEXP.exam.exam2;
/**
 * pack_name examination.Liuxuan
 *
 * @pro_name java_study
 * @author X·M·L
 * @create 2022-06-18 19:39
 */

/**
 * ClassName: Equation
 * Date:      2022/6/18 19:39
 * author:    X_L
 * version:   V1.0
 */
public class Equation {
    private double coefficientA ;
    private double coefficientB ;
    private double coefficientC;

    private double solution;
    public  Equation(int coefficientA,int coefficientB,int coefficientC){
        setCoefficientA(coefficientA);
        setCoefficientB(coefficientB);
        setCoefficientC(coefficientC);
    }

    public double getCoefficientA() {
        return coefficientA;
    }

    public void setCoefficientA(int coefficientA) {
        this.coefficientA = coefficientA;
    }

    public double getCoefficientB() {
        return coefficientB;
    }

    public void setCoefficientB(int coefficientB) {
        this.coefficientB = coefficientB;
    }

    public double getCoefficientC() {
        return coefficientC;
    }

    public void setCoefficientC(int coefficientC) {
        this.coefficientC = coefficientC;
    }



}