package com.studentManagement.DAOInterface;

import java.util.List;

import com.studentManagement.Entity.Students;

public interface StudentDAO {

	List<Students> loadStudents();
	public int saveStudentRecord(Students std);
	public Students findStudent(int id);
	public int updateStudent(Students studentRecord);
	public int deleteStudent(int studentRecord);
}
