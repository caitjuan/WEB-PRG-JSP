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
    
    public void insertNewPost(int postid, String username, String title, String description, int tagid){
        String query = "INSERT INTO minimalist.post(postId, username, title, description, tagId) "
                + "VALUES (?,?,?,?,?);";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setInt(1, postid);
            ps.setString(2, username);
            ps.setString(3, title);
            ps.setString(4, description);
            ps.setInt(5, tagid);
        } catch (SQLException ex) {
            Logger.getLogger(DataInserter.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.executeQueryNoReturn(ps);
    }
    
    public void insertNewTag(int tagid, String tagname){
        String query = "INSERT INTO minimalist.tags(id, tagname) "
                + "VALUES (?,?);";
        
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setInt(1, tagid);
            ps.setString(2, tagname);
        } catch (SQLException ex) {
            Logger.getLogger(DataInserter.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.executeQueryNoReturn(ps);
    }
    
    public void insertNewImage(int postid, String filename){
        String query = "INSERT INTO minimalist.image(postId, fileName) "
                + "VALUES (?,?);";
        
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setInt(1, postid);
            ps.setString(2, filename);
        } catch (SQLException ex) {
            Logger.getLogger(DataInserter.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.executeQueryNoReturn(ps);
    }   
}
