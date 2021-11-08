package com.studentManagement.ServiceInterface;

import java.util.List;

import com.studentManagement.Entity.Students;

public interface StudentServiceInterface {
	
	List<Students> loadAllStudent();
	public int addStudentRecord(Students student);
	public Students findStudetdetails(int Id);
	public int updateStudentRecord(Students std);
	public int deleteStudentRecord(int std);
}
