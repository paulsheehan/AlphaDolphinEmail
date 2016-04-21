package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.business.User;
import com.example.exceptions.DaoException;
import java.sql.Statement;

public class UserDao extends Dao {

	public void addUserToDatabase(String email,String fullName,String password,String answer) throws DaoException
	{
        Connection con = null;
        Statement ps = null;

        try {
        	con = this.getConnection();
        	ps = con.createStatement();
    		//String insertStatement = "INSERT INTO users(email) VALUES (\"" + email + "\" );";
    		
        	String insertStatement = "INSERT INTO users(fullname, email, password, question) VALUES ( \"" + fullName + "\", \"" + email
        			+ "\", \"" + password + "\", \"" + answer + "\" );";
    		//INSERT INTO users(email) VALUES("paul");
            
            ps.executeUpdate(insertStatement);
            
            }catch (SQLException e) {
                throw new DaoException("addUserToDatabase " + e.getMessage());
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    throw new DaoException("addUserToDatabase" + e.getMessage());
                }
            }
    	} 
	
    public User findUserByUsernamePassword(String email, String password) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();
            //SELECT * FROM users WHERE email = "test" AND password = "pass";
            String query = "SELECT * FROM users WHERE EMAIL = ? AND PASSWORD = ?";
            //String query = "SELECT * FROM users WHERE email = \'" + email + "\' AND password = \'" + password + "\';";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {

                String userEmail = rs.getString("EMAIL");
                String pass = rs.getString("PASSWORD");
                u = new User(userEmail, pass);
            }
        } catch (SQLException e) {
            throw new DaoException("findUserByUsernamePassword " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findUserByUsernamePassword" + e.getMessage());
            }
        }
        return u;     // u may be null 
    
    }
}
//    
//    public List<User> getAllUsers() throws DaoException
//    {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        List<User> users = new ArrayList<User>();
//        try {
//            con = this.getConnection();
//            
//            String query = "SELECT ID, FIRST_NAME, LAST_NAME, USERNAME FROM USER";
//            ps = con.prepareStatement(query);
//            rs = ps.executeQuery();
//            
//            String firstname = new String();
//            String lastname = new String();
//            String username = new String();
//            
//            while(rs.next()) {
//            	
//            	firstname = rs.getString("FIRST_NAME");
//                lastname = rs.getString("LAST_NAME");
//                username = rs.getString("USERNAME");
//                String output = new String();
//                output = firstname + lastname + username;
//                System.out.println(output);
//            	users.add(new User(firstname, lastname, username));
//            }
//            rs.close();
//        } catch(SQLException e) {
//        	throw new DaoException("getAllUsers " + e.getMessage());
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (con != null) {
//                    freeConnection(con);
//                }
//            } catch (SQLException e) {
//            	throw new DaoException("getAllUsers " + e.getMessage());
//            }
//        }
//        
//        return users;
//    }

//}
