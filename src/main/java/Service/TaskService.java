package Service;

import Dao.DAO;
import Entity.Task;

public abstract class TaskService {
    Task task;
    DAO dao;

    public abstract boolean validate(Task task);
}
