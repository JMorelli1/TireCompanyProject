/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Order.java (Project)                                                             *
  Editor: 9/25/19 Edit Date: 9/25/19                                                       * 
 ***********************************************************************************/
package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

/************************************************************************************
 * Order Class. Requires 0 or 4 parameters. Purpose: Complete database tasks
 * and hold relevant values from database in class property fields. 
 ***********************************************************************************/
public class Order {

    private String orderID;
    private String tireID;
    private String quantity;
    private String status;
    private String sql;
    private final DBAccess db = new DBAccess();

    
 /************************************************************************************
 * Order constructor, Initializes all properties to "" when 0 
 * parameters are given.
 ***********************************************************************************/    
    public Order() {
        orderID = "";
        tireID = "";
        quantity = "";
        status = "";
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
 * @param orderID
 ***********************************************************************************/
    public void selectDB(String orderID) {
        try{
            sql = "Select * from Order where OrderID = '" + orderID + "'";
            ResultSet resultSet = db.SelectDB(sql);
            
            resultSet.next();

            setOrderID(resultSet.getString("OrderID"));
            setTireID(resultSet.getString("TireID"));
            setQuantity(resultSet.getString("Quantity"));
            setStatus(resultSet.getString("Status"));

        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Order). " + e);
        }
    }

/************************************************************************************
 * insertDB, uses INSERT SQL to insert into database. Requires 4 String parameters.
 * Inserts the given parameters into the Order table of the 
 * database. 
 ***********************************************************************************/ 
    public void insertDB() {
        
        sql = "Insert into Order (OrderID, TireID, Quantity, Status) VALUES ('"+getOrderID()+"', '"+getTireID()+"', '"+getQuantity()+"', '"+getStatus()+"')";
        System.out.println(sql);
        db.InsertDB(sql);
            
    }

/************************************************************************************
 * updateDB, uses UPDATE SQL to update database. Requires 0 parameters. Updates from the
 * Order table in  based on the current values of class 
 * properties.
 ***********************************************************************************/ 
    public void updateDB() {
        
        sql = "UPDATE Order set " + "TireID='"+getTireID()+"'," + " Quantity='"+getQuantity()+"'," + " Status='"+getStatus()+"'" + " WHERE OrderID= '" + getOrderID()+"'";
        db.updateDB(sql);
        
    }
    
/************************************************************************************
 * deleteDB, uses DELETE SQL to delete from database. Requires 0 parameters. Deletes
 * an entry from the Order Table based on current class
 * property values.
 ***********************************************************************************/ 
    public void deleteDB() {
        
        sql = "Delete from Order where OrderID = " + getOrderID();
        db.deleteDB(sql);
        
    }
       
/************************************************************************************
 * display, shows all property values. Requires 0 parameters. Prints the value of all
 * properties to the server log.
 ***********************************************************************************/ 
    public void display() {
        System.out.println("Displaying Order properties:\n Order ID number: " + getOrderID() + "\n Tire ID Number: " + getTireID() + "\n Total tires in order: " + getQuantity() + "\n Order Status: " + getStatus());
    }

    public static void main(String[] args) {
        String test_va = "1";
        Order test = new Order("7", "222", "10", "Processing");
        //test.selectDB(test_va);

        test.insertDB();
        //test.setQuantity("20");
        //test.updateDB();
        //test.deleteDB();
        test.display();
    }
}
