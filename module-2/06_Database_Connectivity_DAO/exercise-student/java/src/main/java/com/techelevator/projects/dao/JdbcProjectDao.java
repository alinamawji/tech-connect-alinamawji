package com.techelevator.projects.dao;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcProjectDao implements ProjectDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProjectDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Project getProject(Long projectId) {
        try {
            String sql = "SELECT * FROM project WHERE project_id = ?;";
            Project project = (Project) jdbcTemplate.queryForObject(sql, new projectRowMapper(), projectId);
            return project;
        }  catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Project getProjectByName(String name) {
        try {
            String sql = "SELECT * FROM project WHERE name = ?;";
            Project project = (Project) jdbcTemplate.queryForObject(sql, new projectRowMapper(), name);
            return project;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Project> getAllProjects() {
        String sql = "SELECT * FROM project;";
        List<Project> projects = jdbcTemplate.query(sql, new projectRowMapper());
        return projects;
    }

    @Override
    public void createProject(Project newProject) {
        Long ID = newProject.getId();
        String name = newProject.getName();
        LocalDate fromDate = newProject.getFromDate();
        LocalDate toDate = newProject.getToDate();
        String sql = "INSERT INTO project(project_id, name, from_date, to_date) values(?, ?, ? , ?);";
        jdbcTemplate.update(sql, ID, name, fromDate, toDate);
    }

    @Override
    public void deleteProject(Long projectId) {
        String sql = "DELETE FROM project_employee WHERE project_id = ?;" +
                     "DELETE FROM project WHERE project_id = ?;";
        jdbcTemplate.update(sql, projectId, projectId);
    }
}

class projectRowMapper implements RowMapper {
    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        Project project = new Project();
        project.setId(resultSet.getLong("project_id"));
        project.setName(resultSet.getString("name"));
        if (resultSet.getString("from_date") != null) {
            project.setFromDate(LocalDate.parse(resultSet.getString("from_date")));
        }
        if (resultSet.getString("to_date") != null) {
            project.setToDate(LocalDate.parse(resultSet.getString("to_date")));
        }
        return project;
    }
}