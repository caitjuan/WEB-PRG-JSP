package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataInserter {
    private DBConnector database;
    
    public DataInserter(){
        database = new DBConnector();
    }
    
    public void close(){
        database.closeDB();
    }
    
    public void insertNewMember(String username, String name, String gender, String email, String password){
        String query = "INSERT INTO minimalist.user(username, name, description, gender, email, password) "
                + "VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1, username);
            ps.setString(2,  name);
            ps.setString(3, null);
            ps.setString(4, gender);
            ps.setString(5, email);
            ps.setString(6, password);
        } catch (SQLException ex) {
            Logger.getLogger(DataInserter.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.executeQueryNoReturn(ps);
    }
}
