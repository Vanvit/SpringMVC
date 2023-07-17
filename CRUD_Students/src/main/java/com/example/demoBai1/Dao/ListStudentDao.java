package com.example.demoBai1.Dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demoBai1.Entity.StudentEntity;
import com.example.demoBai1.Exception.AplicationException;
@Component
public class ListStudentDao implements StudentDao{
	private static Long ID = 1L;
	private List<StudentEntity> students = new ArrayList<>();

	@Override
	public void save(StudentEntity entity) {
		entity.setId(ID);
		ID++;
		students.add(entity);
	}

	@Override
	public List<StudentEntity> getStudents() {
		return students;
	}

	@Override
	public void deleteStudentById(Long id) {

		Iterator<StudentEntity> iterator = students.iterator();
		while(iterator.hasNext()) {
			StudentEntity studentEntity = iterator.next();
			if (studentEntity.getId().equals(id)) {
				iterator.remove();
				return;
			}
		}
		throw new AplicationException("Không tìm thấy sinh viên có id là: " + id);


		
	}
}
