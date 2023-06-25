package Controller;


import Entity.ProjectReport;
import Service.ProjectReportService;

public abstract class  ProjectReportControllerAbstract {

    ProjectReport report;
    ProjectReportService service;

    public abstract boolean create(ProjectReport report, String entityName);
    //    GETS DATA IN DATABASE
    public abstract ProjectReport getReportById(ProjectReport report, String entityName);
    public abstract ProjectReport getReportByProjectId(ProjectReport report, String entityName);
    //    UPDATE DATA IN DATABASE
    public abstract boolean update(ProjectReport report, String entityName);
    //    DELETE DATA IN DATABASE
    public abstract boolean delete(ProjectReport report, String entityName);
}
