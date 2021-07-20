package company.job.constraint;

import company.employee.User;

public final class GPAConstraint extends Constraint {
    public GPAConstraint(Double inf, Double sup) {
        super(inf, sup);
    }

    @Override
    public boolean meetsRequirements(User user) {
        return inf <= user.meanGPA() && user.meanGPA() <= sup;
    }
}
