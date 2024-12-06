import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o nome do departamento: ");
        String department = sc.nextLine();
        System.out.print("Informe o dia do pagamento: ");
        int paymentDay = sc.nextInt();
        System.out.print("Informe o e-mail do departamento: ");
        sc.nextLine();
        String email = sc.nextLine();
        System.out.print("Informe o telefone do departamento: ");
        String telephoneNumber = sc.nextLine();

        Address address = new Address(email, telephoneNumber);
        Department dept = new Department(department, paymentDay, address);

        System.out.print("Informe quantos funcionários tem o departamento: ");
        int employeesNumber = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= employeesNumber; i++) {
            System.out.printf("Dados do(a) funcionário(a) %d:\n", i);
            System.out.print("Nome: ");
            String employeeName = sc.nextLine();
            System.out.print("Salário: ");
            double employeeSalary = sc.nextDouble();
            sc.nextLine();

            Employee employee = new Employee(employeeName, employeeSalary);

            dept.addEmployee(employee);

        }

        showReport(dept);
        sc.close();


    }

    public static void showReport(Department dept) {
        StringBuilder sb = new StringBuilder();

        sb.append("\nFOLHA DE PAGAMENTO:\n");
        sb.append("Departamento ").append(dept.getName()).append(" = R$ ").append(dept.payroll()).append("\n");
        sb.append("Pagamento realizado no dia ").append(dept.getPayDay()).append("\n");
        sb.append("Funcionários: \n");

        for (Employee employee : dept.getEmployees()) {
            sb.append(employee.getName()).append("\n");
        }

        sb.append("Para dúvidas favor entrar em contato: ").append(dept.getAddress().getEmail()).append("\n");

        System.out.print(sb);

    }
}