package com.studentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentManagement.DAOInterface.StudentDAO;
import com.studentManagement.Entity.Students;
import com.studentManagement.ServiceInterface.StudentServiceInterface;

@Controller
public class StudentController {

		
	@Autowired
	private StudentServiceInterface stdService;
	
	@GetMapping("/showStudent")
	public String showStudentList(ModelMap map) {
		List<Students> loadStudents = stdService.loadAllStudent();
		map.addAttribute("studentList", loadStudents);
		return "studentList";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(ModelMap map) {
		map.addAttribute("student", new Students());
		return "addStudent";
	}
	
	
	@PostMapping("/saveStudent")
	public String saveStudent(Students std) {
		if(std.getStudentId()!=0) {
			int studentUpdate= stdService.updateStudentRecord(std);
			return "redirect:/showStudent";		
		}
		else {
			int studentRecord = stdService.addStudentRecord(std);
			if(studentRecord!=0) {
				return "redirect:/showStudent";//post-redirect-get pattern
			}
			return "redirect:/addStudent";
			
		}		
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@RequestParam("studentId") String stdId,Model mp) {
		Students studetdetails = stdService.findStudetdetails(Integer.parseInt(stdId));
		mp.addAttribute("student", studetdetails);
		return "addStudent";
	}
	
	@PostMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") String stdId,Model mp) {
		stdService.deleteStudentRecord(Integer.parseInt(stdId));
		List<Students> loadStudents = stdService.loadAllStudent();
		mp.addAttribute("student", loadStudents);
		return "redirect:/showStudent";
	}
}
