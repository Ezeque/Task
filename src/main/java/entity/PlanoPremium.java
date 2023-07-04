package entity;

public class PlanoPremium extends Plano {

    public PlanoPremium() {
        super(3, "Premium", 100, 7);
    }

    public PlanoPremium(String name, int valor, int diasPermitidos) {
        super(name, valor, diasPermitidos);
    }
}
