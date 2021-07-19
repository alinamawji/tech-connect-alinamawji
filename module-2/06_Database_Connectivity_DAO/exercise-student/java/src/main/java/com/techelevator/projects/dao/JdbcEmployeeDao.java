package com.techelevator.projects.dao;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEmployeeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        List<Employee> employees = jdbcTemplate.query(sql, new employeeRowMapper());
        return employees;
    }

    @Override
    public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
        firstNameSearch = "%" + firstNameSearch + "%";
        lastNameSearch = "%" + lastNameSearch + "%";
        String sql = "SELECT * FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ?";
        List<Employee> employees = jdbcTemplate.query(sql, new employeeRowMapper(), firstNameSearch, lastNameSearch);
        return employees;
    }

    @Override
    public List<Employee> getEmployeesByProjectId(Long projectId) {
        String sql = "SELECT * FROM employee WHERE employee_id IN " +
                "(SELECT (employee_id) FROM project_employee WHERE project_id = ?);";
        List<Employee> employees = jdbcTemplate.query(sql, new employeeRowMapper(), projectId);
        return employees;
    }

    @Override
    public void addEmployeeToProject(Long projectId, Long employeeId) {
        String sql = "INSERT INTO project_employee(project_id, employee_id) values(?, ?)";
        jdbcTemplate.update(sql, projectId, employeeId);
    }

    @Override
    public void removeEmployeeFromProject(Long projectId, Long employeeId) {
        String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
        jdbcTemplate.update(sql, projectId, employeeId);
    }

    @Override
    public List<Employee> getEmployeesWithoutProjects() {
        String sql = "SELECT * FROM employee WHERE employee_id NOT IN " +
                "(SELECT employee_id FROM project_employee);";
        List<Employee> employees = jdbcTemplate.query(sql, new employeeRowMapper());
        return employees;
    }

}

class employeeRowMapper implements RowMapper {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("employee_id"));
        if ((Long)resultSet.getLong("department_id") != null) {
            employee.setDepartmentId(resultSet.getLong("department_id"));
        }
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        if (resultSet.getString("birth_date") != null) {
            employee.setBirthDate(LocalDate.parse(resultSet.getString("birth_date")));
        }
        if (resultSet.getString("hire_date") != null) {
            employee.setHireDate(LocalDate.parse(resultSet.getString("hire_date")));
        }
        return employee;
    }
}
