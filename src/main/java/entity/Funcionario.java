package entity;

import tfw.Entity.User;

import java.util.HashMap;
import java.util.Map;

public class Funcionario extends User {

    private int gerente;
    public Funcionario(){

    }

    public int getStatus(){
        return gerente;
    }

    public boolean eGerente(){
        return gerente == 1;
    }

    public void setStatus(int gerente){
        this.gerente = gerente;
    }
    public Funcionario(String name, String email, String password, int id) {
        super(name, email, password, id);
    }

    public Funcionario(String name, String email, String password) {
        super(name, email, password);
    }

    public Funcionario(int id, String email) {
        super(id, email);
    }

    public Funcionario(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    @Override
    public Map<String, Integer> setMetrics() {
        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("n_chamados", 0);
        metrics.put("n_chamados_concluidos", 0);
        metrics.put("porcentagem_chamados_concluidos", 0);

        return metrics;
    }

    public void printFuncionario(){
        System.out.println("Nome: " + getName());
        System.out.println("Email: " + getEmail());
        if(gerente == 1) System.out.println("É Gerente: sim");
        if(gerente == 9) System.out.println("É Gerente: não");
    }
}
