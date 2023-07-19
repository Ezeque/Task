package tfw.Entity;

import tfw.Controller.ProjectControllerAbstract;

import java.util.Map;

public abstract class Project {
    private String name;
    private int id;

    protected int userId;
    private ProjectControllerAbstract controller;

    public Project(int id, String name, int userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public Project(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    //RETURNS AN OBJECT CONTAINING THE METRICS USED TO MAKE A REPORT
    public abstract Map<String, Integer> setMetrics();

    public int getUserId() {
        return userId;
    }
}
