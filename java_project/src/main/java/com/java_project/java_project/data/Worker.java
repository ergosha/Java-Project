package com.java_project.java_project.data;

//This is the worker class which extends from Person class

public class Worker extends Person {
    private String jobTitle;
    private double salary;
    public Worker (String name, int age, String address, String phoneNumber, String jobTitle, double salary){
        super(name, age, address, phoneNumber);
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
//getters and setters
public String getJobTitle() {
    return jobTitle;
}

public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
}

public double getSalary() {
    return salary;
}

public void setSalary(double salary) {
    this.salary = salary;
}
}