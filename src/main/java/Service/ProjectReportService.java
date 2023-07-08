package Service;

import Dao.ProjectReportDAO;
import Entity.ProjectReport;

import java.sql.SQLException;


public abstract class ProjectReportService {
    private ProjectReportDAO dao = new ProjectReportDAO();

    public abstract boolean validateCreation(ProjectReport report);

    public abstract boolean validateSearch(ProjectReport report);

    public abstract boolean validateUpdate(ProjectReport report);

    public abstract boolean validateDeletion(ProjectReport report);

    public boolean create(ProjectReport report) {
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

    public ProjectReport getReportById(ProjectReport report) {

        if (validateSearch(report)) {
            try {
                report = dao.getReportById(report);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return report;
    }

    public ProjectReport getReportByProjectId(ProjectReport report) {

        if (validateSearch(report)) {
            try {
                report = dao.getReportByProjectId(report);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return report;
    }

    public boolean update(ProjectReport report) {
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

    public boolean delete(ProjectReport report) {
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
