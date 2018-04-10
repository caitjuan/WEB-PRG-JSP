package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public ResultSet getSearchPost(String title){
        String query = "SELECT DISTINCT(post.username), post.title, post.description, image.fileName "
                + " FROM minimalist.post JOIN minimalist.image\n" +
                "WHERE post.title LIKE ? AND image.postId = post.postId;";
        PreparedStatement ps = database.createStatement(query);
        try{
            ps.setString(1, "%" + title + "%");
        } catch (SQLException ex){
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = database.executeQueryWithReturn(ps);
        return rs;
    }
    
    public ResultSet getTags(String postId){
        String query = "SELECT tags.tagname FROM minimalist.post JOIN minimalist.tags\n" +  
        "WHERE post.postId = ? AND post.tagId = tags.id;";
        PreparedStatement ps = database.createStatement(query);
        try{
            ps.setString(1, postId);
        } catch (SQLException ex){
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = database.executeQueryWithReturn(ps);
        return rs;
    }
    
    public ResultSet getDistinctPostId(String title){
        String query = "SELECT DISTINCT(postId) from minimalist.post\n" +
        "WHERE post.title LIKE ?;";
        PreparedStatement ps = database.createStatement(query);
        try{
            ps.setString(1, "%" + title + "%");
        } catch (SQLException ex){
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = database.executeQueryWithReturn(ps);
        return rs;
    }
    
    public boolean ifTagExist(String tags) throws SQLException{
        String query =  "	SELECT tagname FROM minimalist.tags\n" +
                        "	WHERE tagname = ?";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1, tags);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = database.executeQueryWithReturn(ps);
        rs.beforeFirst();
        ArrayList<String> str = new ArrayList<>();
        while (rs.next()) {
            str.add(rs.getString(1));
        }
        if (str.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public int getTagID(String tag) throws SQLException{
        String query =  "	SELECT id FROM minimalist.tags\n" +
                        "	WHERE tagname = ?";
        PreparedStatement ps = database.createStatement(query);
        try {
            ps.setString(1, tag);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = database.executeQueryWithReturn(ps);
        rs.beforeFirst();
        ArrayList<String> ids = new ArrayList<>();
        while (rs.next()) {
            ids.add(rs.getString(1));
        }
        int tagid = Integer.parseInt(ids.get(0));
        return tagid;
    }
    
    public int getNextPostID() throws SQLException{
        String query =  "	SELECT COUNT(DISTINCT postId) FROM minimalist.post";
        
        PreparedStatement ps = database.createStatement(query);
        
        ResultSet rs = database.executeQueryWithReturn(ps);
        rs.beforeFirst();
        ArrayList<String> ids = new ArrayList<>();while (rs.next()) {
            ids.add(rs.getString(1));
        }
        int postid = Integer.parseInt(ids.get(0)) + 1;
        return postid;
    }
    
    public int getNextTagID() throws SQLException{
        String query =  "	SELECT COUNT(DISTINCT id) FROM minimalist.tags";
        
        PreparedStatement ps = database.createStatement(query);
        
        ResultSet rs = database.executeQueryWithReturn(ps);
        rs.beforeFirst();
        ArrayList<String> ids = new ArrayList<>();
        while (rs.next()) {
            ids.add(rs.getString(1));
        }
        int tagid = Integer.parseInt(ids.get(0)) + 1;
        return tagid;
    }
    
    public ResultSet getAllPosts() {
        String query = "SELECT DISTINCT(post.username), post.title, post.description, image.fileName "
                + " FROM minimalist.post JOIN minimalist.image\n"
                + "WHERE post.postID = image.postId;";
        PreparedStatement ps = database.createStatement(query);
        
        ResultSet rs = database.executeQueryWithReturn(ps);
        return rs;
    }
    
    public ResultSet getDistinctPostIdAll(){
        String query = "SELECT DISTINCT(postId) from minimalist.post";
        PreparedStatement ps = database.createStatement(query);
        
        ResultSet rs = database.executeQueryWithReturn(ps);
        return rs;
    }
}
