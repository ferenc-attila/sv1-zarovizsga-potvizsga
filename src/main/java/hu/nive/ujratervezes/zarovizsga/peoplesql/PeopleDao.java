package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class PeopleDao {

    private JdbcTemplate jdbcTemplate;

    public PeopleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String findIpByName(String firstName, String lastName) {
        return jdbcTemplate.queryForObject("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?",
                String.class, firstName, lastName);
    }
}
