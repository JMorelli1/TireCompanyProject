/***********************************************************************************
  @author Elijah T. Badger                                                         *
  OrderList.java (Project)                                                         *
  Editor: N/A Edit Date: N/A                                                       * 
 ***********************************************************************************/
package Business;

import java.util.ArrayList;

/************************************************************************************
 * OrderList Class. Requires 0 parameters. Purpose: Hold a list of Order
 * in an ArrayList for Customer class use. 
 ***********************************************************************************/
public class OrderList {
    private int count;
    ArrayList<Order> order_list;
    
/************************************************************************************
 * ORderList constructor, Initializes count property to 0 and order_list property
 * to an ArrayList object.
 ***********************************************************************************/
    public OrderList(){
         count = 0;
        order_list = new ArrayList<>();   
    }

/************************************************************************************
 * AddItem adds item to ArayList. Requires 1 Order object. Purpose: Add an ORder object
 * to the ArrayList and increase counter by 1.
 ***********************************************************************************/
   public void addItem(Order a){
       order_list.add(a);
       this.count++;
   }
   
/************************************************************************************
 * ListSize Method to return size of ArrayList. Requires 0 parameters. Purpose: Returns the value of the count
 * property.
 ***********************************************************************************/
   public int listSize(){
       return order_list.size();
   }
   
 /************************************************************************************
 * getAcct Method to get item from ArrayList. Requires 1 int parameter. Purpose: Index the ArayList with the int
 * parameter and return the Order object at the given index.
 ***********************************************************************************/
   public Order getOrder(int x){
       return order_list.get(x);
   }
    
 /************************************************************************************
 * display Method to display contents of Order objects. Requires 0 parameters. Purpose: Uses a for loop to call the display
 * method of each ORder object in the ArrayList and print the information to the
 * server log.
 ***********************************************************************************/
   public void display(){
       for (int x = 0; x < count; x++){
           Order pointer = order_list.get(x);
           pointer.display();
       }
   }
}
