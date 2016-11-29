/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihancruddesktop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author KENDAY
 */
public class DatabaseConnection {
    
    // JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/university";
// Database credentials
static final String username = "root";
static final String password = "kendaykendoy";
static Connection conn = null;

public static Connection getConnection() {
    if (conn != null) {
        return conn;
    } else {
        
    try {
    Class.forName(JDBC_DRIVER).newInstance();
    conn = DriverManager.getConnection(DB_URL, username, password);
    } catch (ClassNotFoundException e) {
    System.out.println(e.getMessage());
    } catch (SQLException e) {
    System.out.println(e.getMessage());
    } catch (InstantiationException e) {
    e.printStackTrace();
    } catch (IllegalAccessException e) {
    e.printStackTrace();
    }
        return conn;
    }
}

public static void testConnection() {
    
try {
    Class.forName(JDBC_DRIVER).newInstance();
    Connection koneksi = DriverManager.getConnection(DB_URL, username, password);
    if (koneksi != null) {
    System.out.println("Koneksi Berhasil");
    } else {
    System.out.println("Koneksi Gagal");
    }
    koneksi.close();
    } catch (ClassNotFoundException e) {
    System.out.println("Koneksi Gagal : "+ e.getMessage());
    } catch (SQLException e) {
    System.out.println("Koneksi Gagal : " + e.getMessage());
    } catch (InstantiationException e) {
    System.out.println("Koneksi Gagal : " + e.getMessage());
    e.printStackTrace();
    } catch (IllegalAccessException e) {System.out.println("Koneksi Gagal : " + e.getMessage());
    e.printStackTrace();
        }   
    }
    
}
