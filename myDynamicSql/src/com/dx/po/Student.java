package com.dx.po;

public class Student {
    private String spilinfoid;
    private String spilinfoname;
    private String spilinfoaim;

    @Override
    public String toString() {
        return "Student{" +
                "spilinfoid=" + spilinfoid +
                ", spilinfoname='" + spilinfoname + '\'' +
                ", spilinfoaim='" + spilinfoaim + '\'' +
                '}';
    }
}
