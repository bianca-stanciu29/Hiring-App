package company.departament;

import company.employee.Employee;
import company.job.Job;

import java.util.ArrayList;

public abstract class Department {
    private ArrayList<Employee> employees;
    private ArrayList<Job> availableJobs;

    public Department(ArrayList<Employee> employees, ArrayList<Job> availableJobs){
        this.employees = employees;
        this.availableJobs = availableJobs;
    }
    public Department() {
        this.employees = new ArrayList<Employee>();
        this.availableJobs = new ArrayList<Job>();
    }
    // Am implementat in fiecare clasa ce mosteneste
    // Department modul de calculare al salariului
    public abstract double getTotalSalaryBudget();

    public ArrayList<Job> getJobs() {
        return availableJobs;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    public void add(Job job) {
        availableJobs.add(job);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "\nemployees=" + employees +
                "\navailableJobs=" + availableJobs +
                '}';
    }
}
