package Controller;


import Entity.ProjectReport;

public class ProjectReportController extends ProjectReportControllerAbstract{

    @Override
    public boolean create(ProjectReport report, String entityName){
        return service.create(report, entityName);
    }
    //    GETS DATA IN DATABASE
    @Override
    public ProjectReport getReportById(ProjectReport report, String entityName){
        return service.getReportById(report, entityName);
    }
    @Override
    public ProjectReport getReportByProjectId(ProjectReport report, String entityName){
        return service.getReportById(report, entityName);
    }
    //    UPDATE DATA IN DATABASE
    @Override
    public boolean update(ProjectReport report, String entityName){
        return service.update(report, entityName);
    }
    //    DELETE DATA IN DATABASE
    @Override
    public boolean delete(ProjectReport report, String entityName){
        return service.delete(report, entityName);
    }
}
