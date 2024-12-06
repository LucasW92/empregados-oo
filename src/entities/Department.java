package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private int payDay;
    private Address address;

    List<Employee> employees = new ArrayList<>();

    public Department(String name, int payDay, Address address) {
        this.name = name;
        this.payDay = payDay;
        this.address = address;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public double payroll() {
        double totalValue = 0.0;
        for (Employee employee : employees) {
            totalValue += employee.getSalary();
        }
        return  totalValue;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getPayDay() {
        return payDay;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
