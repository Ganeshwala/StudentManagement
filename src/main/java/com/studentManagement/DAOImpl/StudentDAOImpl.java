package com.studentManagement.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.studentManagement.DAOInterface.StudentDAO;
import com.studentManagement.Entity.Students;
import com.studentManagement.RowMappers.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	JdbcTemplate jTemplate;
	@Override
	public List<Students> loadStudents() {
		String sql ="SELECT * FROM students;";
		List<Students> resultSet = jTemplate.query(sql,new StudentRowMapper());
		return resultSet;
	}
	@Override
	public int saveStudentRecord(Students std) {
		String sql ="insert into students(studentsName,studentsPhone,studentsCountry) values(?,?,?)";
		int insertResult = jTemplate.update(sql, std.getStudentName(),std.getStudentNumber(),std.getCountry());
		return insertResult;
	}
	@Override
	public Students findStudent(int id) {
		String sql="select * from students where studentsId=?";
		Students stdResult= jTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return stdResult;
	}
	@Override
	public int updateStudent(Students studentRecord) {
		String sql="update students set studentsName=?,studentsPhone=?,studentsCountry=? where studentsId=?";
		int update = jTemplate.update(sql, studentRecord.getStudentName(),studentRecord.getStudentNumber(),studentRecord.getCountry(),studentRecord.getStudentId());
		return update;
	}
	@Override
	public int deleteStudent(int studentRecord) {
		String sql ="delete from students where studentsId=?";
		int delete = jTemplate.update(sql, studentRecord);
		return delete;
	}
	
	
	

}
