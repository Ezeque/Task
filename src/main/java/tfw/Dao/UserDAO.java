package tfw.Dao;

import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO implements UserDaoInterface{
    Connection con;
    DatabaseConfiguration config;

    public UserDAO(){
        con = config.connect();
    }

    public User buildUser(User user, ResultSet rs) throws SQLException{
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setId(rs.getInt("id"));
        return user;
    }

    public PreparedStatement buildFullStatement(PreparedStatement pst, User user) throws SQLException{
        pst.setString(1, user.getName());
        pst.setString(2, user.getEmail());
        pst.setString(3, user.getPassword());
        pst.setInt(4, user.getId());
        return pst;
    }

    @Override
    public boolean create(User user, String entityName) throws SQLException{
        String query = "INSERT INTO " + entityName + " (name, email, password, id) VALUES (?,?,?,?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, user);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    @Override
    public User getUserById(User user, String entityName) throws SQLException{
        String query = "SELECT * FROM " + entityName;
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            User returnUser = buildUser(user, rs);
            if(returnUser.getId() == user.getId()) {
                return returnUser;
            }

        }
        return null;
    }

    @Override
    public boolean update(User user, String entityName) throws SQLException{
        String query = "UPDATE user SET " + entityName + " = ?, email = ?, password = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, user);

        int res = pst.executeUpdate();

        if(res == 1){
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(User user, String entityName) throws SQLException{
        String string = "DELETE FROM " + entityName + " WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(string);
        pst.setInt(1, user.getId());

        int res = pst.executeUpdate();

        if(res == 1){
            return true;
        }

        return false;
    }

    public boolean emailExists(User user, String entityName) throws SQLException{
        String query = "SELECT email FROM " + entityName + " WHERE email = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, user.getEmail());
        ResultSet res = pst.executeQuery();

        if (res.next()) {
            if ( res.getString("email").equals(user.getEmail()) ) {
                return true;
            }
        }
        return false;
    }
}