package com.example.demoBai1.Dao;


import java.util.ArrayList;
import java.util.List;

import com.example.demoBai1.Entity.StudentEntity;

public class ListStudentDao implements StudentDao{
	private static Long ID = 1L;
	private List<StudentEntity> students = new ArrayList<>();

	@Override
	public void save(StudentEntity entity) {
		entity.setId(ID);
		ID++;
		students.add(entity);
		
	}
	
	

}
