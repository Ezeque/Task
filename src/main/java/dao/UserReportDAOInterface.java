package Dao;

import Entity.UserReport;

import java.sql.SQLException;

public interface UserReportDAOInterface {
    //    CREATES ENTRIES IN DATABASE
    public boolean create(UserReport report) throws SQLException;

    //    GETS DATA IN DATABASE
    public UserReport getReportById(UserReport report) throws SQLException;

    public UserReport getReportByUserId(UserReport report, int user_id) throws SQLException;

    //    UPDATE DATA IN DATABASE
    public boolean update(UserReport report) throws SQLException;

    //    DELETE DATA IN DATABASE
    public boolean delete(UserReport report) throws SQLException;
}
