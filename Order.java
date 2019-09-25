/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Order.java (Project)                                                             *
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
 * Order Class. Requires 0 or 4 parameters. Purpose: Complete database tasks
 * and hold relevant values from database in class property fields. 
 ***********************************************************************************/
public class Order {

    public String orderID;
    public String tireID;
    public String quantity;
    public String status;

    
 /************************************************************************************
 * Order constructor, Initializes all properties to "" when 0 
 * parameters are given.
 ***********************************************************************************/    
    public Order() {
        String orderID = "";
        String tireID = "";
        String quantity = "";
        String status = "";
    }

/************************************************************************************
 * Order constructor, Initializes properties to given values.
 ***********************************************************************************/ 
    public Order(String orderID, String tireID, String quantity, String status) {
        this.orderID = orderID;
        this.tireID = tireID;
        this.quantity = quantity;
        this.status = status;
    }

/************************************************************************************
 * All get/set methods for Order properties.
 ***********************************************************************************/  
    public String getOrderID() {
        return this.orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getTireID() {
        return this.tireID;
    }

    public void setTireID(String new_TID) {
        this.tireID = new_TID;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String new_quantity) {
        this.quantity = new_quantity;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String new_status) {
        this.status = new_status;
    }
/************************************************************************************
 * selectDB, uses SELECT SQL to query database. Requires 1 String parameter. Queries
 * the Order table for entries whose id key matches the
 * given parameter.
 ***********************************************************************************/
    public void selectDB(String OrderID) {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at select (for Order).");
            Statement statement = con.createStatement();
            String sql = "Select * from Order where OrderID = '" + OrderID + "'";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Result set compiled (for Order).");
            rs.next();

            this.setOrderID(rs.getString("OrderID"));
            System.out.println("results from 1: " + rs.getString(1));
            this.setTireID(rs.getString("TireID"));
            System.out.println("results from 2: " + rs.getString(2));
            this.setQuantity(rs.getString("Quantity"));
            System.out.println("results from 3: " + rs.getString(3));
            this.setStatus(rs.getString("Status"));
            System.out.println("results from 4: " + rs.getString(4));
            System.out.println("Selections completed...");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Order). " + e);
            System.out.println(" ");
        }
    }

/************************************************************************************
 * insertDB, uses INSERT SQL to insert into database. Requires 4 String parameters.
 * Inserts the given parameters into the Order table of the 
 * database. 
 ***********************************************************************************/ 
    public void insertDB(String order, String tire, String quantity, String status) {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at insert (for Order).");
            Statement statement = con.createStatement();
            String sql = "Insert into Order (orderID, tireID, quantity, status) VALUES ('" + order + "', '" + tire + "', '" + quantity + "', '" + status + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("Insert completed.");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at insertDB method (for Order). " + e);
            System.out.println(" ");
        }
    }

/************************************************************************************
 * updateDB, uses UPDATE SQL to update database. Requires 0 parameters. Updates from the
 * Order table in  based on the current values of class 
 * properties.
 ***********************************************************************************/ 
    public void updateDB() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at update (for Order).");
            Statement statement = con.createStatement();
            PreparedStatement ps = con.prepareStatement("UPDATE Order SET TireID = ?, Quantity = ?, Status = ? WHERE OrderID = ?");
            ps.setString(1, this.getTireID());
            ps.setString(2, this.getQuantity());
            ps.setString(3, this.getStatus());
            ps.setString(4, this.getOrderID());
            System.out.println("Prepped statement compelted.");
            System.out.println(" ");
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at updateDB method (for Order). " + e);
            System.out.println(" ");
        }
    }
/************************************************************************************
 * deleteDB, uses DELETE SQL to delete from database. Requires 0 parameters. Deletes
 * an entry from the Order Table based on current class
 * property values.
 ***********************************************************************************/ 
    public void deleteDB() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at delete (for Order).");
            Statement statement = con.createStatement();
            String sql = "Delete from Order where OrderID = " + this.getOrderID();
            statement.executeUpdate(sql);
            System.out.println("Deletion completed.");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at updateDB method (for Order). " + e);
            System.out.println(" ");
        }
    }
    
/************************************************************************************
 * display, shows all property values. Requires 0 parameters. Prints the value of all
 * properties to the server log.
 ***********************************************************************************/ 
    public void display() {
        System.out.println("Displaying Order properties. Order ID numbert: " + this.getOrderID() + ". Tire ID Number: " + this.getTireID() + ". Total tires in order: " + this.getQuantity() + ". Order Status: " + this.getStatus() + ".");
    }

    public static void main(String[] args) {
        String test_va = "1";
        Order test = new Order();
        //test.selectDB(test_va);

        //test.display();
        test.insertDB("9", "385", "4", "Processing");
        //test.setPrice("3001");
        //test.updateDB();
        //test.deleteDB();
    }
}
