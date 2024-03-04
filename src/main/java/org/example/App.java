package org.example;


import org.example.entities.Employee;
import org.example.sevices.EmployeeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();
        boolean flag = true;

        //config object
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        while (flag) {
            System.out.println("******************************************************");
            System.out.println("*************Choose an Option*************************");
            System.out.println("******************************************************");
            System.out.println("1: Add an Employee");
            System.out.println("2: Update an Employee");
            System.out.println("3: Delete an Employee");
            System.out.println("4: View Employees");
            System.out.println("5: View Employee by ID");
            System.out.println("6: Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    //add employee
                    employeeService.addEmployee(session, transaction, sc);
                    break;
                }
                case 2: {
                    //Update an Employee
                    employeeService.updateEmployee(session, transaction, sc);
                    break;
                }
                case 3: {
                    //delete Employee
                    employeeService.deleteEmployee(session, transaction, sc);
                    break;
                }
                case 4: {
                    //get all Employees
                    employeeService.getAllEmployees(session);
                    break;
                }
                case 5: {
                    //get by ID
                    employeeService.getEmployeeById(session, sc);
                    break;
                }

                case 6:{
                    // exit
                    System.out.println("Thank you");
                    System.out.println("Exiting...");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Please Choose between 1 - 6");
                }
            }

        }

        session.close();
    }
}
