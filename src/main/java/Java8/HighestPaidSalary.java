package Java8;


import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class HighestPaidSalary {
    public static void main(String[] args) {
        List<Employee> employee = Stream.of(
                new Employee("Neeti", 1000, "Dev"),
                new Employee("Anurag", 2000, "Dev"),
                new Employee("Ankita", 9000, "Dev"),
                new Employee("Amit", 1000, "BA"),
                new Employee("Priti", 2000, "PO"),
                new Employee("Neeti", 1000, "PO"),
                new Employee("Anurag", 1000, "QA"),
                new Employee("Neeti", 2000, "QA")
        ).collect(Collectors.toList());

        Comparator<Employee> compareBySalary = Comparator.comparing(Employee::getSalary);
      // System.out.println(compareBySalary);
        Map<String, Optional<Employee>> collect = employee.stream().collect(groupingBy(Employee::getDepartment, Collectors.reducing(BinaryOperator.maxBy(compareBySalary))));
        System.out.println(collect);

        //second approach
//        Map<String, Employee> collect1 = employee.stream().collect(groupingBy(Employee::getDepartment, collectingAndThen(
//                maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
//               Map<String, Optional<Employee>> finalMap = new LinkedHashMap<>();
//       collect.entrySet().stream().sorted()
//              .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
//        System.out.println(collect);


       List<Integer> collect2 = employee.stream().filter(e->e.getEmployeeName()=="Neeti").map(Employee::getSalary).toList();
       System.out.println(collect2);

        Map<String, Set<Integer>> result =
                employee.stream().filter(e->e.getEmployeeName()=="Neeti").collect(
                        Collectors.groupingBy(Employee::getEmployeeName,
                                Collectors.mapping(Employee::getSalary, Collectors.toSet())
                        )
                );


        System.out.println(result);
    }
}
class Employee
{
    private String employeeName;
    private Integer salary;
    private String department;


    public Employee(String employeeName, Integer salary, String department) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
