package com.example.demoBai1.Service;

import java.util.List;

import com.example.demoBai1.Form.Student;
import com.example.demoBai1.Model.StudentModel;

public interface StudentService {

	void save(Student student);
	
	List<StudentModel> getStudents();
	
	void deleteStudentById(String id);
}
