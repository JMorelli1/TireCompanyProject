/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Customer.java (Project)                                                          *
  Editor: James Morelli Edit Date: 11/5/19                                         * 
 ***********************************************************************************/
package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

/************************************************************************************
 * Customer Class. Requires 0 or 11 parameters. Purpose: Complete database tasks
 * and hold relevant values from database in class property fields. 
 ***********************************************************************************/
public class Customer {

    private String fname;
    private String lname;
    private String username;
    private String password;
    private String ID;
    private String address;
    private String phone;
    private String creditCardInfo;
    private String expireDate;
    private String securityCode;
    private String sql;
    private final DBAccess db = new DBAccess();
    public OrderList orderList;

 /************************************************************************************
 * Customer constructor, Initializes all properties to "" when 0 
 * parameters are given.
 ***********************************************************************************/   
    
    public Customer() {
        username = "";
        password = "";
        ID = "";
        address = "";
        phone = "";
        creditCardInfo = "";
        expireDate = "";
        securityCode = "";
    }
    
/************************************************************************************
 * Customer constructor, Initializes properties to given values.
 ***********************************************************************************/ 
    public Customer(String ID, String username, String password, String fname, String lname, String address, String phone, String creditCardInfo, String expireDate, String securityCode) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.ID = ID;
        this.address = address;
        this.phone = phone;
        this.creditCardInfo = creditCardInfo;
        this.expireDate = expireDate;
        this.securityCode = securityCode;
    }
    

