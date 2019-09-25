/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Admin.java (Project)                                                             *
  Editor: James Morelli Edit Date: 9/25/19                                                      * 
 ***********************************************************************************/
package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

/************************************************************************************
 * Admin Class. Requires 0 or 3 parameters. Purpose: Complete database tasks
 * and hold relevant values from database in class property fields. 
 ***********************************************************************************/
public class Admin {

    private String employeeNumber;
    private String username;
    private String password;
    private String sql;
    private final DBAccess db = new DBAccess();


 /************************************************************************************
 * Customer constructor, Initializes all properties to "" when 0 
 * parameters are given.
 ***********************************************************************************/      
    public Admin(){
        employeeNumber = "";
        username = "";
        password = "";
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
        System.out.println("Displaying Admin properties:\n Employee Number: " + getEmpNumber() + "\n Username: " + getUsername() + "\n Password: " + getPassword() + ".");
    }

/************************************************************************************
 * selectDB, uses SELECT SQL to query database. Requires 1 String parameter. Queries
 * the Admin table for entries whose id key matches the
 * given parameter.
 * @param adminID
 ***********************************************************************************/ 
    public void selectAdmin(String adminID) {
        try {
            
            sql = "Select * from Admin where EmployeeID = '" + adminID + "'";
            ResultSet resultSet = db.SelectDB(sql);

            resultSet.next();

            setEmpNumber(resultSet.getString("EmployeeID"));
            setUsername(resultSet.getString("Username"));
            setPassword(resultSet.getString("Password"));

        } catch (SQLException e) {
            System.out.println("Error collecting result in selectAdmin " + e);
        }
    }


/************************************************************************************
 * insertDB, uses INSERT SQL to insert into database. Requires 3 String parameters.
 * Inserts the given parameters into the Admin table of the 
 * database. 
 ***********************************************************************************/ 
    public void insertDB() {
        
            String sql = "Insert into Admin (EmployeeID, Username, password) VALUES ('" +getEmpNumber()+ "', '" +getUsername()+ "', '" +getPassword()+ "')";
            db.InsertDB(sql);
            
    }

/************************************************************************************
 * updateDB, uses UPDATE SQL to update database. Requires 0 parameters. Updates from the
 * Admin table in  based on the current values of class 
 * properties.
 ***********************************************************************************/ 
    public void updateDB() {
        
            sql = "UPDATE Admin set " + "Username='"+getUsername()+"'," + " Password='"+getPassword()+"'" + " WHERE EmployeeID= '" + getEmpNumber()+"'";
            db.updateDB(sql);
            
    }
/************************************************************************************
 * deleteDB, uses DELETE SQL to delete from database. Requires 0 parameters. Deletes
 * an entry from the Admin Table based on current class
 * property values.
 ***********************************************************************************/ 
    public void deleteDB() {
        
            sql = "Delete from Admin where EmployeeID = " + getEmpNumber();
            db.deleteDB(sql);
            
    }

    public static void main(String[] args) {
        String test_va = "5001";
        Admin test = new Admin();
        //Admin test = new Admin("5009", "Christian", "jumping");
        test.selectAdmin(test_va);

        test.display();
        //test.insertDB();
//        test.setPassword("CrapPassword");
//        test.updateDB();
        //test.deleteDB();
    }

}
