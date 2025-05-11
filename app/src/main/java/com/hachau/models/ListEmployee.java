package com.hachau.models;

import java.util.ArrayList;

public class ListEmployee {
    private ArrayList<Employee> employees;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ListEmployee() {
        employees=new ArrayList<>();
    }

    public void gen_dataset(){
        Employee e1=new Employee();
        e1.setId(1);
        e1.setName("Jay");
        e1.setEmail("jay@gmail.com");
        e1.setPhone("0958204202");
        e1.setUsername("jayie");
        e1.setPassword("0420");
        employees.add(e1);

        Employee e2=new Employee();
        e2.setId(2);
        e2.setName("Jake");
        e2.setEmail("jake@gmail.com");
        e2.setPhone("0963887335");
        e2.setUsername("jakeu");
        e2.setPassword("2002");
        employees.add(e2);

        Employee e3=new Employee();
        e3.setId(3);
        e3.setName("Jack");
        e3.setEmail("jack@gmail.com");
        e3.setPhone("0853482375");
        e3.setUsername("tuantrinh");
        e3.setPassword("1997");
        employees.add(e3);
    }
}