/************************************************************************************
 * All get/set methods for Customer properties.
 ***********************************************************************************/
    public void setCID(String new_ID) {
        this.ID = new_ID;
    }

    public String getCID() {
        return this.ID;
    }

    public void setFN(String new_name) {
        this.fname = new_name;
    }

    public String getFN() {
        return this.fname;
    }

    public void setLN(String new_lname) {
        this.lname = new_lname;
    }

    public String getLN() {
        return this.lname;
    }

    public void setUsername(String new_username) {
        this.username = new_username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String new_password) {
        this.password = new_password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setID(String new_ID) {
        this.ID = new_ID;
    }

    public String getID() {
        return this.ID;
    }

    public void setAddress(String new_address) {
        this.address = new_address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setPhone(String new_phone) {
        this.phone = new_phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setCreditCardInfo(String new_creditCardInfo) {
        this.creditCardInfo = new_creditCardInfo;
    }

    public String getCreditCardInfo() {
        return this.creditCardInfo;
    }

    public void setExpireDate(String new_date) {
        this.expireDate = new_date;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public void setSecurityCode(String new_code) {
        this.securityCode = new_code;
    }

    public String getSecurityCode() {
        return this.securityCode;
    }
/************************************************************************************
 * display, shows all property values. Requires 0 parameters. Prints the value of all
 * properties to the server log.
 ***********************************************************************************/  
    public void display() {
        System.out.println("Displaying Customer properties:\n Name: " + getFN() + " " + getLN() + "\n Username: " + getUsername() + "\n Password: " + getPassword() + "\n ID:" + getID() + "\n Address: " + getAddress() + "\n Phone number: " + getPhone() + "\n Card number: " + getCreditCardInfo() + "\n Expiration: " + getExpireDate() + "\n Security Code: " + getSecurityCode());
        orderList.display();
    }
 
/************************************************************************************
 * selectCustomer, uses SELECT SQL to query database. Requires 1 String parameter. Queries
 * the Customer table for entries whose id key matches the
 * given parameter.
 * @param custID
 ***********************************************************************************/    
    public void selectCustomer(String custID) {
        try {
            
            sql = "Select * from Customer where CustomerID = '" + custID + "'";
            ResultSet resultSet = db.SelectDB(sql);
            
            resultSet.next();

            setID(resultSet.getString("CustomerID"));
            setUsername(resultSet.getString("Username"));
            setPassword(resultSet.getString("Password"));
            setFN(resultSet.getString("FirstName"));
            setLN(resultSet.getString("LastName"));
            setAddress(resultSet.getString("Address"));
            setPhone(resultSet.getString("PhoneNumber"));
            setCreditCardInfo(resultSet.getString("CreditCardNumber"));
            setExpireDate(resultSet.getString("ExpirationDate"));
            setSecurityCode(resultSet.getString("SecurityCode"));

            findOrders();
        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Admin). " + e);
            System.out.println(" ");
        }
    }
    
    /************************************************************************************
 * selectCustomerUsername, uses SELECT SQL to query database. Requires 1 String parameter. Queries
 * the Customer table for entries whose username key matches the
 * given parameter.
 * @param custUsername
 ***********************************************************************************/    
    
        public void selectCustomerUsername(String custUsername) {
        try {
            
            sql = "SELECT * FROM Customer WHERE Username = '" + custUsername + "'";
            ResultSet resultSet = db.SelectDB(sql);
            
            resultSet.next();

            setID(resultSet.getString("CustomerID"));
            setUsername(resultSet.getString("Username"));
            setPassword(resultSet.getString("Password"));
            setFN(resultSet.getString("FirstName"));
            setLN(resultSet.getString("LastName"));
            setAddress(resultSet.getString("Address"));
            setPhone(resultSet.getString("PhoneNumber"));
            setCreditCardInfo(resultSet.getString("CreditCardNumber"));
            setExpireDate(resultSet.getString("ExpirationDate"));
            setSecurityCode(resultSet.getString("SecurityCode"));

            findOrders();
        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Admin). " + e);
            System.out.println(" ");
        }
    }

/************************************************************************************
 * insertCustomer, uses INSERT SQL to insert into database. Requires 11 String parameters.
 * Inserts the given parameters into the Customer table of the 
 * database. 
 ***********************************************************************************/  
    public void insertCustomer() {
        
        sql = "Insert into Customer (CustomerID, Username, Password, FirstName, LastName, Address, PhoneNumber, CreditCardNumber, ExpirationDate, SecurityCode) VALUES ('" +getID()+ "', '" +getUsername()+ "', '" +getPassword()+ "', '"+getFN()+ "', '" +getLN()+ "', '" +getAddress()+ "', '" +getPhone()+ "', '" +getCreditCardInfo()+ "', '" +getExpireDate()+ "', '" +getSecurityCode()+"')";
        db.insertDB(sql);
    }

/************************************************************************************
 * updateCustomer, uses UPDATE SQL to update database. Requires 0 parameters. Updates from the
 * Customer table in  based on the current values of class 
 * properties.
 ***********************************************************************************/ 
    public void updateCustomer() {
        
        sql = "UPDATE Customer set " + "Username='"+getUsername()+"'," + " Password='"+getPassword()+"'," + " FirstName='"+getFN()+"'," + " LastName='"+getLN()+"'," + " Address='"+getAddress()+"'," + " PhoneNumber='"+getPhone()+"'," + " CreditCardNumber='"+getCreditCardInfo()+"'," + " ExpirationDate='"+getExpireDate()+"'," + " SecurityCode='"+getSecurityCode()+"'" + " WHERE CustomerID= '" + getCID()+"'";
        db.updateDB(sql);
        
    }

/************************************************************************************
 * deleteCustomer, uses DELETE SQL to delete from database. Requires 0 parameters. Deletes
 * an entry from the Customer Table based on current class
 * property values.
 ***********************************************************************************/ 
    public void deleteCustomer() {
        sql = "Delete from Customer where CustomerID = " + getCID();
        db.deleteDB(sql);
        
    }
/************************************************************************************
 * countCustomers, generates a count of the current number of Customers in the Customer Table
 * in order to give a unique ID to new Customers
 * @return int
 ***********************************************************************************/
    public int countCustomers(){
        int count = 0;
        sql = "SELECT * FROM Customer";
        try{
        ResultSet resultset = db.SelectDB(sql);
        while(resultset.next()){
            count++;
        }
        }catch(SQLException e){
            System.out.println("Error counting customers");
        }
        return count;
    }

/************************************************************************************
 * findOrders, creates an orderList of orders tied to the Customer ID
 ***********************************************************************************/
    public void findOrders(){
        
        try{
            orderList = new OrderList();
            sql = "Select * From Order Where CustomerID = " + getCID();
            ResultSet resultSet = db.SelectDB(sql);
            
            Order order;
            if(resultSet != null){
            while(resultSet.next()){
                order = new Order();
                order.setOrderID(resultSet.getString("OrderID"));
                order.setCustomerID(resultSet.getString("CustomerID"));
                order.setStatus(resultSet.getString("Status"));
                orderList.addItem(order);
            }
            }
        }
        catch(SQLException e){
            System.out.println("Error generating list of Orders: " + e);
        }
        
    }
}
