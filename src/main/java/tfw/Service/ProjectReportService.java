package tfw.Service;

import tfw.Dao.ProjectReportDAO;
import tfw.Entity.ProjectReport;

import java.sql.SQLException;


public abstract class ProjectReportService {
    private ProjectReportDAO dao = new ProjectReportDAO();

    public abstract boolean validateCreation(ProjectReport report, String entityName);
    public abstract boolean validateSearch(ProjectReport report, String entityName);
    public abstract boolean validateUpdate(ProjectReport report, String entityName);
    public abstract boolean validateDeletion(ProjectReport report, String entityName);

    public boolean create(ProjectReport report, String entityName){
        boolean success = false;
        if(validateCreation(report, entityName)){
            try{
                success = dao.create(report, entityName);
            }catch(SQLException e){
                System.out.println(e);
            }
        }

        return success;
    }

    public ProjectReport getReportById(ProjectReport report, String entityName){

        if(validateSearch(report, entityName)){
            try {
                report =  dao.getReportById(report, entityName);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return report;
    }

    public ProjectReport getReportByProjectId(ProjectReport report, String entityName){

        if(validateSearch(report, entityName)){
            try {
                report =  dao.getReportByProjectId(report, entityName);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return report;
    }

    public boolean update(ProjectReport report, String entityName){
        boolean success = false;

        if(validateUpdate(report, entityName)){
            try {
                success = dao.update(report, entityName);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return success;
    }

    public boolean delete(ProjectReport report, String entityName){
        boolean success = false;

        if(validateDeletion(report, entityName)){
            try {
                success =  dao.delete(report, entityName);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return success;
    }
}
