package tfw.Entity;

import tfw.Controller.ProjectControllerAbstract;

import java.util.Map;

public abstract class Project {
    private String name;
    private int id;
    private ProjectControllerAbstract controller;

    public Project(int id, String name){
        this.id = id;
        this.name = name;
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
    public abstract Map<String, Object> setMetrics();
}
