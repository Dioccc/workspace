package com.dx.test;


import com.dx.dao.StudentMap;
import com.dx.po.Student;
import com.dx.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBatis2 {
    @Test
    public void testFindAny(){
        SqlSession sqlSession= MybatisUtils.getSession(false);
        String columnNameLike="spilinfoname";
        String columnNameOrder="spilinfoid";
        String keyword="技";
        int curPage=1;
        int pageSize=2;
        int start=(curPage-1)*pageSize;
        Map<String,Object> map=new HashMap<>();
        map.put("columnNameLike",columnNameLike);
        map.put("keyword",keyword);
        map.put("start",start);
        map.put("pageSize",pageSize);
        map.put("columnNameOrder",columnNameOrder);
        List<Student> students=sqlSession.selectList("findAny",map);
        for (Student student:students
                ) {
            System.out.println(student);
        }


    }
}
