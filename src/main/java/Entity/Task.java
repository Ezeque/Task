package Entity;

import Controller.TaskController;

public abstract class Task {
    private String type;
    private TaskController controller;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
