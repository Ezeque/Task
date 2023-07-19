package tfw.Entity;

public class ConcreteTask extends Task {
    public ConcreteTask(String name, String type) {
        super(name, type);
    }

    public ConcreteTask(int projectID, String name, int user_Id) {
        super(projectID, name, user_Id);
    }

    public ConcreteTask(String name, int userID) {
        super(name, userID);
    }

    public ConcreteTask(int projectID, String name) {
        super(projectID, name);
    }

    public ConcreteTask(int id, String name, String type) {
        super(id, name, type);
    }

    public ConcreteTask(int id, String name, String type, int userId) {
        super(id, name, type, userId);
    }

    public ConcreteTask(String name, String type, int userId) {
        super(name, type, userId);
    }
}
