package com.dx.mapper;

import com.dx.po.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    List<Student> findAnyWay(Map map);
}
