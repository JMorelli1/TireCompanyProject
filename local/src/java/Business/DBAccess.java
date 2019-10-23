/** **********************************************************************************
 *@author James Morelli
 * Tire Project
 * Created: 9/24/19
 ********************************************************************************** */
package Business;

import java.sql.*;

public class DBAccess {

    private Connection con;
    private Statement stm;
    private ResultSet resultSet;
    private final String ConLocation = "jdbc:ucanaccess://F://Winter 2019//TiresRUs//Tyres.accdb";

    /**
     * **********************************************************************************
     * SelectDB opens connection with database then executes Select query within
     * give SQL statement then closes connection and returns ResultSet. Used to
     * pull relevant fields information from database.
     *
     * @param sqlStm
     * @return ResultSet
 **********************************************************************************
     */
    public ResultSet SelectDB(String sqlStm) {

        openDBConnection();
        try {
            resultSet = stm.executeQuery(sqlStm);
        } catch (SQLException e) {
            System.out.println("Select DB Error: " + e);
        }
        closeDBConnection();
        return resultSet;
    }

    /**
     * **********************************************************************************
     * InsertDB opens connection with database then executes Insert query within
     * give SQL statement then closes connection Used for inserting filled
     * object into the database.
     *
     * @param sqlStm
 **********************************************************************************
     */
    public void InsertDB(String sqlStm) {
        openDBConnection();
        try {
            stm.executeUpdate(sqlStm);
        } catch (SQLException e) {
            System.out.println("Error Insert into DB: " + e);
        }
        closeDBConnection();
    }

    /**
     * **********************************************************************************
     * UpdateDB opens connection with database then executes Update query within
     * give SQL statement then closes connection Used for updating all data
     * changed within an existing database row.
     *
     * @param sqlStm
 **********************************************************************************
     */
    public void updateDB(String sqlStm) {
        openDBConnection();
        try {
            System.out.println(sqlStm); //Test code. Remove from final product.
            stm.executeUpdate(sqlStm);
            System.out.println("Update executed."); //Test code. Remove from final product.
        } catch (SQLException e) {
            System.out.println("Error Updating from DB: " + e);
        }
        closeDBConnection();
    }

    /**
     * **********************************************************************************
     * DeleteDB opens connection with database then executes Delete query within
     * give SQL statement then closes connection Used for deleting existing row
     * with database.
     *
     * @param sqlStm
 **********************************************************************************
     */
    public void deleteDB(String sqlStm) {
        openDBConnection();
        try {
            stm.executeUpdate(sqlStm);
        } catch (SQLException e) {
            System.out.println("Error Deleting from DB Tire: " + e);
        }
        closeDBConnection();
    }

    /**
     * **********************************************************************************
     * openDBConnection establishes connection using Driver, initializes
     * statement
 **********************************************************************************
     */
    public void openDBConnection() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(ConLocation);
            stm = con.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error Connecting " + e);
        }
    }

    /**
     * **********************************************************************************
     * closeDBConnection closes connection with database
 **********************************************************************************
     */
    public void closeDBConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error closing database: " + e);
        }
    }
}
