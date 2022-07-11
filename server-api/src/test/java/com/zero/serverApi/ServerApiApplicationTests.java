package com.zero.serverApi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ServerApiApplicationTests {

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;


    @Test
    void contextLoads() {


        String sql = "select * from t_user ";


        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);


        System.out.println(maps);
    }

}
