package entity;

public class PlanoPremium extends Plano {
    String name = "Plus";
    int valor = 100;
    int diasPermitidos = 7;

    public PlanoPremium() {

    }

    public PlanoPremium(String name, int valor, int diasPermitidos) {
        super(name, valor, diasPermitidos);
    }
}
