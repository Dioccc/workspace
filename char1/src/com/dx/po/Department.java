package com.dx.po;

public class Department {
    private String did;
    private String cid;
    private String dname;//部门名称
    private String emps;//员工信息

    public Department() {
    }

    public Department(String did, String cid, String name, String emps) {
        this.did = did;
        this.cid = cid;
        this.dname = name;
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did='" + did + '\'' +
                ", cid='" + cid + '\'' +
                ", name='" + dname + '\'' +
                ", emps='" + emps + '\'' +
                '}';
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return dname;
    }

    public void setName(String name) {
        this.dname = name;
    }

    public String getEmps() {
        return emps;
    }

    public void setEmps(String emps) {
        this.emps = emps;
    }
}

