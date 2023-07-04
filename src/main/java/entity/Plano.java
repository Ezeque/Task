package entity;

import tfw.Entity.Project;

import java.util.Map;

public class Plano extends Project {
    int diasPermitidos;
    int valor;

    public Plano() {
        super();
    }

    public Plano(int id, String name, int valor, int diasPermitidos) {
        super(id, name);
        this.valor = valor;
        this.diasPermitidos = diasPermitidos;
    }

    public Plano(String name, int valor, int diasPermitidos) {
        super(name);
        this.valor = valor;
        this.diasPermitidos = diasPermitidos;
    }

    @Override
    public Map<String, Object> setMetrics() {
        return null;
    }

    public int getValor() {
        return this.valor;
    }

    public int getDiasPermitidos() {
        return diasPermitidos;
    }

    public void setDiasPermitidos(int diasPermitidos) {
        this.diasPermitidos = diasPermitidos;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }
}
