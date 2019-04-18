package com.dx.dao;

import com.dx.po.Student;

import java.util.List;
import java.util.Map;

public interface StudentMap {
    List<Student> findAny(Map map);
}
