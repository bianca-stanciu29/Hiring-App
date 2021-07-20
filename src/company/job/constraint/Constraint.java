package company.job.constraint;

import company.employee.User;

public abstract class Constraint {
    protected Double inf;
    protected Double sup;

    public Constraint(Double inf, Double sup) {
        this.inf = inf;
        this.sup = sup;
    }
    // Metoda impelemntata in cele 3 tipuri de Constraint
    public abstract boolean meetsRequirements(User user);
}
