package company.employee;

import company.Company;
import company.Request;
import company.departament.Department;
import company.job.Job;
import company.observer.Notification;
import company.observer.NotificationType;
import consumer.Consumer;
import main.Application;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Manager extends Employee{
    private List<Request<Job, Consumer>> requests;
    public Manager() {
        requests = new ArrayList<Request<Job, Consumer>>();
    }
    public Manager(Resume resume,String company, double salary){
        super(resume,company,salary);
        requests = new ArrayList<Request<Job, Consumer>>();
    }
    // Primeste o cerere de angajare si o adauga in lista de cereri
    public void receiveRequest(Request<Job, Consumer> request) {
        requests.add(request);
    }

    public void process(Job job) {
        // Daca job-ul nu mai este deschis,
        // nu are de ce sa proceseze
        if (!job.isOpen()) {
            return;
        }
        // Iterez prin lista de cereri de angajare si verific daca
        // se potrivesc cu job-ul primit ca parametru
        for (Request<Job, Consumer> request : requests) {
            if (request.getKey() == job) {
                // Adaug cate un candidat pentru job-ul
                // aferent
                job.addCandidate(request);
            }
        }
        // Sortez descrescator scorul candidatilor
        Collections.sort(job.getCandidates(), (o1, o2) -> o1.getScore() < o2.getScore() ? 1 : -1);
        int counterPositions = 0;
        // Logica de angajare pentru un user, unde am integrat de asemenea si Observer Pattern
        // pentru ca fiecare candidat sa fie instiintat in legatura cu aplicarea sa
        for (Request<Job, Consumer> candidate : job.getCandidates()) {
            // Verific daca s-a atins limita de candidati
            // Daca da, inseamna ca toti ceilalti candidati vor fi instiintati
            // ca nu au fost angajati, iar in caz contrar se vor converti la
            // Employee, vor fi notificati ca au obtinut job-ul, li se va seta
            // salariul, departamentul in care vor lucra(adica unde se gaseste
            // job-ul) si compania pentru care lucreaza
            if (counterPositions >= job.getNoPositions()) {
                ((User) candidate.getValue1()).update(new Notification(NotificationType.RejectedFromJob));
                break;
            } else {
                if (Application.getInstance().remove((User) candidate.getValue1())) {
                    counterPositions++;
                    Employee newEmployee = ((User) candidate.getValue1()).convert();
                    ((User) candidate.getValue1()).update(new Notification(NotificationType.GotTheJob));
                    newEmployee.setSalary(job.getSalary());
                    newEmployee.setCompany(job.getCompany());
                    for(Department d : Application.getInstance().getCompany(job.getCompany()).getDepartments()){
                        if(d.getJobs().contains(job))
                            d.add(newEmployee);
                    }

                    for (Company company : Application.getInstance().getCompanies()) {
                        company.removeObserver((User) candidate.getValue1());
                    }
                }
            }
        }
        // Dupa ce se recruteaza un anumit numar de candidati, job-ul
        // se va inchide
        job.setOpen(false);
        // Se vor sterge cererile pentru acest job
        requests.removeAll(job.getCandidates());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(requests, manager.requests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), requests);
    }

    @Override
    public String toString() {
        return this.getResume() + " ";
    }
}
