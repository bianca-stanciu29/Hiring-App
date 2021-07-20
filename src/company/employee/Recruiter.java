package company.employee;

import company.Request;
import company.job.Job;
import consumer.Consumer;
import main.Application;

import java.util.ArrayList;
import java.util.Objects;

public final class Recruiter extends Employee {
    private double rating;

    public Recruiter () {
        this.rating = 5.0;
    }
    public Recruiter(Resume resume, String company, double salary, double rating){
        super(resume,company,salary);
        this.rating = rating;

    }
    // un Recruiter evalueaza scorul unui User
    public int evaluate(Job job, User user) {
       int evaluation = (int) (rating * user.getTotalScore());
       rating += 0.1;
       Request<Job, Consumer> request = new Request<Job, Consumer>(job, user, this, (double) evaluation);
       // trimit cererea catre manager
       Application.getInstance().getCompany(getCompany()).getManager().receiveRequest(request);
       return evaluation;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recruiter)) return false;
        if (!super.equals(o)) return false;
        Recruiter recruiter = (Recruiter) o;
        return Double.compare(recruiter.rating, rating) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rating);
    }
}
