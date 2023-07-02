package com.minhnc.springboottutorial.di;

import org.springframework.stereotype.Repository;

@Repository
public class DatabaseStudentDao implements StudentDao {
	
	@Override
	public void save() {
		System.out.println("Lưu dữ liệu vào database ");
	}

}
