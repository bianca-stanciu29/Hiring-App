package company.job;

import company.Company;
import company.Request;
import company.departament.Department;
import company.employee.Recruiter;
import company.employee.User;
import company.job.constraint.ExperienceConstraint;
import company.job.constraint.GPAConstraint;
import company.job.constraint.GraduationConstraint;
import consumer.Consumer;
import main.Application;

import java.util.ArrayList;
import java.util.List;

public final class Job {
    private String name;
    private String company;
    private boolean isOpen;
    private ExperienceConstraint experienceConstraint;
    private GPAConstraint gpaConstraint;
    private GraduationConstraint graduationConstraint;
    private List<Request<Job, Consumer>> candidates;
    private String department;
    private int noPositions;
    private double salary;

    public Job() {
        this.candidates = new ArrayList<>();
        this.isOpen = true;
    }
     public Job(String name, String company, ExperienceConstraint experienceConstraint
     , GPAConstraint gpaConstraint, GraduationConstraint graduationConstraint, int noPositions, double salary)
     {
         this.name = name;
         this.company = company;
         isOpen = true;
         this.experienceConstraint = experienceConstraint;
         this.gpaConstraint = gpaConstraint;
         this.graduationConstraint = graduationConstraint;
         candidates = new ArrayList<>();
         this.noPositions = noPositions;
         this.salary = salary;
     }
    // Cand un User aplica la un job, trebuie
    // sa se tina cont de urmatoarele conditii:
    // - trebuie ca job-ul sa fie deschis;
    // - trebuie sa indeplineasca constrangerile
    // de experienta, medie, si anul absolvirii.
    // Daca sunt indeplinite aceste conditii,
    // se va apela metoda evaluate pentru User
    // si pentru job-ul aferent
    public void apply(User user) {
        if (!isOpen) {
            return;
        }
        if(!meetsRequirements(user)) {
            return;
        }
        Recruiter recruiter = Application.getInstance().getCompany(company).getRecruiter(user);
        recruiter.evaluate(this, user);
        Application.getInstance().getCompany(company).addObserver(user);
    }

    // Trebuie sa fie indeplinite metodele de meetsRequirements
    // din fiecare tip de constrangere
    public boolean meetsRequirements(User user) {
        return experienceConstraint.meetsRequirements(user) && gpaConstraint.meetsRequirements(user)
                && graduationConstraint.meetsRequirements(user);
    }

    public int getNoPositions() {
        return noPositions;
    }

    public List<Request<Job, Consumer>> getCandidates() {
        return candidates;
    }

    public void addCandidate(Request<Job, Consumer> newCandidate) {
        candidates.add(newCandidate);
    }

    public double getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }

    public String getDepartment() {
        return department;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", isOpen=" + isOpen +
                ", experienceConstraint=" + experienceConstraint +
                ", gpaConstraint=" + gpaConstraint +
                ", graduationConstraint=" + graduationConstraint +
                ", candidates=" + candidates +
                ", department='" + department + '\'' +
                ", noPositions=" + noPositions +
                ", salary=" + salary +
                '}';
    }
}
