package main;

import company.Company;
import company.employee.User;
import company.job.Job;

import java.util.ArrayList;
import java.util.List;

public final class Application {
    private ArrayList<Company> companies;
    public ArrayList<User> users;
    private static Application instance = null;


    // Patternul Singleton
    private Application() {
        companies = new ArrayList<>();
        users = new ArrayList<>();
    }
    public static Application getInstance() {
        // Daca nu am instanta o creez
        if (instance == null) {
            instance = new Application();
        }
        // Returnez instanta
        return instance;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public Company getCompany(String name) {
        // Caut o compania care are numele dat ca parametru
        for (Company company : companies) {
            if (company.getName().equals(name)) {
                return company;
            }
        }
        return null;
    }

    public void add(Company company) {
        companies.add(company);
    }

    public void add(User user) {
        users.add(user);
    }

    public boolean remove(Company company) {
        return companies.remove(company);
    }

    public boolean remove(User user) {
        return users.remove(user);
    }

    public ArrayList<Job> getJobs(List<String> companies) {
        // Merg prin toate companiile si retin intr-o lista toate joburiile lor
        ArrayList<Job> jobsList = new ArrayList<>();
        for (String companyName : companies) {
            Company company = getCompany(companyName);
            assert company != null;
            jobsList.addAll(company.getJobs());
        }
        return jobsList;
    }
}
