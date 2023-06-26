package tfw.Dao;

import tfw.Database.DatabaseConfiguration;
import tfw.Entity.ProjectReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectReportDAO implements ProjectReportDAOInterface{
    Connection con;
    DatabaseConfiguration config;

    public ProjectReportDAO(){
        con = config.connect();
    }

    public PreparedStatement buildFullStatement(PreparedStatement pst, ProjectReport report) throws SQLException{
        pst.setInt(1, report.getProjectId());
        pst.setInt(2, report.getId());
        return pst;

    }

    public ProjectReport buildReport(ProjectReport report, ResultSet rs) throws SQLException{
        report.setId(rs.getInt("id"));
        report.setProject_id(rs.getInt("project_id"));
        return report;
    }
    public boolean create(ProjectReport report, String entityName)  throws SQLException{
        String query = "INSERT INTO " + entityName + " (project_id, id) VALUES (?,?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, report);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }
        return false;
    }

    //    GETS DATA IN DATABASE
    public ProjectReport getReportById(ProjectReport report, String entityName) throws SQLException{
        String query = "SELECT * FROM " + entityName;
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ProjectReport returnReport = buildReport(report, rs);
            if(returnReport.getId() == report.getId()) {
                return returnReport;
            }

        }

        return null;
    }
    public ProjectReport getReportByProjectId(ProjectReport report, String entityName) throws SQLException{
        String query = "SELECT * FROM " + entityName;
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ProjectReport returnReport = buildReport(report, rs);

            if(returnReport.getProjectId() == report.getProjectId()) {
                return returnReport;
            }

        }

        return null;
    }
    //    UPDATE DATA IN DATABASE
    public boolean update(ProjectReport report, String entityName) throws SQLException{
        String query = "UPDATE " + entityName + " SET project_id = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, report);

        int res = pst.executeUpdate();

        if(res == 1){
            return true;
        }

        return false;
    }
    //    DELETE DATA IN DATABASE
    public boolean delete(ProjectReport report, String entityName) throws SQLException{
        return false;
    }
}
