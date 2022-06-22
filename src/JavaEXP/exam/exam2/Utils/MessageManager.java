package JavaEXP.exam.exam2.Utils;


import javax.swing.*;


public class MessageManager {
    /*
     * Used to throw message and pop-ups.
     */
    public static void Warning(String content, String title) {
        // throw warning
        throwMessage(content, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void Question(String content, String title) {
        // throw question
        throwMessage(content, title, JOptionPane.QUESTION_MESSAGE);
    }
    public static void Inf(String content, String title) {
        // throw question
        throwMessage(content, title, JOptionPane.INFORMATION_MESSAGE);
    }
    static void throwMessage(String content, String title, int type) {
        JOptionPane.showMessageDialog(null, content, title, type);
    }
}