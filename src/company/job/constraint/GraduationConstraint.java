package company.job.constraint;

import company.employee.User;

public final class GraduationConstraint extends Constraint{
    public GraduationConstraint(int inf, int sup) {
        super((double) inf, (double) sup);
    }

    @Override
    public boolean meetsRequirements(User user) {
        return inf <= user.getGraduationYear() && user.getGraduationYear() <= sup;
    }
}
