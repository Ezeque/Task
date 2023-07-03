package entity;

public class PlanoBasico extends Plano {
    public PlanoBasico() {
        super(1, "Básico", 70, 4);
    }

    public PlanoBasico(String name, int valor, int diasPermitidos) {
        super(name, valor, diasPermitidos);
    }
}
