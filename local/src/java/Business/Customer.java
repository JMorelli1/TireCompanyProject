/** *********************************************************************************
 * @author Elijah T. Badger                                                         *
 * Customer.java (Project)                                                          *
 * Editor: N/A Edit Date: N/A                                                       *
 ********************************************************************************** */
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * **********************************************************************************
 * Customer Class. Requires 0 or 11 parameters. Purpose: Complete database tasks
 * and hold relevant values from database in class property fields. 
 **********************************************************************************
 */
public class Customer {

    public String fname;
    public String lname;
    public String username;
    public String password;
    public String ID;
    public String address;
    public String phone;
    public String creditCardInfo;
    public String expireDate;
    public String securityCode;
    public String orderID;
    private String sql;
    private final DBAccess db = new DBAccess();
    private OrderList orderList = new OrderList();

    /**
     * **********************************************************************************
     * Customer constructor, Initializes all properties to "" when 0 parameters
     * are given.
 **********************************************************************************
     */
    public Customer() {
        String username = "";
        String password = "";
        String ID = "";
        String address = "";
        String phone = "";
        String creditCardInfo = "";
        String expireDate = "";
        String securityCode = "";
        String orderID = "";
        String fname = "";
        String lname = "";
    }

    /**
     * **********************************************************************************
     * Dentist constructor, Initializes properties to given values.
 **********************************************************************************
     */
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

    /**
     * **********************************************************************************
     * All get/set methods for Customer properties.
 **********************************************************************************
     */
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

    public OrderList getOrderList() {
        return this.orderList;
    }

    /**
     * **********************************************************************************
     * display, shows all property values. Requires 0 parameters. Prints the
     * value of all properties to the server log.
 **********************************************************************************
     */
    public void display() {
        System.out.println("Displaying Customer properties. Name: " + this.getFN() + " " + this.getLN() + ". Username: " + this.getUsername() + ". Password: " + this.getPassword() + ". ID:" + this.getCID() + ". Address: " + this.getAddress() + ". Phone number: " + this.getPhone() + ". Card number: " + this.getCreditCardInfo() + " " + this.getExpireDate() + " " + this.getSecurityCode() + ".");
    }

    /**
     * **********************************************************************************
     * selectDB, uses SELECT SQL to query database. Requires 1 String parameter.
     * Queries the Customer table for entries whose id key matches the given
     * parameter.
 **********************************************************************************
     */
    public void selectDB(String custID) {
        try {

            //sql = "Select * from Customer where CustomerID = '" + custID + "'";
            sql = "Select * from Customer where username = '" + custID + "'";
            ResultSet resultSet = db.SelectDB(sql);

            resultSet.next();

            setCID(resultSet.getString("CustomerID"));
            System.out.println("CustomerID passed."); //Test code. Remove from final product.
            setUsername(resultSet.getString("Username"));
            System.out.println("Username passed"); //Test code. Remove from final product.
            setPassword(resultSet.getString("Password"));
            System.out.println("Password passed"); //Test code. Remove from final product.
            setFN(resultSet.getString("FirstName"));
            System.out.println("First name passed"); //Test code. Remove from final product.
            setLN(resultSet.getString("LastName"));
            System.out.println("Last name passed"); //Test code. Remove from final product.
            setAddress(resultSet.getString("Address"));
            System.out.println("Address passed"); //Test code. Remove from final product.
            setPhone(resultSet.getString("PhoneNumber"));
            System.out.println("Phone number passed"); //Test code. Remove from final product.
            setCreditCardInfo(resultSet.getString("CreditCardNumber"));
            System.out.println("card info passed"); //Test code. Remove from final product.
            setExpireDate(resultSet.getString("ExpirationDate"));
            System.out.println("exp date passed"); //Test code. Remove from final product.
            setSecurityCode(resultSet.getString("SecurityCode"));
            System.out.println("sec code passed"); //Test code. Remove from final product.
            //setOID(resultSet.getString("OrderID"));

            findOrders();
        } catch (SQLException e) {
            System.out.println("Crash at selectDB method (for Customer). " + e);
            System.out.println(" ");
        }
    }

    /**
     * **********************************************************************************
     * insertDB, uses INSERT SQL to insert into database. Requires 11 String
     * parameters. Inserts the given parameters into the Customer table of the
     * database. 
 **********************************************************************************
     */
    public void insertDB() {

        sql = "Insert into Customer (CustomerID, Username, Password, FirstName, LastName, Address, PhoneNumber, CreditCardNumber, ExpirationDate, SecurityCode) VALUES ('" + getCID() + "', '" + getUsername() + "', '" + getPassword() + "', '" + getFN() + "', '" + getLN() + "', '" + getAddress() + "', '" + getPhone() + "', '" + getCreditCardInfo() + "', '" + getExpireDate() + "', '" + getSecurityCode() + "')";
        db.InsertDB(sql);
    }

    /**
     * **********************************************************************************
     * updateDB, uses UPDATE SQL to update database. Requires 0 parameters.
     * Updates from the Customer table in based on the current values of class
     * properties.
 **********************************************************************************
     */
    public void updateDB() {
        System.out.println("Attmpting an update (in Customer)...."); //Test code. Remove from final product.
        sql = "UPDATE Customer set " + "Username='" + this.getUsername() + "'," + " Password='" + this.getPassword() + "'," + " FirstName='" + this.getFN() + "'," + " LastName='" + this.getLN() + "'," + " Address='" + this.getAddress() + "'," + " PhoneNumber='" + this.getPhone() + "'," + " CreditCardNumber='" + this.getCreditCardInfo() + "'," + " ExpirationDate='" + this.getExpireDate() + "'," + " SecurityCode='" + this.getSecurityCode() + "'" + " WHERE CustomerID= '" + this.getCID() + "'";
        db.updateDB(sql);
        System.out.println("Update Complete."); //Test code. Remove from final product.
    }

    /**
     * **********************************************************************************
     * deleteDB, uses DELETE SQL to delete from database. Requires 0 parameters.
     * Deletes an entry from the Customer Table based on current class property
     * values.
 **********************************************************************************
     */
    public void deleteDB() {
        sql = "Delete from Customer where CustomerID = " + getCID();
        db.deleteDB(sql);

    }

    public void findOrders() {

        try {
            System.out.println("Searching for orders...."); //Test code. Remove from final product.
            sql = "Select * From Order Where OrderID = " + getCID();
            ResultSet resultSet = db.SelectDB(sql);

            Order order;
            while (resultSet.next()) {
                order = new Order();
                order.setOrderID(resultSet.getString("OrderID"));
                order.setCustomerID(resultSet.getString("CustomerID"));
                order.setShipperID(resultSet.getString("Quantity"));
                order.setStatus(resultSet.getString("Status"));
                orderList.addItem(order);
            }
        } catch (SQLException e) {
            System.out.println("Error generating list of Orders: " + e);
        }

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
