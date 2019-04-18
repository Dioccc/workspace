package com.dx.po;

public class Link {
    private String cname;
    private String dname;
    private String name;
    private String sex;
    private int age;
    private double salary;

    public Link() {
    }

    public Link(String cname, String dname, String name, String sex, int age, double salary) {
        this.cname = cname;
        this.dname = dname;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Link{" +
                "cname='" + cname + '\'' +
                ", dname='" + dname + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
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
