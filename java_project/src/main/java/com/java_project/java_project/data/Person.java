package com.java_project.java_project.data;

//this is the  person class

public class Person {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private int id;

    public Person(String name, int age, String address, String phoneNumber) {
        this.name = name;
        this.age= age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //setters and getters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
    
