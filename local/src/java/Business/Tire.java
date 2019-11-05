/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Tire.java (Project)                                                              *
  Editor: James Morelli Edit Date: 9/25/19                                                       * 
 ***********************************************************************************/
package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

/************************************************************************************
 * Tire Class. Requires 0 or 7 parameters. Purpose: Complete database tasks
 * and hold relevant values from database in class property fields. 
 ***********************************************************************************/
public class Tire {

    private String type;
    private String brand;
    private String stock;
    private String price;
    private String tireSize;
    private String stockID;
    private String vehicleType;
    private String sql;
    private int quantity;
    private final DBAccess db = new DBAccess();
    

 /************************************************************************************
 * Tire constructor, Initializes all properties to "" when 0 
 * parameters are given.
 ***********************************************************************************/    
    public Tire() {
        type = "";
        brand = "";
        stock = "";
        price = "";
        stockID = "";
        tireSize = "";
        vehicleType = "";
        quantity = 0;
    }

/************************************************************************************
 * Tire constructor, Initializes properties to given values.
 * @param stockID
 * @param type
 * @param brand
 * @param stock
 * @param price
 * @param tireSize
 * @param vehicleType
 ***********************************************************************************/ 
    public Tire(String stockID, String type, String tireSize, String brand, String stock, String price, String vehicleType) {
        this.type = type;
        this.brand = brand;
        this.stock = stock;
        this.price = price;
        this.tireSize = tireSize;
        this.stockID = stockID;
        this.vehicleType = vehicleType;
        quantity = 0;
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

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String new_vType) {
        this.vehicleType = new_vType;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

/************************************************************************************
 * display, shows all property values. Requires 0 parameters. Prints the value of all
 * properties to the server log.
 ***********************************************************************************/ 
    public void display() {
        System.out.println("Displaying Tire properties:\n Stock ID: " + this.getStockID() + "\n Type: " + this.getType() + "\n Brand: " + this.getBrand() + "\n Stock: " + this.getStock() + "\n Pricing: " + this.getPrice()
                + "\n Size: " + this.getSize() + "\n Stock ID: " + this.getStockID() + "\n Car type: " + this.getVehicleType() + ".");
    }
/************************************************************************************
 * selectDB, uses SELECT SQL to query database. Requires 1 String parameter. Queries
 * the Tire table for entries whose id key matches the
 * given parameter.
 * @param tireID
 ***********************************************************************************/
    
    public void selectTire(String tireID){
        
        sql = "SELECT * FROM Tire WHERE TireID = " + tireID;
        ResultSet resultSet = db.SelectDB(sql);
        
        try{
            resultSet.next();
            
            setStockID(resultSet.getString("TireID"));
            setType(resultSet.getString("TireType"));
            setSize(resultSet.getString("TireSize"));
            setBrand(resultSet.getString("Brand"));
            setStock(resultSet.getString("Stock"));
            setPrice(resultSet.getString("Price"));
            setVehicleType(resultSet.getString("VehicleType"));
        }
        catch(SQLException e){
            System.out.println("Error with Tire DB Select Method: " + e);
        }
        
    }

/************************************************************************************
 * insertDB, uses INSERT SQL to insert into database. 
 * Inserts the given parameters into the Tire table of the 
 * database. 
 ***********************************************************************************/ 
    public void insertTire() {
        
        sql = "Insert into Tire (TireID, TireType, TireSize, Brand, Stock, Price, VehicleType) VALUES ('"+getStockID()+"', '" +getType()+ "', '" +getSize()+ "', '" +getBrand()+ "', '" +getStock()+ "', '" +getPrice()+ "', '" +getVehicleType()+ "')";
        db.insertDB(sql);
        
    }

/************************************************************************************
 * updateDB, uses UPDATE SQL to update database. Updates from the
 * Tire table in  based on the current values of class 
 * properties.
 ***********************************************************************************/ 
    public void updateTire() {        
        
        sql = "UPDATE Tire set " + "TireType='"+getType()+"'," + " TireSize='"+getSize()+"'," + " Brand='"+getBrand()+"'," + " Stock='"+getStock()+"'," + " Price='"+getPrice()+"'," + " VehicleType='"+getVehicleType()+"'" + " WHERE TireID= '" + getStockID()+"'";
        db.updateDB(sql);
    }
/************************************************************************************
 * deleteDB, uses DELETE SQL to delete from database. Deletes
 * an row from the Tire Table based on current class
 * property values.
 ***********************************************************************************/ 
    public void deleteTire() {
        
            sql = "Delete from Tire where TireID = '" + getStockID() + "'";
            db.deleteDB(sql);
    }

    public static void main(String[] args) {
        String test_va = "Select * From Tire";
        String testChanged = "Select * From Tire Where Brand IN ('Firestone')";
        Tire test = new Tire();
        //Tire test = new Tire("412", "Passenger", "123/60-R15", "Kumho", "12", "71.00", "Jeep");
        //test.selectTire(test_va);
        //test.insertDB();

        //test.display();
        //test.insertDB("411", "All Season", "185/50-R9001", "TiresRUs", "9001", "360","Autobot");
        test.selectTire("245");
        test.setPrice("50");
        test.updateTire();
        //test.deleteDB();  
    }
}
