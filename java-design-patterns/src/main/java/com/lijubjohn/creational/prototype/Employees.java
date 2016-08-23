package com.lijubjohn.creational.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liju on 8/22/16.
 */
public class Employees implements Cloneable {
    List<String> employees;

    public Employees(){
        this.employees = new ArrayList<>();
    }
    public Employees (List<String> employeeList){
        this.employees = employeeList;
    }
    public void loadAllEmpFromDB(){
        //mocking loading from db
        employees.add("emp 1");
        employees.add("emp 2");
        employees.add("emp 3");
    }

    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        //shallow copy
       return super.clone();
    }*/

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //deep copy
        return employees.stream().collect(Collectors.toList());
    }
}
