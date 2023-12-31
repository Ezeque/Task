package tfw.Entity;

import tfw.Controller.TaskControllerAbstract;

public abstract class Task {
    private String name;
    private int id;
    private String type;
    private TaskControllerAbstract controller;
    private int userID = 0;
    private int projectID = 0;

    public Task(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Task(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Task(int id, String name, String type, int userId, int projectID) {
        this.name = name;
        this.type = type;
        this.userID = userId;
        this.projectID = projectID;
    }

    public Task(int id, String name, String type, int userId) {
        this.name = name;
        this.type = type;
        this.userID = userId;
    }

    public Task(String name, String type, int userId) {
        this.name = name;
        this.type = type;
        this.userID = userId;
    }

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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
}
