/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codefornature;

/**
 *
 * @author SCSM11
 */
import org.mindrot.jbcrypt.BCrypt;
public class PasswordHashing {
      public static String hashPassword (String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
    public static boolean PasswordCheck(String plainTextPassword, String hashed){
            return BCrypt.checkpw(plainTextPassword, hashed);
    }
}
