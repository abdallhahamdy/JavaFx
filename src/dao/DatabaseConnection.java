/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class DatabaseConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    private static final String URL = "jdbc:mysql://localhost:3306/fxsystem";
    private static Connection connection = null;

    // Connection With DataBaseConnection
    public static Connection connect() throws SQLException {
          try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(
                     URL, USERNAME, PASSWORD);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return connection;
    }
}
