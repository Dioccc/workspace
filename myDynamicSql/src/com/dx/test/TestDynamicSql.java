package com.dx.test;

import com.dx.po.Student;
import com.dx.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDynamicSql {
    @Test
    public void testFindAnyWay(){
        SqlSession sqlSession= MybatisUtils.getSession(false);
        String columnNameLike="spilinfoname";
        String columnNameOrder="spilinfoid";
        String keyword="技";
        int pageSize=3;
        int start=1;
        String spilinfoid="";
        Map<String,Object> map=new HashMap<>();
        map.put("columnNameLike",columnNameLike);
        map.put("keyword",keyword);
        map.put("start",start);
        map.put("pageSize",pageSize);
        map.put("columnNameOrder",columnNameOrder);
        map.put("spilinfoid",spilinfoid);
        List<Student> students=sqlSession.selectList("findAnyWay",map);
        for (Student student:students
                ) {
            System.out.println(student);
        }
    }
}
