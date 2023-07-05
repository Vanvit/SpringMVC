package com.studentmanage.studentmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanage.studentmanage.dao.StudentDao;
import com.studentmanage.studentmanage.entity.StudentEntity;
import com.studentmanage.studentmanage.exception.ApplicationException;
import com.studentmanage.studentmanage.form.CreateStudentForm;
import com.studentmanage.studentmanage.model.StudentModel;
import com.studentmanage.studentmanage.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public void save(CreateStudentForm form) {
		validateCreateStudentForm(form);
		// Lưu dữ liệu
		// form -> entity
		StudentEntity newStudent = new StudentEntity();
		newStudent.setName(form.getName());
		newStudent.setAge(Integer.valueOf(form.getAge()));
		newStudent.setDateOfBirth(form.getDateOfBirth());
		newStudent.setScore(Float.valueOf(form.getScore()));
		studentDao.save(newStudent);
	}
	
	private void validateCreateStudentForm(CreateStudentForm form) {
		String age = form.getAge();
		try {
			Integer.valueOf(age);
		} catch (NumberFormatException e) {
			throw new ApplicationException("Tuổi sinh viên phải là 1 số");
		}
		try {
			Float.valueOf(form.getScore());
		} catch (NumberFormatException e) {
			throw new ApplicationException("Điểm sinh viên phải là 1 số");
		}
	}
	
	@Override
	public List<StudentModel> getStudents() {
		List<StudentEntity> entities = studentDao.getStudents();
		List<StudentModel> models = new ArrayList<>();
		for(StudentEntity entity: entities) {
			StudentModel model = new StudentModel();
			model.setId(entity.getId());
			model.setName(entity.getName());
			model.setAge(entity.getAge());
			model.setDateOfBirth(entity.getDateOfBirth());
			model.setScore(entity.getScore());
			
			models.add(model);
		}
		return models;
	}

	@Override
	public void deteleStudentById(String id) {
		try {
			studentDao.deleteStudentById(Long.valueOf(id));
		} catch (NumberFormatException e) {
			throw new ApplicationException("Id phải là 1 số");
		}
	}
	

}
