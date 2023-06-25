package Dao;


import Entity.ProjectReport;

import java.sql.SQLException;

public interface ProjectReportDAOInterface {
    //    CREATES ENTRIES IN DATABASE
    public boolean create(ProjectReport report, String entityName)  throws SQLException;
    //    GETS DATA IN DATABASE
    public ProjectReport getReportById(ProjectReport report, String entityName) throws SQLException;
    public ProjectReport getReportByProjectId(ProjectReport report, String entityName) throws SQLException;
    //    UPDATE DATA IN DATABASE
    public boolean update(ProjectReport report, String entityName) throws SQLException;
    //    DELETE DATA IN DATABASE
    public boolean delete(ProjectReport report, String entityName) throws SQLException;
}
