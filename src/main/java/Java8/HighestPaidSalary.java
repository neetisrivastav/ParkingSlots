package Java8;


import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class HighestPaidSalary {
    public static void main(String[] args) {
        List<Employee> employee = Stream.of(
                new Employee("Neetffi", 11000, "Dev"),
                new Employee("Anurag", 2000, "Dev"),
                new Employee("Ankita", 9000, "Dev"),
                new Employee("Amit", 1000, "BA"),
                new Employee("Priti", 2000, "PO"),
                new Employee("Neeti", 1000, "PO"),
                new Employee("Anurag", 1000, "QA"),
                new Employee("Neeti", 2000, "QA")


        ).collect(Collectors.toList());



        employee.stream().filter(e->e.getSalary().equals("2000")).map(e->e.getEmployeeName()).forEach(System.out::println);
        //System.out.println("huiop"+name);
        Comparator<Employee> compareBySalary = Comparator.comparing(Employee::getSalary);
        // System.out.println(compareBySalary);

        Map<String, Optional<Employee>> collect = employee.stream().collect(groupingBy(Employee::getDepartment, Collectors.reducing(BinaryOperator.maxBy(compareBySalary))));

        Map<String, Optional<Employee>> collect1 = employee.stream().collect(groupingBy(Employee::getDepartment, Collectors.maxBy(compareBySalary)));
       // System.out.println(collect1);
        //System.out.println(collect);



//Java stream groupingBy key as max salary employee and value as all employee of department

        Map<String, Employee> map = employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        e->e.getValue().get(0).getDepartment(),
                        e->e.getValue().stream()
                                .max(Comparator.comparing(
                                        Employee::getSalary))
                                .get()));

        System.out.println(map);

        //or

        Map<String, List<Employee>> map5 = employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        e->e.getValue().get(0).getDepartment(),
                        e->e.getValue().stream()
                                .max(Comparator.comparing(
                                        Employee::getSalary))
                                .stream().toList()));

            // OR
        Map<Employee, List<Employee>> result = employee.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(groupingBy(Employee::getDepartment, LinkedHashMap::new, toList())).values().stream()
                .collect(toMap(l -> l.get(0), Function.identity()));
        //System.out.println(result);

        //or

        Map<Employee, List<Employee>> map7 = employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        e->e.getValue().stream()
                                .max(Comparator.comparing(
                                        Employee::getSalary))
                                .get(),
                        Map.Entry::getValue));

//Java Stream - maxBy - How to find a department with the highest Average salary with Java 8
        //https://stackoverflow.com/questions/73204644/java-stream-maxby-how-to-find-a-department-with-the-highest-average-salary-w
        Map.Entry<String, Double> highestAvgSalary = employee.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get();

        Optional<Employee> result1 = employee
                .stream()
                .filter(p -> p.getEmployeeName().equalsIgnoreCase("Neeti"))
                .min(Comparator.comparing(Employee::getSalary));

        //System.out.println(result1);


        //second approach
        Map<String, Employee> collect2n = employee.stream().collect(groupingBy(Employee::getDepartment, collectingAndThen(
                maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
               Map<String, Optional<Employee>> finalMap = new LinkedHashMap<>();
       collect.entrySet().stream().sorted()
              .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
//        System.out.println(collect);


       List<Integer> collect3 = employee.stream().filter(e->e.getEmployeeName()=="Neeti").map(Employee::getSalary).toList();
      // System.out.println(collect2);

        Map<String, Set<Integer>> result9 =
                employee.stream().filter(e->e.getEmployeeName()=="Neeti").collect(
                        Collectors.groupingBy(Employee::getEmployeeName,
                                Collectors.mapping(Employee::getSalary, Collectors.toSet())
                        )
                );


       // System.out.println(result);


        Map<String , Set<Integer>> maps = employee.stream().filter(e->e.getEmployeeName()=="Neeti")
                .collect(Collectors.groupingBy(Employee::getEmployeeName, Collectors.mapping(Employee::getSalary, Collectors.toSet())));
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


//https://javarevisited.blogspot.com/2016/04/10-examples-of-converting-list-to-map.html
//https://stackabuse.com/java-convert-map-to-list/