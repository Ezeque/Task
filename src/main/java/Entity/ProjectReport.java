package Entity;

public abstract class ProjectReport {
    private int id;
    private int project_id;

    public ProjectReport(){

    }

    public ProjectReport(int project_id){
        this.project_id = project_id;
    }


    public void setId(int id){
        this.id = id;
    }

    public void setProject_id(int project_id){
        this.project_id = project_id;
    }

    public int getId(){
        return this.id;
    }

    public int getProjectId(){
        return this.project_id;
    }
}
