package tfw.Entity;


import java.util.Map;

public abstract class User {
    private String name;
    private String email;
    private String password;
    private int id;

    protected int id_setor;
    public User(){

    }

    public User(String name, String email, String password, int id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public User(String name, String email, String password, int id, int id_setor) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = id;
        this.id_setor = id_setor;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setIdSetor(int id_setor){
        this.id_setor = id_setor;
    }

    public int getIdSetor(){
        return this.id_setor;
    }
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public int getId() {
        return this.id;
    }

    public abstract Map<String, Integer> setMetrics();


}
