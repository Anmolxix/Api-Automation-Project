package org.example;

public class Employee {
    //variables
    String ename;
    int eage;
    int esalary;


    //Methods
    void method(String name, int age, int salary ){
        ename= name;
        eage=age;
        esalary=salary;

    }

    void DisplayData() {
        System.out.println(ename + "  "+ eage+"  "+esalary);
    }


}


