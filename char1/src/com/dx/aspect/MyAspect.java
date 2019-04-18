package com.dx.aspect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyAspect {

    Date date=new Date();
    DateFormat nowDate = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE");
    public void myBefore() {

        System.out.println("现在的时间是："+nowDate.format(date));
        System.out.println("*********模拟权限检查*************");
    }
    public void myAfter() {
        System.out.println("现在的时间是："+nowDate.format(date));
        System.out.println("*********模拟记录日志*************");
    }
}
