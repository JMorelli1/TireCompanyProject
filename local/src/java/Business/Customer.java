/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Customer.java (Project)                                                          *
  Editor: James Morelli Edit Date: 9/25/19                                         * 
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
    private String orderID;
    private String sql;
    private final DBAccess db = new DBAccess();
    
    //public String listOfOrders;

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
        orderID = "";
    }
    
/************************************************************************************
 * Dentist constructor, Initializes properties to given values.
 ***********************************************************************************/ 
    public Customer(String fname, String lname, String username, String password, String ID, String address, String phone, String creditCardInfo, String expireDate, String securityCode, String orderID) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.ID = ID;
        this.address = address;
        this.phone = phone;
        this.creditCardInfo = creditCardInfo;
        this.expireDate = expireDate;
        this.orderID = orderID;
    }
    

/************************************************************************************
 * All get/set methods for Customer properties.
 ***********************************************************************************/
    public void setOID(String new_oid) {
        this.orderID = new_oid;
    }

    public String getOID() {
        return this.orderID;
    }

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
    }
 
/************************************************************************************
 * selectDB, uses SELECT SQL to query database. Requires 1 String parameter. Queries
 * the Customer table for entries whose id key matches the
 * given parameter.
 * @param custID
 ***********************************************************************************/    
    public void selectCustomer(String custID) {
        try {
            
            sql = "Select * from Customer where CustomerID = '" + ID + "'";
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
            setOID(resultSet.getString("OrderID"));

        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Admin). " + e);
            System.out.println(" ");
        }
    }

/************************************************************************************
 * insertDB, uses INSERT SQL to insert into database. Requires 11 String parameters.
 * Inserts the given parameters into the Customer table of the 
 * database. 
 ***********************************************************************************/  
    public void insertDB() {
        
        sql = "Insert into Customer (CustomerID, Username, Password, FirstName, LastName, Address, PhoneNumber, CreditCardNumber, ExpirationDate, SecurityCode, OrderID) VALUES ('" +getID()+ "', '" +getUsername()+ "', '" +getPassword()+ "', '"+getFN()+ "', '" +getLN()+ "', '" +getAddress()+ "', '" +getPhone()+ "', '" +getCreditCardInfo()+ "', '" +getExpireDate()+ "', '" +getSecurityCode()+ "', '" +getOID()+ "')";
        db.InsertDB(sql);
    }

/************************************************************************************
 * updateDB, uses UPDATE SQL to update database. Requires 0 parameters. Updates from the
 * Customer table in  based on the current values of class 
 * properties.
 ***********************************************************************************/ 
    public void updateDB() {
        
        sql = "UPDATE Customer set " + "Username='"+getUsername()+"'," + " Password='"+getPassword()+"'," + " FirstName='"+getFN()+"'," + " LastName='"+getLN()+"'," + " Address='"+getAddress()+"'," + " PhoneNumber='"+getPhone()+"'," + " CreditCardNumber='"+getCreditCardInfo()+"'," + " ExpirationDate='"+getExpireDate()+"'," + " SecurityCode='"+getSecurityCode()+"'," + " OrderID='"+getOID()+"'," + " WHERE CustomerID= '" + getCID()+"'";
        db.updateDB(sql);
        
    }

/************************************************************************************
 * deleteDB, uses DELETE SQL to delete from database. Requires 0 parameters. Deletes
 * an entry from the Customer Table based on current class
 * property values.
 ***********************************************************************************/ 
    public void deleteDB() {
        sql = "Delete from Customer where CustomerID = " + getCID();
        db.deleteDB(sql);
        
    }

    public static void main(String[] args) {
        String test_va = "1";
        Customer test = new Customer();
        //test.selectDB(test_va);

        //test.display();
        //test.insertDB("9", "385", "4", "Processing");
        //test.setPrice("3001");
        //test.updateDB();
        //test.deleteDB();
    }

}
