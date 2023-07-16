package entity;

import tfw.Entity.Task;

public class Chamado extends Task {


    public Chamado(String name, String description, int projectId, int userId){
        super(name, description, projectId, userId);
    }

    public Chamado(){
        super();
    }

}
