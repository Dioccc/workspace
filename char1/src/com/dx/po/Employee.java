package com.dx.po;

public class Employee {
    private String eid;
    private String did;
    private String name;
    private String sex;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(String did, String name, String sex, int age, double salary) {
        this.did = did;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String eid, String did, String name, String sex, int age, double salary) {
        this.eid = eid;
        this.did = did;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid='" + eid + '\'' +
                ", did='" + did + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
