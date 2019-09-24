/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Tire.java (Project)                                                              *
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
 * Tire Class. Requires 0 or 7 parameters. Purpose: Complete database tasks
 * and hold relevant values from database in class property fields. 
 ***********************************************************************************/
public class Tire {

    public String type;
    public String brand;
    public String stock;
    public String price;
    public String tireSize;
    public String stockID;
    public String vechicleType;

 /************************************************************************************
 * Tire constructor, Initializes all properties to "" when 0 
 * parameters are given.
 ***********************************************************************************/    
    public Tire() {
        String type = "";
        String brand = "";
        String stock = "";
        String price = "";
        String stockID = "";
        String tireSize = "";
        String vechicleType = "";
    }

/************************************************************************************
 * Tire constructor, Initializes properties to given values.
 ***********************************************************************************/ 
    public Tire(String type, String brand, String stock, String price, String tireSize, String stockID, String vehicleType) {
        this.type = type;
        this.brand = brand;
        this.stock = stock;
        this.price = price;
        this.tireSize = tireSize;
        this.stockID = stockID;
        this.vechicleType = vehicleType;
    }

/************************************************************************************
 * All get/set methods for Tire properties.
 ***********************************************************************************/  
    public String getType() {
        return this.type;
    }

    public void setType(String new_type) {
        this.type = new_type;
    }

    public String getSize() {
        return this.tireSize;
    }

    public void setSize(String new_size) {
        this.tireSize = new_size;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String new_brand) {
        this.brand = new_brand;
    }

    public String getStock() {
        return this.stock;
    }

    public void setStock(String new_stock) {
        this.stock = new_stock;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String new_price) {
        this.price = new_price;
    }

    public String getStockID() {
        return this.stockID;
    }

    public void setStockID(String new_stockID) {
        this.stockID = new_stockID;
    }

    public String getVechicleType() {
        return this.vechicleType;
    }

    public void setVechicleType(String new_vType) {
        this.vechicleType = new_vType;
    }

/************************************************************************************
 * display, shows all property values. Requires 0 parameters. Prints the value of all
 * properties to the server log.
 ***********************************************************************************/ 
    public void display() {
        System.out.println("Displaying Tire properties. Type: " + this.getType() + ". Brand: " + this.getBrand() + ". Stock: " + this.getStock() + ". Pricing: " + this.getPrice()
                + ". Size: " + this.getSize() + ". Stock ID: " + this.getStockID() + ". Car type: " + this.getVechicleType() + ".");
    }
/************************************************************************************
 * selectDB, uses SELECT SQL to query database. Requires 1 String parameter. Queries
 * the Tire table for entries whose id key matches the
 * given parameter.
 ***********************************************************************************/
    public void selectDB(String tireID) {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at select (for Tire).");
            Statement statement = con.createStatement();
            String sql = "Select * from Tire where tireID = '" + tireID + "'";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Result set compiled (for Tire).");
            rs.next();

            this.setType(rs.getString("TireID"));
            System.out.println("results from 1: " + rs.getString(1));
            this.setType(rs.getString("TireType"));
            System.out.println("results from 2: " + rs.getString(2));
            this.setSize(rs.getString("TireSize"));
            System.out.println("results from 3: " + rs.getString(3));
            this.setBrand(rs.getString("Brand"));
            System.out.println("results from 4: " + rs.getString(4));
            this.setStock(rs.getString("Stock"));
            System.out.println("results from 5: " + rs.getString(5));
            this.setPrice(rs.getString("Price"));
            System.out.println("results from 6: " + rs.getString(6));
            this.setVechicleType(rs.getString("VehicleType"));
            System.out.println("results from 7: " + rs.getString(7));
            System.out.println("Selections completed...");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Tire). " + e);
            System.out.println(" ");
        }
    }

/************************************************************************************
 * insertDB, uses INSERT SQL to insert into database. Requires 4 String parameters.
 * Inserts the given parameters into the Tire table of the 
 * database. 
 ***********************************************************************************/ 
    public void insertDB(String TireID, String type, String size, String brand, String stock, String price, String vType) {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at insert (for Tire).");
            Statement statement = con.createStatement();
            String sql = "Insert into Tire (TireID, TireType, TireSize, Brand, Stock, Price, VehicleType) VALUES ('" + TireID + "', '" + type + "', '" + size + "', '" + brand + "', '" + stock + "', '" + price + "', '" + vType + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("Insert completed.");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at insertDB method (for Tire). " + e);
            System.out.println(" ");
        }
    }

/************************************************************************************
 * updateDB, uses UPDATE SQL to update database. Requires 0 parameters. Updates from the
 * Tire table in  based on the current values of class 
 * properties.
 ***********************************************************************************/ 
    public void updateDB() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at update (for Tire).");
            Statement statement = con.createStatement();
            PreparedStatement ps = con.prepareStatement("UPDATE Tire SET TireType = ?, TireSize = ?, Brand = ?, Stock = ?, Price = ?, VehicleType = ? WHERE TireID = ?");
            ps.setString(1, this.getType());
            ps.setString(2, this.getSize());
            ps.setString(3, this.getBrand());
            ps.setString(4, this.getStock());
            ps.setString(5, this.getPrice());
            ps.setString(6, this.getVechicleType());
            ps.setString(7, this.getStockID());
            System.out.println("Prepped statement compelted.");
            System.out.println(" ");
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at updateDB method. " + e);
            System.out.println(" ");
        }
    }
/************************************************************************************
 * deleteDB, uses DELETE SQL to delete from database. Requires 0 parameters. Deletes
 * an entry from the Tire Table based on current class
 * property values.
 ***********************************************************************************/ 
    public void deleteDB() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at delete (for Tire).");
            Statement statement = con.createStatement();
            String sql = "Delete from Tire where TireID = " + this.getStockID();
            statement.executeUpdate(sql);
            System.out.println("Deletion completed.");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at updateDB method (for Tire). " + e);
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        String test_va = "411";
        Tire test = new Tire();
        test.selectDB(test_va);

        test.display();
        //test.insertDB("411", "All Season", "185/50-R9001", "TiresRUs", "9001", "360","Autobot");
        test.setPrice("3001");
        test.updateDB();
        test.deleteDB();
    }
}
