package com.techelevator;
import com.techelevator.Employee;
import com.techelevator.Department;
import com.techelevator.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.text.NumberFormat;
import java.time.LocalDate;

public class Application {
    List<Department> departments = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    Map<String, Project> projects = new HashMap<String, Project>();

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department dept1 = new Department(1, "Marketing");
        Department dept2 = new Department(2, "Sales");
        Department dept3 = new Department(3, "Engineering");
        departments.add(dept1);
        departments.add(dept2);
        departments.add(dept3);
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department d : departments) {
            System.out.println(d.getName());
        }
    }

    private Department getDepartmentByName(String name) {
        for (Department d : departments) {
            if (d.getName() == name) {
                return d;
            }
        }
        return null;
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        LocalDate today = LocalDate.now();

        Employee emp1 = new Employee();
        emp1.setEmployeeId(1);
        emp1.setFirstName("Dean");
        emp1.setLastName("Johnson");
        emp1.setEmail("djohnson@teams.com");
        emp1.setSalary(60000);
        emp1.setDepartment(getDepartmentByName("Engineering"));
        emp1.setHireDate(today.toString());
        employees.add(emp1);

        Employee emp2 = new Employee(2, "Angie", "Smith", "asmith@teams.com", getDepartmentByName("Engineering"), today.toString());
        employees.add(emp2);

        Employee emp3 = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", getDepartmentByName("Marketing"), today.toString());
        employees.add(emp3);

        emp2.raiseSalary(0.10);
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");

        for (Employee e : employees) {
            NumberFormat salary = NumberFormat.getCurrencyInstance();
            System.out.println(e.getFullName() + " (" + salary.format(e.getSalary()) + ") " + e.getDepartment().getName());
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        LocalDate today = LocalDate.now();
        Project proj1 = new Project("TEams", "Project Management Software", today.toString(), today.plusDays(30).toString());
        List<Employee> engineeringEmployees = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getDepartment().getName().equals("Engineering")) {
                engineeringEmployees.add(e);
            }
        }
        proj1.setTeamMembers(engineeringEmployees);
        projects.put(proj1.getName(), proj1);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        LocalDate today = LocalDate.now();
        Project proj2 = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", today.plusDays(31).toString(), today.plusDays(38).toString());
        List<Employee> marketingEmployees = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getDepartment().getName().equals("Marketing")) {
                marketingEmployees.add(e);
            }
        }
        proj2.setTeamMembers(marketingEmployees);
        projects.put(proj2.getName(), proj2);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for (Map.Entry<String, Project> p : projects.entrySet()) {
            System.out.println(p.getKey() + ": " + p.getValue().getTeamMembers().size());
        }
    }

}
