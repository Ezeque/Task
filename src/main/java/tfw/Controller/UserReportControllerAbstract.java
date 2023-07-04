package tfw.Controller;


import tfw.Entity.UserReport;
import tfw.Service.UserReportService;

public abstract class UserReportControllerAbstract {

    UserReport report;
    UserReportService service;

    public abstract boolean create(UserReport report);
    //    GETS DATA IN DATABASE
    public abstract UserReport getReportById(UserReport report);
    public abstract UserReport getReportByUserId(UserReport report);
    //    UPDATE DATA IN DATABASE
    public abstract boolean update(UserReport report);
    //    DELETE DATA IN DATABASE
    public abstract boolean delete(UserReport report);
}
