package Entity;

import Controller.TaskControllerAbstract;

public abstract class Task {
    private String name;
    private int id;
    private String type;
    private TaskControllerAbstract controller;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
