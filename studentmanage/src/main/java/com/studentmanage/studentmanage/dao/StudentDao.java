package com.studentmanage.studentmanage.dao;

import java.util.List;

import com.studentmanage.studentmanage.entity.StudentEntity;

public interface StudentDao {
	
	void save(StudentEntity entity);
	
	List<StudentEntity> getStudents();
	
	void deleteStudentById(Long id);
	
}
