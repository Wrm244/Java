package JavaEXP.exam.exam2;
/**
 * pack_name examination.Liuxuan
 *
 * @pro_name java_study
 * @author X·M·L
 * @create 2022-06-18 20:15
 */

import java.awt.*;

/**
 * ClassName: Main
 * Date:      2022/6/18 20:15
 * author:    X_L
 * version:   V1.0
 */
public class Main {
    public static void main(String[] args) {
        /*
        *方程有虚数解 1 2 8
        * 方程有实数解 1 2 1
        * 方程为一元一次方程 0 1 1
        * 有输出格式化 保留两位小数
        * 输入不是字符
        * */
        EventQueue.invokeLater(() -> {
            try {
                MainPage frame = new MainPage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}