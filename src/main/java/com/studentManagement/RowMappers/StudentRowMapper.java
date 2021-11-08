package com.studentManagement.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.studentManagement.Entity.Students;

public class StudentRowMapper implements RowMapper<Students> {

	@Override
	public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
		Students std = new Students();
		std.setStudentId(rs.getInt("studentsId"));
		std.setStudentName(rs.getString("studentsName"));
		std.setStudentNumber(rs.getLong("studentsPhone"));
		std.setCountry(rs.getString("studentsCountry"));
		return std;
	}

}
