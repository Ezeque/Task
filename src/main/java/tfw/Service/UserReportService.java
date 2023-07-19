package tfw.Service;

import tfw.Dao.UserReportDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.UserReport;

import java.sql.SQLException;

public abstract class UserReportService {

    private UserReportDAO dao;


    protected DatabaseConfiguration dbconfig;

    public UserReportService(DatabaseConfiguration dbconfig) {
        this.dbconfig = dbconfig;
        this.dao = new UserReportDAO(this.dbconfig);
    }

    public abstract boolean validateCreation(UserReport report);

    public abstract boolean validateSearch(UserReport report);

    public abstract boolean validateUpdate(UserReport report);

    public abstract boolean validateDeletion(UserReport report);

    public boolean create(UserReport report) {
        boolean success = false;
        if (validateCreation(report)) {
            try {
                success = dao.create(report);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return success;
    }

    public UserReport getReportById(UserReport report) {

        if (validateSearch(report)) {
            try {
                report = dao.getReportById(report);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return report;
    }


    public UserReport getReportByUserId(UserReport report, int user_id) {

        if (validateSearch(report)) {
            try {
                report = dao.getReportByUserId(report, user_id);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return report;
    }
              

    public UserReport getReportByUserId(UserReport report) {

        if (validateSearch(report)) {
            try {
                report = dao.getReportByUserId(report);

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return report;
    }

    public boolean update(UserReport report) {
        boolean success = false;

        if (validateUpdate(report)) {
            try {
                success = dao.update(report);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return success;
    }

    public boolean delete(UserReport report) {
        boolean success = false;

        if (validateDeletion(report)) {
            try {
                success = dao.delete(report);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return success;
    }

}
