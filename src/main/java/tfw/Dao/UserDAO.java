package tfw.Dao;

import tfw.Database.DatabaseConfiguration;
import tfw.Entity.ConcreteUser;
import tfw.Entity.Project;
import tfw.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements UserDaoInterface {

    protected Connection con;
    protected DatabaseConfiguration config;

    public UserDAO(DatabaseConfiguration config) {
        this.config = config;
        this.con = config.connect();
    }

    public User buildUser(User user, ResultSet rs) throws SQLException {
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setId(rs.getInt("id"));
        return user;
    }

    public PreparedStatement buildFullStatementUpdate(PreparedStatement pst, User user) throws SQLException {
        pst.setString(1, user.getName());
        pst.setString(2, user.getEmail());
        pst.setString(3, user.getPassword());
        pst.setInt(4, user.getId());
        return pst;
    }

    public PreparedStatement buildFullStatementCreate(PreparedStatement pst, User user) throws SQLException {
        pst.setString(1, user.getName());
        pst.setString(2, user.getEmail());
        pst.setString(3, user.getPassword());
        return pst;
    }


    @Override
    public boolean create(User user) throws SQLException {
        Connection con = config.connect();
        String query = "INSERT INTO " + config.getTable() + " (name, email, password) VALUES (?,?,?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementCreate(pst, user);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    @Override
    public User getUserById(User user) throws SQLException {
        Connection con = config.connect();
        String query = "SELECT * FROM " + config.getTable();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            User returnUser = new ConcreteUser(rs.getString("name"), rs.getString("name"), rs.getString("password"), rs.getInt("id"));
            if (returnUser.getId() == user.getId()) {
                return returnUser;
            }

        }
        return null;
    }

    @Override
    public boolean update(User user) throws SQLException {
        Connection con = config.connect();
        String query = "UPDATE user SET " + config.getTable() + " = ?, email = ?, password = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementUpdate(pst, user);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String string = "DELETE FROM " + config.getTable() + " WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(string);
        pst.setInt(1, user.getId());

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    @Override
    public User login(User user) throws SQLException {
        String string = "SELECT * FROM " + config.getTable() + " WHERE name = ? AND password = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(string);
        pst.setString(1, user.getName());
        pst.setString(2, user.getPassword());

        ResultSet res = pst.executeQuery();

        if (res.next()) {
            int id = res.getInt("id");
            String nome = res.getString("name");
            String email = res.getString("email");
            String senha = res.getString("password");
            return new ConcreteUser(nome, email, senha, id);
        }
        return null;
    }

    public boolean emailExists(User user) throws SQLException {
        String query = "SELECT email FROM " + config.getTable() + " WHERE email = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, user.getEmail());
        ResultSet res = pst.executeQuery();

        if (res.next()) {
            if (res.getString("email").equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public User getUserByName(User user) throws SQLException {
        Connection con = config.connect();
        String query = "SELECT * FROM " + config.getTable() + " WHERE name = ?;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, user.getName());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            User returnUser = buildUser(user, rs);
            return returnUser;
        }
        return null;
    }

    public ArrayList<User> getAll() throws SQLException{
        String query = "SELECT * FROM " + config.getTable();
        ArrayList<User> users = new ArrayList<User>();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            User returnUser = new ConcreteUser(rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getInt("id"), rs.getInt("id_setor"));
            users.add(returnUser);
        }

        return users;
    }

    public ArrayList<User> getAllUsersByProjectId(int project_id) throws SQLException{
        String query = "SELECT * FROM " + config.getTable();
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            User returnUser = new ConcreteUser(rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getInt("id"), rs.getInt("id_setor"));
            if(returnUser.getIdSetor() == project_id) users.add(returnUser);

        }

        return users;
    }
}
