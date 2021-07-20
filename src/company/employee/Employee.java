package company.employee;

import company.Company;
import company.departament.Department;
import consumer.Consumer;

import java.util.ArrayList;
import java.util.Objects;

public class Employee extends Consumer {
    private String company;
    private double salary;
    public Employee() {

    }

    public Employee(Resume resume,String company, double salary){
        super(resume, new ArrayList<Consumer>());
        this.company = company;
        this.salary = salary;

    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, salary);
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +  "salary= " + salary + "\n";
    }
}
