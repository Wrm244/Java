package JavaEXP.exam.exam2.Utils;
/**
 * pack_name windowsTest.Utils
 *
 * @pro_name java_study
 * @author X·M·L
 * @create 2022-06-17 15:37
 */


import JavaEXP.exam.exam2.*;

/**
 * ClassName: UserException
 * Date:      2022/6/17 15:37
 * author:    X_L
 * version:   V1.0
 */

public class UserException extends Exception {
    public UserException(){

    }
    public UserException(String s){
        super(s);
        MessageManager.Warning(s,"Exception");
    }
}