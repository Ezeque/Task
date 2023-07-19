package tfw.Dao;

import tfw.Database.DatabaseConfiguration;
import tfw.Entity.UserReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserReportDAO implements UserReportDAOInterface {
    protected Connection con;
    protected DatabaseConfiguration config;

    public UserReportDAO(DatabaseConfiguration config) {
        this.config = config;
        this.con = config.connect();
    }

    public PreparedStatement buildFullStatement(PreparedStatement pst, UserReport report) throws SQLException {
        pst.setInt(1, report.getUserId());
        pst.setInt(2, report.getId());
        return pst;

    }

    public UserReport buildReport(UserReport report, ResultSet rs) throws SQLException {
        report.setId(rs.getInt("id"));
        report.setUserId(rs.getInt("user_id"));
        return report;
    }

    public boolean create(UserReport report) throws SQLException {
        String query = "INSERT INTO " + config.getTable() + " (user_id, id) VALUES (?,?)";
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
    public UserReport getReportById(UserReport report) throws SQLException {
        String query = "SELECT * FROM " + config.getTable();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            UserReport returnReport = buildReport(report, rs);
            if (returnReport.getId() == report.getId()) {
                return returnReport;
            }

        }

        return null;
    }

    public UserReport getReportByUserId(UserReport report) throws SQLException {
        String query = "SELECT * FROM " + config.getTable();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            UserReport returnReport = buildReport(report, rs);

            if (returnReport.getUserId() == report.getUserId()) {
                return returnReport;
            }

        }

        return null;
    }

    //    UPDATE DATA IN DATABASE
    public boolean update(UserReport report) throws SQLException {
        String query = "UPDATE " + config.getTable() + " SET user_id = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, report);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    //    DELETE DATA IN DATABASE
    public boolean delete(UserReport report) throws SQLException {
        return false;
    }
}
