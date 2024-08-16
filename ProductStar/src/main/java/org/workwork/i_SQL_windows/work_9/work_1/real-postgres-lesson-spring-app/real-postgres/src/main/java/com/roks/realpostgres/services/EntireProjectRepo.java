package com.roks.realpostgres.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntireProjectRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getTop10WalkingUsersFromDb() {

        List<String> top10Walks = jdbcTemplate.queryForList("select user_login from walks group by user_login order by count(*) desc limit 10", String.class);

        return top10Walks;
    }

}
