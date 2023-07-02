package com.minhnc.springboottutorial.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service
// @Repository
// @Component

@Service
public class StudentService {
	
	@Autowired
	private List<StudentDao> studentDaos;
	
	public void saveStudent() {
		for (StudentDao studentDao : studentDaos) {
			studentDao.save();
		}
	}
	
	

}
