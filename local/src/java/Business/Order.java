/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Order.java (Project)                                                             *
  Editor: James Morelli Edit Date: 11/5/19                                                       * 
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
    private String customerID;
    private String status;
    private String sql;
    private int quantity;
    private int newID;
    private final DBAccess db = new DBAccess();
    public TireList orderedItems = new TireList();
    public OrderList ordersList = new OrderList();

    
 /************************************************************************************
 * Order constructor, Initializes all properties to "" when 0 
 * parameters are given.
 ***********************************************************************************/    
    public Order() {
        orderID = "";
        customerID = "";
        status = "";
    }

/************************************************************************************
 * Order constructor, Initializes properties to given values.
 ***********************************************************************************/ 
    public Order(String orderID, String tireID, String status) {
        this.orderID = orderID;
        this.customerID = tireID;
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

    public String getCustomerID() {
        return this.customerID;
    }

    public void setCustomerID(String new_TID) {
        this.customerID = new_TID;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String new_status) {
        this.status = new_status;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
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
            setCustomerID(resultSet.getString("CustomerID"));
            setStatus(resultSet.getString("Status"));

        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Order). " + e);
        }
    }

 /************************************************************************************
 * insertNewOrderDB, Inserts data into the Order table of a new order being ordered by a customer 
 * It creates the orderId by generating a count of current orders and adding to it
 * @param customerID
 * @param status
 ***********************************************************************************/ 
    public void insertNewOrderDB(String customerID, String status) {
        newID = countOrders() + 1;
        sql = "Insert into Order (OrderID, CustomerID, Status) VALUES ('"+newID+"','"+customerID+"', '"+status+"')";
        System.out.println(sql + "\n" + newID);
        db.insertDB(sql);
            
    }
    
 /************************************************************************************
 * insertOrderedItems, Inserts data into the OrderedItems Table in the database based on a Tirelist sent to the method
 * Also adds the quantity ordered
 * @param orderedItems
 * @param quantity
 ***********************************************************************************/ 
    public void insertOrderedItems(TireList orderedItems){
        for(int i=0; i<orderedItems.listSize(); i++){
                    sql="Insert into OrderedItems (OrderID, TireID, Quantity) VALUES ('"+newID+"','"+orderedItems.getTire(i).getStockID()+"',"+orderedItems.getTire(i).getQuantity()+")";
                    db.insertDB(sql);            
        }
    }
    
 /************************************************************************************
 * findOrderedItems, Makes a list of tires found in the Tire table using the TireID found
 * in the OrderedItems table and then returns the TireList
 * @return TireList
 ***********************************************************************************/ 
    public TireList findOrderedItems(){
        
        try{
            sql = "Select * From OrderedItems Where OrderID = " + getOrderID();
            ResultSet resultSetOrder = db.SelectDB(sql);
            
            Tire orderedTire;
            while(resultSetOrder.next()){
                orderedTire = new Tire();
                orderedTire.setQuantity(resultSetOrder.getInt("Quantity"));
                ResultSet resultSetTire = db.SelectDB("Select * From Tire Where TireID = " + resultSetOrder.getString("TireID"));
                while(resultSetTire.next()){
                    orderedTire.setStockID(resultSetTire.getString("TireID"));
                    orderedTire.setType(resultSetTire.getString("TireType"));
                    orderedTire.setSize(resultSetTire.getString("TireSize"));
                    orderedTire.setBrand(resultSetTire.getString("Brand"));
                    orderedTire.setStock(resultSetTire.getString("Stock"));
                    orderedTire.setPrice(resultSetTire.getString("Price"));
                    orderedTire.setVehicleType(resultSetTire.getString("VehicleType"));
                    orderedItems.addItem(orderedTire);
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error generating list of Orders: " + e);
        }
        return orderedItems;
    }
    
 /************************************************************************************
 * findOrders, Collects a list of all orders found in the order table and returns the list
 * for display
 * @return OrderList
 ***********************************************************************************/ 
    
    public OrderList findOrders(){
        sql="SELECT * FROM Order";
        Order order;
        try{
            ResultSet resultSet = db.SelectDB(sql);
            
            while(resultSet.next()){
                order = new Order();
                order.setOrderID(resultSet.getString("OrderID"));
                order.setCustomerID(resultSet.getString("CustomerID"));
                order.setStatus(resultSet.getString("Status"));
                ordersList.addItem(order);
            }
        }
        catch(SQLException e){
            System.out.println("Crash finding all orders" + e);
        }
        return ordersList;
    }
    
 /************************************************************************************
 * insertDB, uses INSERT SQL to insert into database. Requires 4 String parameters.
 * Inserts the given parameters into the Order table of the 
 * database. 
 ***********************************************************************************/ 
    public void insertDB() {
        sql = "Insert into Order (OrderID, CustomerID, Status) VALUES ('"+getCustomerID()+"','"+getCustomerID()+"', '"+getStatus()+"')";
        db.insertDB(sql);
            
    }

/************************************************************************************
 * updateDB, uses UPDATE SQL to update database. Requires 0 parameters. Updates from the
 * Order table in  based on the current values of class 
 * properties.
 ***********************************************************************************/ 
    public void updateDB() {
        
        sql = "UPDATE Order set " + "CustomerID='"+getCustomerID()+"'," + " Status='"+getStatus()+"'" + " WHERE OrderID= '" + getOrderID()+"'";
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
 * countOrders, counts all orders currently in the database to add a unique OrderId when created
 * @return int
 ***********************************************************************************/ 
    public int countOrders(){
        int count = 0;
        sql = "SELECT * FROM Order";
        ResultSet rs = db.SelectDB(sql);
        try{
            while(rs.next()){
                count++;
            }
        }
        catch(SQLException e){
            System.out.println("Crash at countOrders method (for Order). " + e);
        }
        return count;
    }
       
/************************************************************************************
 * display, shows all property values. Requires 0 parameters. Prints the value of all
 * properties to the server log.
 ***********************************************************************************/ 
    public void display() {
        System.out.println("Displaying Order properties:\n Order ID number: " + getOrderID() + "\n Customer ID Number: " + getCustomerID() + "\n Order Status: " + getStatus());
    }
}
