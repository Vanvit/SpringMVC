package com.minhnc.springboottutorial.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class FileStudentDao implements StudentDao {

	@Override
	public void save() {
		System.out.println("Lưu dữ liệu vào file");
	}
	
}
