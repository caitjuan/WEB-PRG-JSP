package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataExtractor {
    private DBConnector database;
    
    public DataExtractor(){
        database = new DBConnector();
    }
    
    public void close(){
        database.closeDB();
    }
    
    public ResultSet getUsername(String username){
        String query = "	SELECT username FROM minimalist.user\n" +
"	WHERE username = ?";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1, username);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = database.executeQueryWithReturn(ps);
        return rs;
    }
    
    public ResultSet getPassword(String username){
        String query = "	SELECT password FROM minimalist.user\n" +
"	WHERE username = ?";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1, username);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = database.executeQueryWithReturn(ps);
        return rs;
    }
    
    public ResultSet getPost(String title){
        String query = "SELECT username, title, description, postId, tagId FROM minimalist.post"
                + "WHERE title LIKE '%" + title + "%'";
        PreparedStatement ps = database.createStatement(query);
        try{
            ps.setString(1, title);
        } catch (SQLException ex){
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = database.executeQueryWithReturn(ps);
        return rs;
    }
    
    public ResultSet getNumPosts(String title){
        String query = "SELECT COUNT(DISTINCT postId) from minimalist.post"
                + "WHERE title LIKE '%?%'";
        PreparedStatement ps = database.createStatement(query);
        try{
            ps.setString(1, title);
        } catch (SQLException ex){
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = database.executeQueryWithReturn(ps);
        return rs;
    }
}
