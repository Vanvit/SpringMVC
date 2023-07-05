package com.studentmanage.studentmanage.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.studentmanage.studentmanage.dao.StudentDao;
import com.studentmanage.studentmanage.entity.StudentEntity;
import com.studentmanage.studentmanage.exception.ApplicationException;

@Repository
public class ListStudentDao implements StudentDao {
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
		throw new ApplicationException("Không tìm thấy sinh viên có id là: " + id);
	}
	
	
}
