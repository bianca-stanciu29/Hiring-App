package company.departament;

import company.employee.Employee;
import company.job.Job;

import java.util.ArrayList;
import java.util.EmptyStackException;

// Factory Pattern pentru fiecare tip de departament
public final class DepartmentFactory {
    public Department getDepartmentByType(final String departmentType,
                                          ArrayList<Employee>employees,
                                          ArrayList<Job>jobs) {
        if (departmentType.equals("IT")) {
            return new IT(employees,jobs);
        } else if (departmentType.equals("Management")) {
            return new Management(employees,jobs);
        } else if (departmentType.equals("Marketing")) {
            return new Marketing(employees,jobs);
        } else if (departmentType.equals("Finance")) {
            return new Finance(employees,jobs);
        }
        return null;
    }

}
