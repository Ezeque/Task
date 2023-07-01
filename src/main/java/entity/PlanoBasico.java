package entity;

public class PlanoBasico extends Plano {
    String name = "Básico";
    int valor = 70;
    int diasPermitidos = 4;

    public PlanoBasico() {
        
    }

    public PlanoBasico(String name, int valor, int diasPermitidos) {
        super(name, valor, diasPermitidos);
    }
}
