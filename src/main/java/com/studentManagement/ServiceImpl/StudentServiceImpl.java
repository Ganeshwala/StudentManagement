package com.studentManagement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagement.DAOInterface.StudentDAO;
import com.studentManagement.Entity.Students;
import com.studentManagement.ServiceInterface.StudentServiceInterface;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

	@Autowired
	StudentDAO studentObj;
	
	@Override
	public List<Students> loadAllStudent() {
		List<Students> loadStudents = studentObj.loadStudents();
		return loadStudents;
	}

	@Override
	public int addStudentRecord(Students student) {
		int record = studentObj.saveStudentRecord(student);
		return record;
	}

	@Override
	public Students findStudetdetails(int Id) {
		Students stdResult = studentObj.findStudent(Id);
		return stdResult;
	}

	@Override
	public int updateStudentRecord(Students std) {
		int updateStudent = studentObj.updateStudent(std);
		return updateStudent;
	}

	@Override
	public int deleteStudentRecord(int std) {
		int deleteStudent = studentObj.deleteStudent(std);
		return deleteStudent;
	}

	

}
