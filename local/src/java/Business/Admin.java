/** *********************************************************************************
 * @author Elijah T. Badger                                                         *
 * Admin.java (Project)                                                             *
 * Editor: N/A Edit Date: N/A                                                       *
 ********************************************************************************** */
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * **********************************************************************************
 * Admin Class. Requires 0 or 3 parameters. Purpose: Complete database tasks and
 * hold relevant values from database in class property fields. 
 **********************************************************************************
 */
public class Admin {

    public String employeeNumber;
    public String username;
    public String password;
    private DBAccess db = new DBAccess();

    /**
     * **********************************************************************************
     * Customer constructor, Initializes all properties to "" when 0 parameters
     * are given.
 **********************************************************************************
     */
    public Admin() {
        String employeeNumber = "";
        String username = "";
        String password = "";
    }

    /**
     * **********************************************************************************
     * Dentist constructor, Initializes properties to given values.
 **********************************************************************************
     */
    public Admin(String employeeNumber, String username, String password) {
        this.employeeNumber = employeeNumber;
        this.username = username;
        this.password = password;
    }

    /**
     * **********************************************************************************
     * All get/set methods for Admin properties.
 **********************************************************************************
     */
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

    /**
     * **********************************************************************************
     * display, shows all property values. Requires 0 parameters. Prints the
     * value of all properties to the server log.
 **********************************************************************************
     */
    public void display() {
        System.out.println("Displaying Admin properties. Employee Number: " + this.getEmpNumber() + ". Password: " + this.getPassword() + ". Username: " + this.getUsername() + ".");
    }

    /**
     * **********************************************************************************
     * selectDB, uses SELECT SQL to query database. Requires 1 String parameter.
     * Queries the Admin table for entries whose id key matches the given
     * parameter.
 **********************************************************************************
     */
    public void selectDB(String ID) {

        //String sql = "SELECT * FROM Admin WHERE EmployeeID = " + ID;
        String sql = "SELECT * FROM Admin WHERE username = '" + ID +"'";
        ResultSet resultSet = db.SelectDB(sql);

        try {
            resultSet.next();

            setEmpNumber(resultSet.getString("EmployeeID"));
            setUsername(resultSet.getString("Username"));
            setPassword(resultSet.getString("Password"));

        } catch (SQLException e) {
            System.out.println("Error with Admin DB Select Method: " + e);
        }

    }

    /**
     * **********************************************************************************
     * insertDB, uses INSERT SQL to insert into database. Requires 3 String
     * parameters. Inserts the given parameters into the Admin table of the
     * database. 
 **********************************************************************************
     */
    public void insertDB() {

        String sql = "Insert into Admin (EmployeeID, Username, Password) VALUES ('" + getEmpNumber() + "', '" + getUsername() + "', '" + getPassword() + "')";
        db.InsertDB(sql);

    }

    /**
     * **********************************************************************************
     * updateDB, uses UPDATE SQL to update database. Requires 0 parameters.
     * Updates from the Admin table in based on the current values of class
     * properties.
 **********************************************************************************
     */
    public void updateDB() {

        String sql = "UPDATE Admin set Username='" + getUsername() + "'," + " Password='" + getPassword() + " 'WHERE EmployeeID='" + getEmpNumber() + "'";
        db.updateDB(sql);
    }

    /**
     * **********************************************************************************
     * deleteDB, uses DELETE SQL to delete from database. Requires 0 parameters.
     * Deletes an entry from the Admin Table based on current class property
     * values.
 **********************************************************************************
     */
    public void deleteDB() {

        String sql = "Delete from Admin where EmployeeID = '" + getEmpNumber() + "'";
        db.deleteDB(sql);
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
