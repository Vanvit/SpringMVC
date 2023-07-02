package com.example.demoBai1.Service;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.stereotype.Service;

import com.example.demoBai1.Dao.StudentDao;
import com.example.demoBai1.Entity.StudentEntity;
import com.example.demoBai1.Exception.AplicationException;
import com.example.demoBai1.Form.Student;
@Service // cho vao thung IoC
public class StudentServiceImpl implements StudentService{
	
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

}
