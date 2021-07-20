package company.departament;

import company.employee.Employee;
import company.job.Job;

import java.util.ArrayList;

public final class Management extends Department {
    public Management(ArrayList<Employee> employees, ArrayList<Job> availableJobs){
        super(employees,availableJobs);
    }
    @Override
    public double getTotalSalaryBudget() {
        double sum = 0.0;
        for (Employee employee : getEmployees()) {
            sum += employee.getSalary() + employee.getSalary() * 0.16;
        }
        return sum;
    }
}
