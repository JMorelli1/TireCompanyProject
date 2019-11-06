/***********************************************************************************
  @author Elijah T. Badger                                                         *
  TireList.java (Project)                                                         *
  Editor: James Morelli Edit Date: 11/1/19                                                       * 
 ***********************************************************************************/
package Business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/************************************************************************************
 * TireList Class. Requires 0 parameters. Purpose: Hold a list of Tire
 * in an ArrayList for Customer class use. 
 ***********************************************************************************/
public class TireList {
    
    public ArrayList<Tire> tireList = new ArrayList<>();
    private DBAccess dbAccess = new DBAccess();
    private final String sql = "Select * From Tire";

/************************************************************************************
 * AddItem adds item to ArayList. Requires 1 Tire object. Purpose: Add an Tire object
 * to the ArrayList and increase counter by 1.
 * @param a
 ***********************************************************************************/
   public void addItem(Tire a){
       tireList.add(a);
   }
   
/************************************************************************************
 * removeItem removes a Tire from the tireList arraylist
 * @param a
 ***********************************************************************************/
   public void removeItem(Tire a){
       tireList.remove(a);
   }
   
/************************************************************************************
 * containsItem, Checks if the is the same Tire Object already in the arraylist
 * @return boolean
 * @param a
 ***********************************************************************************/
   public boolean containsItem(Tire a){
       return tireList.contains(a);
   }
   
/************************************************************************************
 * ListSize Method to return size of ArrayList. Requires 0 parameters. Purpose: Returns the value of the count
 * property.
 ***********************************************************************************/
   public int listSize(){
       return tireList.size();
   }
   
 /************************************************************************************
 * getTire Method to get item from ArrayList. Purpose: Index the ArayList with the int
 * parameter and return the Tire object at the given index
 * @return Tire
 * @param x
 ***********************************************************************************/
   public Tire getTire(int x){
       return tireList.get(x);
   }
    
 /************************************************************************************
 * display Method to display contents of Tire objects. Requires 0 parameters. Purpose: Uses a for loop to call the display
 * method of each Tire object in the ArrayList and print the information to the
 * server log.
 ***********************************************************************************/
   public void display(){
       for (int x = 0; x < tireList.size(); x++){
           Tire pointer = tireList.get(x);
           pointer.display();
       }
   }
   
/************************************************************************************
 * generateTireList, creates a TireList of all Tires within the Tire Table
 * @return TireList
 ***********************************************************************************/
   public TireList generateTireList(){
       
       TireList listOfTires = new TireList();
       Tire tire;
       ResultSet resultSet;
       
       resultSet = dbAccess.SelectDB(sql);
       try{
           while(resultSet.next()){
            tire = new Tire();
            
            tire.setStockID(resultSet.getString("TireID"));
            tire.setType(resultSet.getString("TireType"));
            tire.setSize(resultSet.getString("TireSize"));
            tire.setBrand(resultSet.getString("Brand"));
            tire.setStock(resultSet.getString("Stock"));
            tire.setPrice(resultSet.getString("Price"));
            tire.setVehicleType(resultSet.getString("VehicleType"));
            
            listOfTires.addItem(tire);
           }
       }
       catch(SQLException e){
           System.out.println("Error generating list of tires: " + e);
       }
       return listOfTires;
   }
}
