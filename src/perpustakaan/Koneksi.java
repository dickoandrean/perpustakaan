/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.Statement;
/**
 *
 * @author Dicko
 */
public class Koneksi {
    public static void main (String[] args){
    }
    public static Properties prop = new Properties();
    public static Connection KoneksiDatabase;
    public static Statement stm;
    public static void connect(){
    try {  
        try {
          prop.load(new FileInputStream("Config/config.txt"));
        } catch (IOException ex) {
          System.out.println("gagal load file properties");
        }
      String db ;
      String user ;
      String pw ;
      db = prop.getProperty("db");
      user = prop.getProperty("user");
      pw = prop.getProperty("password");
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      KoneksiDatabase = (Connection) DriverManager.getConnection(db,user,pw);
      stm = KoneksiDatabase.createStatement();
      
    } catch(SQLException e){
           System.out.println(e.getMessage()); 
    }
  }
}
