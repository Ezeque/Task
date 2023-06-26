package tfw.Dao;

import tfw.Entity.User;

import java.sql.SQLException;

public interface UserDaoInterface {
    //    CREATES ENTRIES IN DATABASE
    public boolean create(User user, String entityName)  throws SQLException;
    //    GETS DATA IN DATABASE
    public User getUserById(User user, String entityName) throws SQLException;
    //    UPDATE DATA IN DATABASE
    public boolean update(User user, String entityName) throws SQLException;
    //    DELETE DATA IN DATABASE
    public boolean delete(User user, String entityName) throws SQLException;
}
