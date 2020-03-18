package com.xml;

import javax.xml.bind.annotation.*;

/*
 * Employee class to map the XML schema
 */
@XmlRootElement(name="employee")
public class EmployeeData {
    @XmlAttribute(name="id")
    private String ID;
    @XmlElement(name="firstName")
    private String Firstname;
    @XmlElement(name="lastName")
    private String Lastname;
    @XmlElement(name="age")
    private Integer age;
    @XmlElement(name="salary")
    private Double salary;

    public EmployeeData() {}

    public EmployeeData(String ID, String Firstname, String Lastname, Integer age, Double salary) {
        this.ID = ID;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.age = age;
        this.salary = salary;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeData{" +
                "ID='" + ID + '\'' +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
