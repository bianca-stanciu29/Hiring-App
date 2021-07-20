package company.employee;

import company.Company;
import company.observer.Notification;
import company.observer.Observer;
import consumer.Consumer;
import main.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class User extends Consumer implements Observer {
    List<String> interested_companies;
    public User(Resume resume,ArrayList<String> interested_companies){
        super(resume, new ArrayList<>());
        this.interested_companies = interested_companies;
    }
    public Employee convert() {
        Employee employee = new Employee();
        employee.setResume(this.getResume());
        employee.setAcquaintances(this.getAcquaintances());
        Application.getInstance().remove(this);
        return employee;
    }

    public Double getTotalScore() {
        return getExperienceYears() * 1.5 + getGraduationYear();
    }

    @Override
    public void update(Notification notification) {
        // Primeste notificare dar nu este specificat in enunt
        // ce ar trebui sa faca cu aceasta
        System.out.println(notification);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(interested_companies, user.interested_companies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interested_companies);
    }
}
