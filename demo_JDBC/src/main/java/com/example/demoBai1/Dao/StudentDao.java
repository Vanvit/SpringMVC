package com.example.demoBai1.Dao;

import java.util.List;

import com.example.demoBai1.Entity.StudentEntity;

public interface StudentDao {
	void save(StudentEntity entity);
	
	List<StudentEntity> getStudents();
	
	void deleteStudentById(Long id);

}
