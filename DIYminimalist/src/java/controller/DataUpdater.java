package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataUpdater {
    private DBConnector database;
    
    public DataUpdater(){
        database = new DBConnector();
    }
    
    public void close(){
        database.closeDB();
    }
    
    public void update(String oldUsername, String email, String gender, String username, String name, String description, String password){
        updateName(name, oldUsername);
        updateDescription(description, oldUsername);
        updateGender(gender, oldUsername);
        updateEmail(email, oldUsername);
        updatePassword(password, oldUsername);
        updateUsername(username, oldUsername);
    }
    
    public void updateName(String name, String oldUsername){
        String query = "UPDATE minimalist.user\n"
                + "SET name = ?\n"
                + "WHERE username = ?";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1, name);
            ps.setString(2, oldUsername);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.executeQueryNoReturn(ps);
    }
    
    public void updateDescription(String desc, String oldUsername){
        String query = "UPDATE minimalist.user\n"
                + "SET description = ?\n"
                + "WHERE username = ?";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1, desc);
            ps.setString(2, oldUsername);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.executeQueryNoReturn(ps);
    }
    
    public void updateGender(String gender, String oldUsername){
        String query = "UPDATE minimalist.user\n"
                + "SET gender = ?\n"
                + "WHERE username = ?";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1, gender);
            ps.setString(2, oldUsername);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.executeQueryNoReturn(ps);
    }
    
    public void updateEmail(String email, String oldUsername){
        String query = "UPDATE minimalist.user\n"
                + "SET email = ?\n"
                + "WHERE username = ?";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1, email);
            ps.setString(2, oldUsername);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.executeQueryNoReturn(ps);
    }
    
    public void updatePassword(String password, String oldUsername){
        String query = "UPDATE minimalist.user\n"
                + "SET password = ?\n"
                + "WHERE username = ?";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1, password);
            ps.setString(2, oldUsername);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.executeQueryNoReturn(ps);
    }
    
    public void updateUsername(String username, String oldUsername){
        String query = "UPDATE minimalist.user\n"
                + "SET username = ?\n"
                + "WHERE username = ?";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1,username);
            ps.setString(2, oldUsername);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.executeQueryNoReturn(ps);
    }
}
