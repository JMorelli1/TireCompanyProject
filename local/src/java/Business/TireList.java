/***********************************************************************************
  @author Elijah T. Badger                                                         *
  TireList.java (Project)                                                         *
  Editor: N/A Edit Date: N/A                                                       * 
 ***********************************************************************************/
package Business;

import java.util.ArrayList;

/************************************************************************************
 * TireList Class. Requires 0 parameters. Purpose: Hold a list of Tire
 * in an ArrayList for Customer class use. 
 ***********************************************************************************/
public class TireList {
    private int count;
    ArrayList<Tire> tire_list;
    
/************************************************************************************
 * TireList constructor, Initializes count property to 0 and tire_list property
 * to an ArrayList object.
 ***********************************************************************************/
    public TireList(){
         count = 0;
        tire_list = new ArrayList<>();   
    }

/************************************************************************************
 * AddItem adds item to ArayList. Requires 1 Tire object. Purpose: Add an Tire object
 * to the ArrayList and increase counter by 1.
 ***********************************************************************************/
   public void addItem(Tire a){
       tire_list.add(a);
       this.count++;
   }
   
/************************************************************************************
 * ListSize Method to return size of ArrayList. Requires 0 parameters. Purpose: Returns the value of the count
 * property.
 ***********************************************************************************/
   public int listSize(){
       return tire_list.size();
   }
   
 /************************************************************************************
 * getAcct Method to get item from ArrayList. Requires 1 int parameter. Purpose: Index the ArayList with the int
 * parameter and return the Tire object at the given index.
 ***********************************************************************************/
   public Tire getTire(int x){
       return tire_list.get(x);
   }
    
 /************************************************************************************
 * display Method to display contents of Tire objects. Requires 0 parameters. Purpose: Uses a for loop to call the display
 * method of each Tire object in the ArrayList and print the information to the
 * server log.
 ***********************************************************************************/
   public void display(){
       for (int x = 0; x < count; x++){
           Tire pointer = tire_list.get(x);
           pointer.display();
       }
   }
}
