package com.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


/*
 * Schema to hold multiple employee objects
 */
@XmlRootElement(name = "employees")
public class Employees {
    List<EmployeeData> employees;

    public List getEmployees() {
        return employees;
    }

    @XmlElement(name = "employeeData")
    public void setEmployees(List employees) {
        this.employees = employees;
    }

    public void add(EmployeeData employeeData) {
        if (this.employees == null) {
            this.employees = new ArrayList();
        }
        this.employees.add(employeeData);

    }

    @Override
    public String toString() {
        System.out.println("Our employee list after unmarshall is : ");
        StringBuffer str = new StringBuffer();
        for (EmployeeData emp : employees) {
            str = str.append(emp.toString()).append("\r\n");
        }
        return str.toString();
    }

}


