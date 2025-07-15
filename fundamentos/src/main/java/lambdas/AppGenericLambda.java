package lambdas;

import interfaces.Employee;
import interfaces.Product;

public class AppGenericLambda {
    public static void main(String[] args) {
        Printer<String> printerString = (s) -> System.out.println(s);
        printerString.print("Hello World");

        Printer<Product> printerProduct = (p) -> System.out.println(p.getName());
        Printer<Employee> printerEmployee = e -> System.out.println(e.getName());

        Product p = new Product();
        p.setName("Galletas");
        p.setPrice(20.0);
        printerProduct.print(p);

        Employee e = new Employee();
        e.setName("Pedro");
        e.setSalary(10000.0);
        printerEmployee.print(e);
    }
}
