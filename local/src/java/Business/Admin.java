/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Admin.java (Project)                                                             *
  Editor: N/A Edit Date: N/A                                                       * 
 ***********************************************************************************/
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/************************************************************************************
 * Admin Class. Requires 0 or 3 parameters. Purpose: Complete database tasks
 * and hold relevant values from database in class property fields. 
 ***********************************************************************************/
public class Admin {

    public String employeeNumber;
    public String username;
    public String password;


 /************************************************************************************
 * Customer constructor, Initializes all properties to "" when 0 
 * parameters are given.
 ***********************************************************************************/      
    public Admin(){
        String employeeNumber = "";
        String username = "";
        String password = "";
    }
    
/************************************************************************************
 * Dentist constructor, Initializes properties to given values.
 ***********************************************************************************/ 
    public Admin(String employeeNumber, String username, String password) {
        this.employeeNumber = employeeNumber;
        this.username = username;
        this.password = password;
    }

    
/************************************************************************************
 * All get/set methods for Admin properties.
 ***********************************************************************************/
    public void setEmpNumber(String new_number) {
        this.employeeNumber = new_number;
    }

    public String getEmpNumber() {
        return this.employeeNumber;
    }

    public void setPassword(String new_password) {
        this.password = new_password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String new_username) {
        this.username = new_username;
    }

    public String getUsername() {
        return this.username;
    }
    
/************************************************************************************
 * display, shows all property values. Requires 0 parameters. Prints the value of all
 * properties to the server log.
 ***********************************************************************************/ 
    public void display() {
        System.out.println("Displaying Admin properties. Employee Number: " + this.getEmpNumber() + ". Password: " + this.getPassword() + ". Username: " + this.getUsername() + ".");
    }

    
/************************************************************************************
 * selectDB, uses SELECT SQL to query database. Requires 1 String parameter. Queries
 * the Admin table for entries whose id key matches the
 * given parameter.
 ***********************************************************************************/ 
    public void selectDB(String ID) {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at select (for Admin).");
            Statement statement = con.createStatement();
            String sql = "Select * from Admin where EmployeeID = '" + ID + "'";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Result set compiled (for Admin).");
            rs.next();

            this.setEmpNumber(rs.getString("EmployeeID"));
            System.out.println("results from 1: " + rs.getString(1));
            this.setUsername(rs.getString("Username"));
            System.out.println("results from 2: " + rs.getString(2));
            this.setPassword(rs.getString("Password"));
            System.out.println("results from 3: " + rs.getString(3));
            System.out.println("Selections completed...");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Admin). " + e);
            System.out.println(" ");
        }
    }


/************************************************************************************
 * insertDB, uses INSERT SQL to insert into database. Requires 3 String parameters.
 * Inserts the given parameters into the Admin table of the 
 * database. 
 ***********************************************************************************/ 
    public void insertDB(String empNum, String pw, String username) {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at insert (for Admin).");
            Statement statement = con.createStatement();
            String sql = "Insert into Admin (EmployeeID, Username, password) VALUES ('" + empNum + "', '" + pw + "', '" + username + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("Insert completed.");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at insertDB method (for Admin). " + e);
            System.out.println(" ");
        }
    }

/************************************************************************************
 * updateDB, uses UPDATE SQL to update database. Requires 0 parameters. Updates from the
 * Admin table in  based on the current values of class 
 * properties.
 ***********************************************************************************/ 
    public void updateDB() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at update (for Admin).");
            Statement statement = con.createStatement();
            PreparedStatement ps = con.prepareStatement("UPDATE Admin SET Username = ?, Password = ? WHERE EmployeeID = ?");
            ps.setString(1, this.getUsername());
            ps.setString(2, this.getPassword());
            ps.setString(3, this.getEmpNumber());
            System.out.println("Prepped statement compelted.");
            System.out.println(" ");
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at updateDB method (for Admin). " + e);
            System.out.println(" ");
        }
    }
/************************************************************************************
 * deleteDB, uses DELETE SQL to delete from database. Requires 0 parameters. Deletes
 * an entry from the Admin Table based on current class
 * property values.
 ***********************************************************************************/ 
    public void deleteDB() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at delete (for Admin).");
            Statement statement = con.createStatement();
            String sql = "Delete from Admin where EmployeeID = " + this.getEmpNumber();
            statement.executeUpdate(sql);
            System.out.println("Deletion completed.");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at updateDB method (for Admin). " + e);
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        String test_va = "1";
        Admin test = new Admin();
        //test.selectDB(test_va);

        //test.display();
        //test.insertDB("9", "385", "4", "Processing");
        //test.setPrice("3001");
        //test.updateDB();
        //test.deleteDB();
    }

}
