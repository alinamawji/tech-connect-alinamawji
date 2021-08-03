package com.techelevator.dao;

import com.techelevator.dao.model.Customer;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * JDBCCustomerDao
 */
@Component
public class JDBCCustomerDao implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCustomerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Customer> searchAndSortCustomers(String name, String order) {
        List<Customer> matchingCustomers = new ArrayList<>();

        String filmSearchSql = "SELECT first_name, last_name, email, activebool FROM customer " +
                "WHERE first_name ILIKE ('%' || ? || '%') OR last_name ILIKE ('%' || ? || '%') ";
        switch(order) {
            case "last_name":
                filmSearchSql += "ORDER BY last_name";
                break;
            case "email":
                filmSearchSql += "ORDER BY email";
                break;
            case "activebool":
                filmSearchSql += "ORDER BY activebool";
                break;
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(filmSearchSql, name, name);
        while (results.next()) {
            matchingCustomers.add(mapRowToCustomer(results));
        }
        return matchingCustomers;
    }

    private Customer mapRowToCustomer(SqlRowSet results) {
        Customer customerRow = new Customer();
        customerRow.setFirstName(results.getString("first_name"));
        customerRow.setLastName(results.getString("last_name"));
        customerRow.setEmail(results.getString("email"));
        customerRow.setActive(results.getBoolean("activebool"));
        return customerRow;
    }
}