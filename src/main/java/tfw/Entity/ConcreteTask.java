package tfw.Entity;

public class ConcreteTask extends Task {
    public ConcreteTask(String name, String type) {
        super(name, type);
    }

    public ConcreteTask(int id, String name, String type) {
        super(id, name, type);
    }
}
