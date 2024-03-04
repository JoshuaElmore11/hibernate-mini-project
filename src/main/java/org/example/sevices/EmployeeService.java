package org.example.sevices;

import org.example.entities.Employee;
import org.example.repositories.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    public void addEmployee(Session session, Transaction transaction, Scanner sc){
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Email: ");
        String email = sc.next();
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employeeRepository.addEmployee(session, transaction, employee);
    }

    public void updateEmployee(Session session, Transaction transaction, Scanner sc){
        System.out.print("Enter employee id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employeeRepository.updateEmployee(session, transaction, employee);
    }

    public void getEmployeeById(Session session, Scanner sc){
        System.out.println("Enter employee ID to view employee: ");
        int id = sc.nextInt();
        Employee employee = employeeRepository.getEmployeeById(session, id);
        if (employee != null){
            System.out.println(employee);
        } else {
            System.out.println("No employee by that ID.");
        }
    }

    public void getAllEmployees(Session session){
        List<Employee> employees = employeeRepository.getAllEmployee(session);

        for(Employee e: employees) {
            System.out.println(e);
        }
    }

    public void deleteEmployee(Session session, Transaction transaction, Scanner sc){
        System.out.print("Enter employee id to delete: ");
        int id = sc.nextInt();
        Employee employee = employeeRepository.getEmployeeById(session, id);
        employeeRepository.deleteEmployee(session, transaction, employee);
    }
}
