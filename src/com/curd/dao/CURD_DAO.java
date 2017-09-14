package com.curd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.curd.bo.EmployeeBO;

@Repository
public class CURD_DAO {
	@Autowired(required = true)
	private JdbcTemplate jdbcTemplate;

	final String SQL_QUERY_FOR_INSERT = "INSERT INTO EMPLOYEE_CURD VALUES(?,?,?,?)";

	final String SQL_QUERY_FOR_UPDATE = "UPDATE EMPLOYEE_CURD SET SALARY=? WHERE ID=?";

	final String SQL_QUERY_FOR_READ = "SELECT * FROM EMPLOYEE_CURD";

	final String SQL_QUERY_FOR_DELETE = "DELETE FROM EMPLOYEE_CURD WHERE ID=?";

	public String save(final EmployeeBO employee) {
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con
						.prepareStatement(SQL_QUERY_FOR_INSERT);
				ps.setInt(1, employee.getId());
				ps.setString(2, employee.getName());
				ps.setString(3, employee.getDept());
				ps.setDouble(4, employee.getSalary());
				return ps;
			}
		});
		return "RECORD INSERTED SUCCESSFULLY....";
	}

	public int update(double salary, int id) {
		return jdbcTemplate.update(SQL_QUERY_FOR_UPDATE, new Object[] { salary,
				id });
	}

	public List<EmployeeBO> read() {
		return jdbcTemplate.query(SQL_QUERY_FOR_READ,
				new RowMapper<EmployeeBO>() {

					@Override
					public EmployeeBO mapRow(ResultSet rs, int index)
							throws SQLException {
						return new EmployeeBO(rs.getInt(1), rs.getString(2), rs
								.getString(3), rs.getDouble(4));
					}
				});
	}

	public int delete(int id) {
		return jdbcTemplate.update(SQL_QUERY_FOR_DELETE, new Object[] { id });
	}
}
