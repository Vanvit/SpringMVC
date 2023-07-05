package com.studentmanage.studentmanage.service;

import java.util.List;

import com.studentmanage.studentmanage.form.CreateStudentForm;
import com.studentmanage.studentmanage.model.StudentModel;

public interface StudentService {
	
	void save(CreateStudentForm form);
	
	List<StudentModel> getStudents(); 
	
	void deteleStudentById(String id);

}
