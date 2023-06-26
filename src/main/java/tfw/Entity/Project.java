package tfw.Entity;

import tfw.Controller.ProjectControllerAbstract;

public abstract class Project {
    private String name;
    private int id;
    private ProjectControllerAbstract controller;

    public void Project(int id, String name){
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

    public abstract Object setMetrics();
}
