package entity;

public class PlanoPlus extends Plano {
    String name = "Plus";
    int valor = 90;
    int diasPermitidos = 6;

    public PlanoPlus() {
        super(2, "Plus", 90, 6);
    }

    public PlanoPlus(String name, int valor, int diasPermitidos) {
        super(name, valor, diasPermitidos);
    }
}
