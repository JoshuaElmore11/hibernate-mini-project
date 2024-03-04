package org.example.repositories;

import org.example.entities.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    public void addEmployee(Session session, Transaction transaction, Employee employee){
        session.save(employee);
        transaction.commit();
    }

    public void updateEmployee(Session session, Transaction transaction, Employee employee){
        session.update(employee);
        transaction.commit();
    }

    public Employee getEmployeeById (Session session, int id){
        return session.get(Employee.class, id);

    }

    public List<Employee> getAllEmployee(Session session) {
        List<Employee> employees = new ArrayList<>();
        employees = session.createQuery("SELECT a from employees a", Employee.class).getResultList();
        return employees;
    }

    public void deleteEmployee(Session session, Transaction transaction, Employee employee){
        session.delete(employee);
        transaction.commit();
    }
}
