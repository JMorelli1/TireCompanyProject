/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Shipper.java (Project)                                                          *
  Editor: James Morelli Edit Date: 11/5/19                                         * 
 ***********************************************************************************/

package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Shipper {
    
    public String password;
    public String ShipperID;
    public String username;
    private String sql;
    private final DBAccess db = new DBAccess();
    
    public Shipper() {
        password = "";
        username = "";
        ShipperID = "";
    }
    
    public Shipper( String username, String ShipperID, String password) {
        this.password = password;
        this.username = username;
        this.ShipperID = ShipperID;
    }
    
/************************************************************************************
 * All get/set methods for Customer properties.
 ***********************************************************************************/
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String new_username) {
        this.username = new_username;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String new_password) {
        this.password = new_password;
    }
    
    public String getSID() {
        return this.ShipperID;
    }

    public void setSID(String new_shipperID) {
        this.ShipperID = new_shipperID;
    }

/************************************************************************************
 * selectDB, uses SELECT SQL to query database. Requires 1 String parameter. Queries
 * the Shipper table for entries whose username matches the
 * given parameter.
 * @param username
 ***********************************************************************************/ 
    public void selectDB(String username) {
        try {
            sql = "Select * from Shipper where Username = '" + username + "'";
            ResultSet resultSet = db.SelectDB(sql);

            resultSet.next();

            this.setSID(resultSet.getString("ShipperID"));
            this.setUsername(resultSet.getString("username"));
            this.setPassword(resultSet.getString("password"));

        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Shipper). " + e);
        }
    }
    
/************************************************************************************
 * insertDB, uses INSERT SQL to insert into Shipper table.
 ***********************************************************************************/  
    public void insertDB() {

        sql = "Insert into Shipper (ShipperID, Username, Password) VALUES ('" + this.getSID() + "', '" + this.getUsername() + "', '" + this.getPassword() + "')";
        System.out.println(sql);
        db.insertDB(sql);

    }
    
/************************************************************************************
 * updateDB, updates in the Shipper table with the properties of the shipper object
 ***********************************************************************************/  
    public void updateDB() {

        sql = "UPDATE Shipper set " + "Username='" + getUsername() + "'," + " Password='" + getPassword() + "' WHERE ShipperID= '" + this.getSID()+ "'";
        db.updateDB(sql);

    }
    
/************************************************************************************
 * deleteDB, deletes a row in the Shipper at the shipper object ID 
 ***********************************************************************************/  
    public void deleteDB() {

        sql = "Delete from Shipper where ShipperID = " + this.getSID();
        db.deleteDB(sql);

    }
    
    public void display() {
        System.out.println("Displaying Order properties. Order ID: " + this.getSID()+ ". Username: " + this.getUsername() + ". Password: " + this.getPassword() + ".");
    }
}
