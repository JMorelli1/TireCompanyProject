package Business;


import Business.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elijah Badger
 */
public class Shipper {
    public String password;
    public String ShipperID;
    public String username;
    private String sql;
    private final DBAccess db = new DBAccess();
    
    public Shipper() {
        String password = "";
        String username = "";
        String ShipperID = "";
    }
    
    public Shipper( String username, String ShipperID, String password) {
        this.password = password;
        this.username = username;
        this.ShipperID = ShipperID;
    }
    
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
    
    public void insertDB() {

        sql = "Insert into Shipper (ShipperID, Username, Password) VALUES ('" + this.getSID() + "', '" + this.getUsername() + "', '" + this.getPassword() + "')";
        System.out.println(sql);
        db.insertDB(sql);

    }
    
    public void updateDB() {

        sql = "UPDATE Shipper set " + "Username='" + getUsername() + "'," + " Password='" + getPassword() + "' WHERE ShipperID= '" + this.getSID()+ "'";
        db.updateDB(sql);

    }
    
    public void deleteDB() {

        sql = "Delete from Shipper where ShipperID = " + this.getSID();
        db.deleteDB(sql);

    }
    
    public void display() {
        System.out.println("Displaying Order properties. Order ID: " + this.getSID()+ ". Username: " + this.getUsername() + ". Password: " + this.getPassword() + ".");
    }
}
