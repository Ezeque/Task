package tfw.Dao;

import tfw.Entity.Project;
import tfw.Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDaoInterface {
    //    CREATES ENTRIES IN DATABASE
    public boolean create(User user) throws SQLException;

    //    GETS DATA IN DATABASE
    public User getUserById(User user) throws SQLException;

    //    UPDATE DATA IN DATABASE
    public boolean update(User user) throws SQLException;

    //    DELETE DATA IN DATABASE
    public boolean delete(User user) throws SQLException;

    User login(User user) throws SQLException;

    public User getUserByName(User user) throws SQLException;

    public ArrayList<User> getAll() throws SQLException;

    public ArrayList<User> getAllUsersByProjectId(int project_id) throws SQLException;
}
