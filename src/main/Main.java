package main;

import company.Company;
import company.departament.Department;
import company.departament.DepartmentFactory;
import company.employee.Employee;
import company.employee.Manager;
import company.employee.Recruiter;
import company.employee.User;
import company.job.Job;
import company.job.constraint.ExperienceConstraint;
import company.job.constraint.GPAConstraint;
import company.job.constraint.GraduationConstraint;
import company.observer.Observer;
import consumer.Consumer;
import consumer.resume.*;


import javax.swing.*;
import java.awt.*;
import java.awt.desktop.AppForegroundListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(java.lang.String[] args) throws Consumer.ResumeIncompleteException, InvalidDatesException {


        User user1 = new User(new Consumer.Resume.ResumeBuilder().firstName("Daniel")
                .lastName("Edmund")
                .email("dedmund@gmail.com")
                .phone("+4444444444")
                .birthDate(new Date(1982,10,20))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French" , "Begginer" ))
                .education( new Education("highschool","Gilbert Classical Academy",
                        new Date(2003,9,1),
                        new Date(2011,6,1),6.75))
                .education( new Education("college","MIT",
                        new Date(2007,8,1),
                        new Date(2012,8,1),8.8))
                .education( new Education("masters","MIT",
                        new Date(2015,8,1),
                        new Date(2015,8,1),9.35))
                .experience(new Experience("MIT","Researcher",
                        new Date(2015,5,1), new Date(2016,6,1)))
                .build(),new ArrayList<String>(Arrays.asList(new String[]{"Google", "Amazon"})));
        //user1.setResume(resume);

        User user2 = new User(new Consumer.Resume.ResumeBuilder().firstName("Julia")
                .lastName("Matvei")
                .email("jmatvei@gmail.com")
                .phone("+455555555")
                .birthDate(new Date(1988,11,10))
                .sex("female")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("German" , "Begginer" ))
                .education( new Education("highschool","Stanton College Preparatory School",
                        new Date(2010,9,1),
                        new Date(2014,6,1),9.2))
                .education( new Education("college","University of Warwick",
                        new Date(2014,10,1),
                        new Date(2018,6,1),9.4))
                .education( new Education("masters","University of Oxford",
                        new Date(2018,8,1),
                        null,10.00))
                .experience(new Experience("NXP","SDE",
                        new Date(2015,5,1), new Date(2017,3,1)))
                .build(),new ArrayList<String>(Arrays.asList(new String[]{"Google", "Amazon"})));
        //user2.setResume(resume2);

        User user3 = new User(new Consumer.Resume.ResumeBuilder().firstName("Tamara")
                .lastName("Haci")
                .email("thaci@gmail.com")
                .phone("+4444444444")
                .birthDate(new Date(1988,2,15))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .education( new Education("highschool","Downingtown STEM Academy",
                        new Date(2005,9,1),
                        new Date(2009,8,1),10.00))
                .education( new Education("college","Ecole polytechnique",
                        new Date(2009,8,1),
                        new Date(2014,6,1),9.1))
                .experience(new Experience("Microsoft","SDE",
                        new Date(2015,10,1), new Date(2016,3,1)))
                .experience(new Experience("JP Morgan","SDE",
                        new Date(2016,6,1), new Date(2017,11,1)))
                .experience(new Experience("Bloomberg","SDE",
                        new Date(2017,5,1), new Date(2018,8,1)))
                .build(),new ArrayList<String>(Arrays.asList(new String[]{"Google", "Amazon"})));
        //user3.setResume(resume3);

        User user4 = new User(new Consumer.Resume.ResumeBuilder().firstName("Linette")
                .lastName("Spartak")
                .email("lspartak@gmail.com")
                .phone("+444444444")
                .birthDate(new Date(1998,8,5))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French" , "Experienced" ))
                .language(new Language("Russian" , "Advanced" ))
                .language(new Language("Portuguess" , "Begginer" ))
                .education( new Education("highschool",
                        "Thomas Jefferson High School for Science and Technology",
                        new Date(2000,8,1),
                        new Date(2004,6,1),8.9))
                .education( new Education("college","University of Manchester",
                        new Date(2004,8,1),
                        new Date(2008,6,1),9.75))

                .experience(new Experience("Google","CEO",
                        new Date(2018,5,1), null))
                .build(),new ArrayList<String>(Arrays.asList(new String[]{"Google", "Amazon"})));
        //user4.setResume(resume4);


        Employee employee1  = new Employee(new Consumer.Resume.ResumeBuilder().firstName("Harmony")
                .lastName("Lorinda")
                .email("harmonyl@gmail.com")
                .phone("+411111111")
                .birthDate(new Date(1986,1,12))
                .sex("female")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French","Beginner"))
                .education(new Education("highschool",
                        "Thomas Jefferson High School for Science and Technology"
                        ,new Date(2000,8,1),
                        new Date(2004,6,1),9.75))
                .education(new Education("college",
                        "MIT"
                        ,new Date(2004,8,1),
                        new Date(2008,6,1),9.00))
                .experience( new Experience("Google","SDE",
                        new Date(2006,7,1), new Date(2010,4,1)))
                .experience( new Experience("Amazon","Senior SDE",
                        new Date(2010,5,1), null))
                .build(),
                "Amazon", 5000);

        Employee employee2  = new Employee(new Consumer.Resume.ResumeBuilder().firstName("Shanna")
                .lastName("Addy")
                .email("shanad@gmail.com")
                .phone("+4111111112")
                .birthDate(new Date(1995,4,20))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("German","Experienced"))
                .education(new Education("highschool",
                        "Heidelberg American High School"
                        ,new Date(2010,8,1),
                        new Date(2014,6,1),8.87))
                .education(new Education("college",
                        "University of Munich"
                        ,new Date(2014,8,1),
                        new Date(2018,6,1),9.65))
                .experience( new Experience("Amazon","Manager",
                        new Date(2010,5,1), null))
                .build(),
                "Amazon", 3000);

        Employee employee3  = new Employee(new Consumer.Resume.ResumeBuilder().firstName("Leyla")
                .lastName("Stacy")
                .email("leylas@gmail.com")
                .phone("+41111111113")
                .birthDate(new Date(1994,11,27))
                .sex("female")
                .language(new Language("English" , "Experienced" ))
                .education(new Education("highschool",
                        "Kings High School"
                        ,new Date(2015,8,1),
                        new Date(2019,6,1),8.87))
                .education(new Education("college",
                        "King’s College"
                        ,new Date(2019,10,1),
                        null,9.89))
                .experience( new Experience("Amazon","Marketing Intern",
                        new Date(2010,5,1), null))
                .build(),
                "Amazon", 3500);

        Employee employee4  = new Employee(new Consumer.Resume.ResumeBuilder().firstName("Jarred")
                .lastName("Egbert")
                .email("jarredeg@gmail.com")
                .phone("+41111111114")
                .birthDate(new Date(1986,10,7))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("German","Advanced"))
                .education(new Education("highschool",
                        "Heidelberg American High School "
                        ,new Date(2002,8,1),
                        new Date(2006,6,1),8.87))
                .education(new Education("college",
                        "University of Oxford"
                        ,new Date(2006,8,1),
                        new Date(2009,6,1),8.75))
                .experience( new Experience("JP Morgan","Intern",
                        new Date(2009,4,1), new Date(2011,7,1)))
                .experience( new Experience("Goldman Sachs","Analyst",
                        new Date(2013,10,1), new Date(2017,10,1)))
                .experience( new Experience("Amazon","Analyst",
                        new Date(2018,2,1), null))
                .build(),
                "Amazon", 8500);

        Employee employee5  = new Employee(new Consumer.Resume.ResumeBuilder().firstName("Bethney")
                .lastName("Kiara")
                .email("bethneyk@gmail.com")
                .phone("+4111111115")
                .birthDate(new Date(1993,10,10))
                .sex("female")
                .language(new Language("English" , "Experienced" ))
                .education(new Education("highschool",
                        "Aquinas High School"
                        ,new Date(2011,10,1),
                        new Date(2015,7,1),7.80))
                .education(new Education("college",
                        "Stanford University"
                        ,new Date(2015,8,1),
                        new Date(2019,7,1),9.25))
                .experience( new Experience("Amazon","Marketing agent",
                        new Date(2019,7,1), null))
                .build(),
                "Amazon", 6000);

        Employee employee6  = new Employee(new Consumer.Resume.ResumeBuilder().firstName("Rolland")
                .lastName("Lyla")
                .email("rollandly@gmail.com")
                .phone("+41111111116")
                .birthDate(new Date(1986,1,1))
                .sex("female")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French","Experienced"))
                .education(new Education("highschool",
                        "ICS Paris "
                        ,new Date(2005,8,1),
                        new Date(2009,6,1),8.9))
                .education(new Education("college",
                        "Ecole Polytechnique"
                        ,new Date(2009,8,1),
                        new Date(2013,6,1),9.35))
                .experience( new Experience("Goolge","Intern SDE",
                        new Date(2013,7,1), new Date(2013,10,1)))
                .experience( new Experience("Softwire","SDE",
                        new Date(2014,9,1), new Date(2015,1,1)))
                .experience( new Experience("Bloomberg","SDE",
                        new Date(2015,5,1), new Date(2016,10,1)))
                .experience(new Experience("Google","Senior SDE",
                        new Date(2017,3,1),null))
                .build(),
                "Google", 9000);

        Employee employee7  = new Employee(new Consumer.Resume.ResumeBuilder().firstName("Steward")
                .lastName("Goodwin")
                .email("stewardg@gmail.com")
                .phone("+41111111117")
                .birthDate(new Date(1996,4,13))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .education(new Education("highschool",
                        "Tornados High School "
                        ,new Date(2010,8,1),
                        new Date(2014,6,1),8.05))
                .education(new Education("college",
                        "University of Groningen"
                        ,new Date(2014,10,1),
                        new Date(2018,7,1),7.6))
                .experience( new Experience("Google","Manager",
                        new Date(2018,7,1), null))
                .build(),
                "Google", 4500);

        Employee employee8  = new Employee(new Consumer.Resume.ResumeBuilder().firstName("Molly")
                .lastName("Rylie")
                .email("mollyr@gmail.com")
                .phone("+41111111118")
                .birthDate(new Date(1976,4,3))
                .sex("female")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French" , "Experienced" ))
                .language(new Language("Chinese" , "Beginner" ))
                .education(new Education("highschool",
                        "Kspace International School "
                        ,new Date(1998,8,1),
                        new Date(2002,7,1),9.87))
                .education(new Education("college",
                        "University of Oxford"
                        ,new Date(2002,8,1),
                        new Date(2006,6,1),9.83))
                .experience( new Experience("Sofwire","Marketing",
                        new Date(2006,7,1), new Date(2010,4,1)))
                .experience( new Experience("Google","Researcher",
                        new Date(2011,6,1), new Date(2012,10,1)))
                .experience( new Experience("Amazon","Researcher",
                        new Date(2013,2,1), new Date(2014,5,1)))
                .experience( new Experience("Google","Researcher",
                        new Date(2015,10,1), null))
                .build(),
                "Google", 10000);

        Employee employee9  = new Employee(new Consumer.Resume.ResumeBuilder().firstName("Morley")
                .lastName("Denise")
                .email("morleyd@gmail.com")
                .phone("+41111111119")
                .birthDate(new Date(1997,1,1))
                .sex("female")
                .language(new Language("English" , "Experienced" ))
                .education(new Education("highschool",
                        "National High School of Berlin "
                        ,new Date(2014,8,1),
                        new Date(2018,7,1),10.00))
                .education(new Education("college",
                        "Jacobs University"
                        ,new Date(2018,8,1),
                        null,9.45))
                .experience( new Experience("Google","Finance Intern",
                        new Date(2020,7,1), null))
                .build(),
                "Google", 3500);

        Employee employee10  = new Employee(new Consumer.Resume.ResumeBuilder().firstName("Bryson")
                .lastName("Reenie")
                .email("brysonr@gmail.com")
                .phone("+411111111110")
                .birthDate(new Date(1983,3,18))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French" , "Advanced" ))
                .language(new Language("German" , "Experienced" ))
                .education(new Education("highschool",
                        "Jamaica Plain High School "
                        ,new Date(2001,8,1),
                        new Date(2005,6,1),9.5))
                .education(new Education("college",
                        "Harvard"
                        ,new Date(2006,8,1),
                        new Date(2011,6,1),7.65))
                .experience( new Experience("Softwire","Marketing",
                        new Date(2011,7,1), new Date(2015,4,1)))
                .experience( new Experience("Google","Marketing",
                        new Date(2011,10,1), null))
                .build(),
                "Google", 10000);


        Recruiter recruiter1 = new Recruiter(new Consumer.Resume.ResumeBuilder().firstName("Jonie")
                .lastName("Phillip")
                .email("jphilip@gmail.com")
                .phone("+4123456789")
                .birthDate(new Date(1980,2,2))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French" , "Experienced" ))
                .education(new Education("highschool",
                        "High School of Brussels"
                        ,new Date(2000,8,1),
                        new Date(2004,6,1),9.6))
                .education(new Education("college",
                        "University of Oxford"
                        ,new Date(2004,8,1),
                        new Date(2008,6,1),8.8))
                .experience( new Experience("Playtika","Recruiter",

                        new Date(2011,7,1), new Date(2015,4,1)))
                .experience( new Experience("Google","Marketing",
                        new Date(2011,10,1), null))
                .build(), "Google",8000,5);

        Recruiter recruiter2 = new Recruiter(new Consumer.Resume.ResumeBuilder().firstName("Janine")
                .lastName("Woody")
                .email("jwoody@gmail.com")
                .phone("+4123456987")
                .birthDate(new Date(1989,12,12))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French" , "Advanced" ))
                .education(new Education("highschool",
                        "Thomas Jefferson High School for Science and Technology"
                        ,new Date(2006,8,1),
                        new Date(2010,6,1),9.75))
                .education(new Education("college",
                        "MIT"
                        ,new Date(2010,8,1),
                        new Date(2014,6,1),9.8))
                .experience( new Experience("Google","Recruiter",
                        new Date(2012,10,1), null))
                .build(), "Google",8000,5);

        Recruiter recruiter3 = new Recruiter(new Consumer.Resume.ResumeBuilder().firstName("Darrell")
                .lastName("Lillie")
                .email("dlillie@amazon.com")
                .phone("+4333333333")
                .birthDate(new Date(1983,5,5))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .education(new Education("highschool",
                        "Crestview High School"
                        ,new Date(2009,8,1),
                        new Date(2013,6,1),8.75))
                .education(new Education("college",
                        "Bristol University"
                        ,new Date(2013,8,1),
                        new Date(2017,6,1),9.8))
                .experience( new Experience("Amazon","Recruiter",
                        new Date(2018,1,1), null))
                .build(), "Amazon",5000,5);

        Recruiter recruiter4 = new Recruiter(new Consumer.Resume.ResumeBuilder().firstName("Damian")
                .lastName("Bodhi")
                .email("dbodhi@amazon.com")
                .phone("+4444444444")
                .birthDate(new Date(1988,6,29))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French" , "Beginner" ))
                .education(new Education("highschool",
                        "Enterprise School"
                        ,new Date(2007,8,1),
                        new Date(2011,6,1),9.9))
                .education(new Education("college",
                        "MIT"
                        ,new Date(2011,6,1),
                        new Date(2014,7,1),9.65))
                .experience( new Experience("Microsoft","Recruiter",
                        new Date(2014,1,1), new Date(2014,5,1)))
                .experience( new Experience("Amazon","Recruiter",
                        new Date(2014,1,1), null))
                .build(), "Amazon",9000,5);

        Manager manager1 = new Manager(new Consumer.Resume.ResumeBuilder().firstName("Sundar")
                .lastName("Pichai")
                .email("spichai@gmail.com")
                .phone("+4444444444")
                .birthDate(new Date(1972,7,12))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French" , "Experienced" ))
                .language(new Language("Indian" , "Experienced" ))
                .education(new Education("highschool",
                        "Thomas Jefferson High School for Science and Technology"
                        ,new Date(2000,8,1),
                        new Date(2004,6,1),8.9))
                .education(new Education("college",
                        "University of Manchester"
                        ,new Date(2004,8,1),
                        new Date(2008,6,1),9.65))
                .experience( new Experience("Google","CEO",
                        new Date(2018,5,1), null))
                .build(), "Google",1);

        Manager manager2 = new Manager(new Consumer.Resume.ResumeBuilder().firstName("Jeff")
                .lastName("Bezos")
                .email("jbezos@amaon.com")
                .phone("+4444444444")
                .birthDate(new Date(1964,1,12))
                .sex("male")
                .language(new Language("English" , "Experienced" ))
                .language(new Language("French" , "Experienced" ))
                .language(new Language("German" , "Experienced" ))
                .education(new Education("highschool",
                        "Thomas Jefferson High School for Science and Technology"
                        ,new Date(1982,8,1),
                        new Date(1986,6,1),8.9))
                .education(new Education("college",
                        "Princeton University"
                        ,new Date(1986,8,1),
                        new Date(1990,8,1),9.75))
                .experience( new Experience("Amazon","CEO",
                        new Date(1994,6,5), null))
                .build(), "Amazon",1);


        employee2.add(employee10);
        employee2.add(recruiter3);
        employee3.add(employee6);
        employee3.add(recruiter2);
        employee3.add(user3);
        employee6.add(recruiter4);
        employee6.add(user3);
        employee10.add(user4);
        employee10.add(employee2);
        employee7.add(user2);
        user1.add(user2);
        user1.add(employee3);
        user2.add(user1);
        user2.add(recruiter1);
        user2.add(employee7);
        user3.add(employee3);
        user3.add(user4);
        user4.add(user3);
        user4.add(employee10);
        recruiter1.add(user2);
        recruiter2.add(employee3);
        recruiter3.add(employee2);
        recruiter4.add(employee6);

        Job job1 = new Job("Software Developer Engineer", "Google", new ExperienceConstraint(2,6),
                new GPAConstraint(8.00,9999999.00),
                new GraduationConstraint(2002,2020),1,1000);

        Job job2 = new Job("Software Developer Engineer Intern", "Google",
                new ExperienceConstraint(0,2),
                new GPAConstraint(9.00,9999999.00),
                new GraduationConstraint(0,9999999),1,5000);

        Job job3 = new Job("Software Developer Engineer", "Amazon",
                new ExperienceConstraint(1,9999999),
                new GPAConstraint(9.35,9999999.00),
                new GraduationConstraint(2014,2020),1,12000);

        Job job4 = new Job("Software Developer Engineer Intern", "Amazon",
                new ExperienceConstraint(0,2),
                new GPAConstraint(9.35,9999999.00),
                new GraduationConstraint(0,99999999),1,6000);

        DepartmentFactory google = new DepartmentFactory();
        DepartmentFactory amazon = new DepartmentFactory();

        ArrayList<Department> department_google = new ArrayList<>();
        department_google.add(google.getDepartmentByType("IT",
                new ArrayList<Employee>(Arrays.asList(employee6)),
                new ArrayList<Job>(Arrays.asList(job1, job2))));

        department_google.add(google.getDepartmentByType("Management",
                new ArrayList<Employee>(Arrays.asList(employee7)),
                new ArrayList<Job>()));


        department_google.add(google.getDepartmentByType("Marketing",
                new ArrayList<Employee>(Arrays.asList(employee10, employee8)),
                new ArrayList<Job>()));

        department_google.add(google.getDepartmentByType("Finance",
                new ArrayList<Employee>(Arrays.asList(employee9)),
                new ArrayList<Job>()));

        ArrayList<Department> department_amazon = new ArrayList<>();
        department_amazon.add(amazon.getDepartmentByType("IT",
                new ArrayList<Employee>(Arrays.asList(employee1)),
                new ArrayList<Job>(Arrays.asList(job3, job4))));

        department_amazon.add(amazon.getDepartmentByType("Management",
                new ArrayList<Employee>(Arrays.asList(employee2)),
                new ArrayList<Job>()));


        department_amazon.add(amazon.getDepartmentByType("Marketing",
                new ArrayList<Employee>(Arrays.asList(employee3, employee5)),
                new ArrayList<Job>()));

        department_amazon.add(amazon.getDepartmentByType("Finance",
                new ArrayList<Employee>(Arrays.asList(employee4)),
                new ArrayList<Job>()));


        Company company1 = new Company("Google",
                manager1,
                department_google,
                new ArrayList<Recruiter>(Arrays.asList(recruiter1,recruiter2)),
                new ArrayList<Job>(Arrays.asList(job1, job2)),
                new ArrayList<Observer>(Arrays.asList(user1,user2,user3,user4)));

        Company company2 = new Company("Amazon",
                manager2,
                department_amazon,
                new ArrayList<Recruiter>(Arrays.asList(recruiter3,recruiter4)),
                new ArrayList<Job>(Arrays.asList(job1, job2)),
                new ArrayList<Observer>(Arrays.asList(user2,user3,user4)));

            Application application = Application.getInstance();
            application.add(user1);
            application.add(user2);
            application.add(user3);
            application.add(user4);


            application.add(company1);
            application.add(company2);


        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setMinimumSize(new Dimension(1000,700));
        jFrame.setPreferredSize(new Dimension(1000,700));

        jFrame.setContentPane(new Open(jFrame).getOpen());

        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        //System.out.println(company1.getDepartments());
        //System.out.println(department_google);
        jFrame.setVisible(true);

    }
}

