package company;

import company.departament.Department;
import company.employee.Employee;
import company.employee.Manager;
import company.employee.Recruiter;
import company.employee.User;
import company.job.Job;
import company.observer.Notification;
import company.observer.NotificationType;
import company.observer.Observer;
import company.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public final class Company implements Subject {
    private String name;
    private Manager manager;
    private ArrayList<Department> departments;
    private ArrayList<Recruiter> recruiters;
    private ArrayList<Job> jobs;
    private ArrayList<Observer> observers;

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public Company() {
        this.departments = new ArrayList<>();
        this.recruiters = new ArrayList<>();
        this.jobs = new ArrayList<>();
        this.observers = new ArrayList<>();
    }
    public Company(String name, Manager manager, ArrayList<Department> departments,
                   ArrayList<Recruiter> recruiters, ArrayList<Job> jobs, ArrayList<Observer> observers){
        this.name = name;
        this.manager = manager;
        this.departments = departments;
        this.recruiters = recruiters;
        this.jobs = jobs;
        this.observers = observers;
    }
    public void add(Department department) {
        departments.add(department);
    }

    public void add(Recruiter recruiter) {
        recruiters.add(recruiter);
    }

    public void add(Employee employee, Department department) {
        department.add(employee);
    }

    public void remove(Employee employee) {
        for (Department department : departments) {
            department.remove(employee);
        }
    }

    public void remove(Department department) {
        // Sterg departamentul
        departments.remove(department);
        // Scot toti angajatii din departament
        department.getEmployees().clear();
    }

    public void remove(Recruiter recruiter) {
        recruiters.remove(recruiter);
    }

    public void move(Department source, Department destination) {
        // Mut angajatii in noul departament
        destination.getEmployees().addAll(source.getEmployees());
        // Scot toti angajatii din departamentul vechi
        remove(source);
    }

    public void move(Employee employee, Department newDepartment) {
        // Adaug angajatul in departamentul nou
        newDepartment.add(employee);

        // Scot angajatul din departamentul vechi
        for(Department department : departments){
            for(Employee e : department.getEmployees()){
                if(e.equals(employee))
                    department.remove(employee);
            }
        }
    }

    public boolean contains(Department department) {
        return departments.contains(department);
    }

    public boolean contains(Employee employee) {
        // Verifica pentru fiecare departament daca angajatul se afla in el
        for (Department department : departments) {
            if (department.getEmployees().contains(employee)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Recruiter recruiter) {
        return recruiters.contains(recruiter);
    }

    public Recruiter getRecruiter(User user) {
        // Voi merge prin toti recruiteri si ii voi selecta dupa distanta cea mai mare,
        // iar in caz de egalitate dupa rating
        // In best voi avea cel mai bun recruiter pentru utilizatorul dat ca parametru
        Recruiter best = null;
        for (Recruiter recruiter : recruiters) {
            if (best == null ||
                    user.getDegreeInFriendship(best) < user.getDegreeInFriendship(recruiter) ||
                    (user.getDegreeInFriendship(best) == user.getDegreeInFriendship(recruiter) &&
                            best.getRating() < recruiter.getRating())) {
                best = recruiter;
            }
        }
        return best;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public Manager getManager() {
        return manager;
    }


    public String getName() {
        return name;
    }

    @Override
    public void addObserver(User user) {
        observers.add(user);
    }

    @Override
    public void removeObserver(User user) {
        observers.remove(user);
    }

    @Override
    public void notifyAllObservers() {
        // Trec printre observeri si ii notific
        for (Observer user : observers) {
            user.update(new Notification(NotificationType.NewJob));
        }
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "\nmanager=" + manager +
                "\ndepartments=" + departments +
                "\nrecruiters=" + recruiters +
                "\njobs=" + jobs +
                "\nobservers=" + observers;
    }
}
