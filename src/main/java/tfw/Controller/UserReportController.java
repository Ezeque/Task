package tfw.Controller;


import tfw.Entity.UserReport;
import tfw.Service.UserReportService;

public class UserReportController extends UserReportControllerAbstract {

    protected UserReportService service;

    public UserReportController(UserReportService service) {
        this.service = service;
    }

    @Override
    public boolean create(UserReport report) {
        return service.create(report);
    }

    //    GETS DATA IN DATABASE
    @Override
    public UserReport getReportById(UserReport report) {
        return service.getReportById(report);
    }

    @Override
    public UserReport getReportByUserId(UserReport report) {
        return service.getReportById(report);
    }

    //    UPDATE DATA IN DATABASE
    @Override
    public boolean update(UserReport report) {
        return service.update(report);
    }

    //    DELETE DATA IN DATABASE
    @Override
    public boolean delete(UserReport report) {
        return service.delete(report);
    }
}
