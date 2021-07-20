package company.departament;

import company.employee.Employee;
import company.job.Job;

import java.util.ArrayList;

public final class Finance extends Department{
    public Finance(ArrayList<Employee> employees, ArrayList<Job> availableJobs){
        super(employees,availableJobs);
    }
    @Override
    public double getTotalSalaryBudget() {
        double sum = 0.0;
        for (Employee employee : getEmployees()) {
            if (employee.getExperienceYears() <= 1) {
                sum += employee.getSalary() + employee.getSalary() * 0.1;
            } else {
                sum += employee.getSalary() + employee.getSalary() * 0.16;
            }
        }
        return sum;
    }
}
