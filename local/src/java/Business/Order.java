/** *********************************************************************************
 * @author Elijah T. Badger                                                         *
 * Order.java (Project)                                                             *
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
 * Order Class. Requires 0 or 4 parameters. Purpose: Complete database tasks and
 * hold relevant values from database in class property fields. 
 **********************************************************************************
 */
public class Order {

    public String orderID;
    public String CustomerID;
    public String ShipperID;
    public String status;
    private String sql;
    private final DBAccess db = new DBAccess();

    /**
     * **********************************************************************************
     * Order constructor, Initializes all properties to "" when 0 parameters are
     * given.
 **********************************************************************************
     */
    public Order() {
        String orderID = "";
        String CustomerID = "";
        String ShipperID = "";
        String status = "";
    }

    /**
     * **********************************************************************************
     * Order constructor, Initializes properties to given values.
 **********************************************************************************
     */
    public Order(String orderID, String CustomerID, String ShipperID, String status) {
        this.orderID = orderID;
        this.CustomerID = CustomerID;
        this.ShipperID = ShipperID;
        this.status = status;
    }

    /**
     * **********************************************************************************
     * All get/set methods for Order properties.
 **********************************************************************************
     */
    public String getOrderID() {
        return this.orderID;
    }

    public void setOrderID(String new_orderID) {
        this.orderID = new_orderID;
    }

    public String getCustomerID() {
        return this.CustomerID;
    }

    public void setCustomerID(String new_TID) {
        this.CustomerID = new_TID;
    }

    public String getShipperID() {
        return this.ShipperID;
    }

    public void setShipperID(String new_ShipperID) {
        this.ShipperID = new_ShipperID;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String new_status) {
        this.status = new_status;
    }

    /**
     * **********************************************************************************
     * selectDB, uses SELECT SQL to query database. Requires 1 String parameter.
     * Queries the Order table for entries whose id key matches the given
     * parameter.
 **********************************************************************************
     */
    public void selectDB(String orderID) {
        try {
            sql = "Select * from Order where OrderID = '" + orderID + "'";
            ResultSet resultSet = db.SelectDB(sql);

            resultSet.next();

            setOrderID(resultSet.getString("OrderID"));
            setCustomerID(resultSet.getString("CustomerID"));
            setShipperID(resultSet.getString("ShipperID"));
            setStatus(resultSet.getString("Status"));

        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Order). " + e);
        }
    }

    /**
     * **********************************************************************************
     * insertDB, uses INSERT SQL to insert into database. Requires 4 String
     * parameters. Inserts the given parameters into the Order table of the
     * database. 
 **********************************************************************************
     */
    public void insertDB() {

        sql = "Insert into Order (OrderID, CustomerID, Status, ShipperID) VALUES ('" + getOrderID() + "', '" + getCustomerID() + "', '" + getStatus() + "', '" + getShipperID() + "')";
        System.out.println(sql);
        db.InsertDB(sql);

    }

    /**
     * **********************************************************************************
     * updateDB, uses UPDATE SQL to update database. Requires 0 parameters.
     * Updates from the Order table in based on the current values of class
     * properties.
 **********************************************************************************
     */
    public void updateDB() {

        sql = "UPDATE Order set " + "CustomerID='" + getCustomerID() + "'," + " ShipperID='" + getShipperID() + "'," + " Status='" + getStatus() + "'" + " WHERE OrderID= '" + getOrderID() + "'";
        db.updateDB(sql);

    }

    /**
     * **********************************************************************************
     * deleteDB, uses DELETE SQL to delete from database. Requires 0 parameters.
     * Deletes an entry from the Order Table based on current class property
     * values.
 **********************************************************************************
     */
    public void deleteDB() {

        sql = "Delete from Order where OrderID = " + getOrderID();
        db.deleteDB(sql);

    }

    /**
     * **********************************************************************************
     * display, shows all property values. Requires 0 parameters. Prints the
     * value of all properties to the server log.
 **********************************************************************************
     */
    public void display() {
        System.out.println("Displaying Order properties. Order ID numbert: " + this.getOrderID() + ". Tire ID Number: " + this.getCustomerID() + ". Total tires in order: " + this.getShipperID() + ". Order Status: " + this.getStatus() + ".");
    }

    public static void main(String[] args) {
        String test_va = "1";
        Order test = new Order();
        //test.selectDB(test_va);

        //test.display();
        test.insertDB();
        //test.setPrice("3001");
        //test.updateDB();
        //test.deleteDB();
    }
}
