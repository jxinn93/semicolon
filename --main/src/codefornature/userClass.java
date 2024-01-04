/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codefornature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class userClass {
    private String email;
    private String username;
    private String password;
    private String regDate;
    private int points;
    
    public static final String SUrl = "jdbc:mysql://localhost:3306/user";
    public static final String SUser = "root";
    public static final String SPass = "";
    
    public userClass(String email, String username, String password,String regDate, int points) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.points = points;
    }
     public static List<userClass> getAllUsers() {
        List<userClass> users = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();

            String query = "SELECT * FROM user";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String regDate = rs.getString("regDate");
                int points = rs.getInt("points");

                userClass user = new userClass(email, username, password,regDate,  points);
                users.add(user);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }

        return users;
    }
}
