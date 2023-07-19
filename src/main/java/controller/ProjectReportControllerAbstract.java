package Controller;


import Entity.ProjectReport;
import Service.ProjectReportService;

public abstract class ProjectReportControllerAbstract {

    ProjectReport report;
    ProjectReportService service;

    public abstract boolean create(ProjectReport report);

    //    GETS DATA IN DATABASE
    public abstract ProjectReport getReportById(ProjectReport report);

    public abstract ProjectReport getReportByProjectId(ProjectReport report);

    //    UPDATE DATA IN DATABASE
    public abstract boolean update(ProjectReport report);

    //    DELETE DATA IN DATABASE
    public abstract boolean delete(ProjectReport report);
}
