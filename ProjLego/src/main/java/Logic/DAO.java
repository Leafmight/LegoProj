package Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.DBConnector;
import Data.User;
import Data.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class DAO {

    public User getUser(String email, String password) {
        User u = null;
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                           = "SELECT Password, IsAdmin FROM Users WHERE Email = '" + email + "';";
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                String pw = res.getString("Password");
                boolean isAdmin = res.getBoolean("IsAdmin");
                if (pw.equals(password)) {
                    u = new User(email, isAdmin);
                }// else {
                // throw new LoginSampleException("Unknown username or invalid password.");
                // }
            }
        } catch (Exception ex) {
            u = new User("Error", false);
            return u;
        }
        return u;
    }

    public boolean createUser(String email, String password) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String comm
                           = "INSERT INTO `Users` values('" + email + "', " + false + ", '" + password + "');";
            stmt.execute(comm);
        } catch (Exception ex) {
            System.out.println("Error, unable to create user");
            return false;
        }
        return true;
    }

    public boolean checkLogin(String email, String password) {
        String _password = "";
        try {
            DBConnector c = new DBConnector();

            String query = "SELECT Password FROM `Users` WHERE Email = '" + email + "';";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                _password = rs.getString("Password");
            }
            return _password.equals(password);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean setUserAdmin(String name) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String comm
                           = "UPDATE `Users` "
                           + "set IsAdmin = true "
                           + "where Email = '" + name + "';";
            stmt.execute(comm);
        } catch (Exception ex) {
            System.out.println("Error, unable to edit user");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
public boolean setIsShipped(int orderID) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String comm
                           = "UPDATE `Order` "
                           + "set IsShipped = true "
                           + "where Order_id = " + orderID + ";";
            stmt.execute(comm);
        } catch (Exception ex) {
            System.out.println("Error, unable to edit user");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public void insertOrder(int width, int length, int height, String bandType, int x4, int x2, int x1, String userName) {
        int id = 0;
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String sql
                           = "INSERT INTO `Order` VALUES (" + 0 + ", " + width + ", " + length + ", "
                           + height + ", '" + bandType + "', " + x4 + ", " + x2 + ", " + x1 + ", '"
                           + userName + "', " + 0 + ");";

            stmt.execute(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Order> getUserOrderList(String email) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                           = "SELECT * FROM `Order` WHERE Email = '" + email + "';";
            ArrayList<Order> ol = new ArrayList<>();
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                int orderID = res.getInt("Order_id");
                int width = res.getInt("Width");
                int length = res.getInt("Length");
                int height = res.getInt("Height");
                String bandType = res.getString("BandType");
                int x4 = res.getInt("x4");
                int x2 = res.getInt("x2");
                int x1 = res.getInt("x1");
                Boolean isShipped = res.getBoolean("IsShipped");
                Order o = new Order(width, length, height, bandType, x4, x2, x1, email);
                o.setIsShipped(isShipped);
                o.setOrderNr(orderID);
                ol.add(o);
            }
            return ol;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<Order> getAllOrderList() {
        
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                           = "SELECT * FROM `Order`;";
            ArrayList<Order> ol = new ArrayList<>();
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                int width = res.getInt("Width");
                int length = res.getInt("Length");
                int height = res.getInt("Height");
                String bandType = res.getString("BandType");
                int x4 = res.getInt("x4");
                int x2 = res.getInt("x2");
                int x1 = res.getInt("x1");
                String email = res.getString("Email");
                Boolean isShipped = res.getBoolean("IsShipped");
                int orderID = res.getInt("Order_id");
                Order o = new Order(width, length, height, bandType, x4, x2, x1, email);
                o.setIsShipped(isShipped);
                o.setOrderNr(orderID);
                ol.add(o);
            }
            return ol;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
}
