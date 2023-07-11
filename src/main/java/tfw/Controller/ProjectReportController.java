package tfw.Controller;


import tfw.Entity.ProjectReport;

public class ProjectReportController extends ProjectReportControllerAbstract {

    @Override
    public boolean create(ProjectReport report) {
        return service.create(report);
    }

    //    GETS DATA IN DATABASE
    @Override
    public ProjectReport getReportById(ProjectReport report) {
        return service.getReportById(report);
    }

    @Override
    public ProjectReport getReportByProjectId(ProjectReport report) {
        return service.getReportById(report);
    }

    //    UPDATE DATA IN DATABASE
    @Override
    public boolean update(ProjectReport report) {
        return service.update(report);
    }

    //    DELETE DATA IN DATABASE
    @Override
    public boolean delete(ProjectReport report) {
        return service.delete(report);
    }
}
