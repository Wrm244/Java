package JavaEXP.exam.example;

public class Triangles extends shapes{
    double edg1,edg2,edg3;

    Triangles(double edg1,double edg2,double edg3){
        this.edg1 = edg1;
        this.edg2 = edg2;
        this.edg3 = edg3;
    }
    double areaCalculation(){
        double s = (edg1 + edg2 + edg3) / 2;
        return (Math.sqrt(s*(s-edg1)*(s-edg2)*(s-edg3)));   //���׹�ʽ��ֻ��Ҫ֪�������ε������߾��ܼ������
    }
    double perimeterCalculation(){
        return (edg1 + edg2 + edg3);
    }
}
