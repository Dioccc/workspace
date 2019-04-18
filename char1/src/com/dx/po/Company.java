package com.dx.po;

public class Company {
    private String id;
    private String cname;
    private String address;
    private String depts;

    public Company() {
    }

    public Company(String id, String cname, String address, String depts) {
        this.id = id;
        this.cname = cname;
        this.address = address;
        this.depts = depts;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", cname='" + cname + '\'' +
                ", address='" + address + '\'' +
                ", depts='" + depts + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepts() {
        return depts;
    }

    public void setDepts(String depts) {
        this.depts = depts;
    }
}
