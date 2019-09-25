/***********************************************************************************
  @author Elijah T. Badger                                                         *
  Customer.java (Project)                                                          *
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
 * Customer Class. Requires 0 or 11 parameters. Purpose: Complete database tasks
 * and hold relevant values from database in class property fields. 
 ***********************************************************************************/
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
    //public String listOfOrders;

 /************************************************************************************
 * Customer constructor, Initializes all properties to "" when 0 
 * parameters are given.
 ***********************************************************************************/   
    
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
        System.out.println("Displaying Customer properties. Name: " + this.getFN() + " " + this.getLN() + ". Username: " + this.getUsername() + ". Password: " + this.getPassword() + ". ID:" + this.getID() + ". Address: " + this.getAddress() + ". Phone number: " + this.getPhone() + ". Card number: " + this.getCreditCardInfo() + " " + this.getExpireDate() + " " + this.getSecurityCode() + ".");
    }
 
/************************************************************************************
 * selectDB, uses SELECT SQL to query database. Requires 1 String parameter. Queries
 * the Customer table for entries whose id key matches the
 * given parameter.
 ***********************************************************************************/    
    public void selectDB(String ID) {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at select (for Customer).");
            Statement statement = con.createStatement();
            String sql = "Select * from Customer where CustomerID = '" + ID + "'";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Result set compiled (for Admin).");
            rs.next();

            this.setID(rs.getString("CustomerID"));
            this.setUsername(rs.getString("Username"));
            this.setPassword(rs.getString("Password"));
            this.setFN(rs.getString("FirstName"));
            this.setLN(rs.getString("LastName"));
            this.setAddress(rs.getString("Address"));
            this.setPhone(rs.getString("PhoneNumber"));
            this.setCreditCardInfo(rs.getString("CreditCardNumber"));
            this.setExpireDate(rs.getString("ExpirationDate"));
            this.setSecurityCode(rs.getString("SecurityCode"));
            this.setOID(rs.getString("OrderID"));
            System.out.println("Selections completed...");
            System.out.println(" ");

            con.close();
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
    public void insertDB(String id, String username, String pw, String fn, String ln, String address, String phone, String card_info, String expire, String sec_code, String oid) {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at insert (for Customer).");
            Statement statement = con.createStatement();
            String sql = "Insert into Customer (CustomerID, Username, Password, FirstName, LastName, Address, PhoneNumber, CreditCardNumber, ExpirationDate, SecurityCode, OrderID) VALUES ('" + id + "', '" + username + "', '" + pw + "', '" + fn + "', '" + ln + "', '" + address + "', '" + phone + "', '" + card_info + "', '" + expire + "', '" + sec_code + "', '" + oid + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("Insert completed.");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at insertDB method (for Customer). " + e);
            System.out.println(" ");
        }
    }

/************************************************************************************
 * updateDB, uses UPDATE SQL to update database. Requires 0 parameters. Updates from the
 * Customer table in  based on the current values of class 
 * properties.
 ***********************************************************************************/ 
    public void updateDB() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at update (for Admin).");
            Statement statement = con.createStatement();
            PreparedStatement ps = con.prepareStatement("UPDATE Customer SET Username = ?, Password = ?, FirstName = ?, LastName = ?, Address = ?, PhoneNumber = ?, CreditCardNumber = ?, ExpirationDate = ?, SecurityCode = ?, OrderID = ? WHERE CustomerID = ?");
            ps.setString(1, this.getUsername());
            ps.setString(2, this.getPassword());
            ps.setString(3, this.getFN());
            ps.setString(4, this.getLN());
            ps.setString(5, this.getAddress());
            ps.setString(6, this.getPhone());
            ps.setString(7, this.getCreditCardInfo());
            ps.setString(8, this.getExpireDate());
            ps.setString(9, this.getSecurityCode());
            ps.setString(10, this.getOID());
            ps.setString(11, this.getCID());
            System.out.println("Prepped statement compelted.");
            System.out.println(" ");
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at updateDB method (for Customer). " + e);
            System.out.println(" ");
        }
    }

/************************************************************************************
 * deleteDB, uses DELETE SQL to delete from database. Requires 0 parameters. Deletes
 * an entry from the Customer Table based on current class
 * property values.
 ***********************************************************************************/ 
    public void deleteDB() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/Winter 2019/TiresRUs/Tyres.accdb");
            System.out.println("Connection established at delete (for Customer).");
            Statement statement = con.createStatement();
            String sql = "Delete from Customer where CustomerID = " + this.getCID();
            statement.executeUpdate(sql);
            System.out.println("Deletion completed.");
            System.out.println(" ");

            con.close();
        } catch (SQLException e) {
            System.out.println("Crash at updateDB method (for Customer). " + e);
            System.out.println(" ");
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
