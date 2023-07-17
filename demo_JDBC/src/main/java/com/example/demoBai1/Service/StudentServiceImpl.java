package com.example.demoBai1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import com.example.demoBai1.Dao.StudentDao;
import com.example.demoBai1.Entity.StudentEntity;
import com.example.demoBai1.Exception.AplicationException;
import com.example.demoBai1.Form.Student;
import com.example.demoBai1.Model.StudentModel;

@Service // cho vao thung IoC
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao StudentDao;

	@Override
	public void save(Student student) {	
		//validate
		validateCreateStudentForm(student);
		// Luu Dl
		// form -> entity
		StudentEntity newStudent = new StudentEntity();
		
		newStudent.setName(student.getName());
		newStudent.setAge(Integer.valueOf(student.getAge()));
		newStudent.setDoB(student.getDoB());
		newStudent.setScore(Float.valueOf(student.getScore()));
		
		StudentDao.save(newStudent);
		
	}
	
	private void validateCreateStudentForm(Student student) {
		String age = student.getAge();
		try {
			Integer.valueOf(age);
		} catch (NumberFormatException e) {
			throw new AplicationException("Tuoi Sinh Vien phai la so");
		}
		
		try {
			Float.valueOf(student.getScore());
		} catch (NumberFormatException e) {
			throw new AplicationException("Diem Sinh Vien phai la so");
		}
		
		
		
	}

	@Override
	public List<StudentModel> getStudents() {
		
		List<StudentEntity> entities = StudentDao.getStudents();
		List<StudentModel> models = new ArrayList<StudentModel>();
		
		for(StudentEntity entity : entities) {
			StudentModel model = new StudentModel();
			model.setId(entity.getId());
			model.setName(entity.getName());
			model.setAge(entity.getAge());
			model.setDoB(entity.getDoB());
			model.setScore(entity.getScore());
			
			models.add(model);
		}
		
		return models;
	}

	@Override
	public void deleteStudentById(String id) {

		try {
			StudentDao.deleteStudentById(Long.valueOf(id));
		} catch (NumberFormatException e) {
			throw new ApplicationContextException("ID phai la 1 so!");
		}
	}

}




