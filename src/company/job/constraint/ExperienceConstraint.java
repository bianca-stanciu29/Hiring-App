package company.job.constraint;

import company.employee.User;

public final class ExperienceConstraint extends Constraint {

    public ExperienceConstraint(int inf, int sup) {
        super((double)inf, (double)sup);
    }

    @Override
    public boolean meetsRequirements(User user) {
        return inf <= user.getExperienceYears() && user.getExperienceYears() <= sup;
    }
}
