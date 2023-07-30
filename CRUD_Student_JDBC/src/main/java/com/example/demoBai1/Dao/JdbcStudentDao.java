package com.example.demoBai1.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demoBai1.Entity.StudentEntity;

import com.example.demoBai1.Exception.AplicationException;

@Repository
public class JdbcStudentDao implements StudentDao{
	
	private Connection getConnection() {
		
		String DB_URL = "jdbc:mysql://localhost:3306/t3h2";
		String USER = "root";
		String PASS = "root";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AplicationException("Kết nối db thất bại");
		}
	}

	@Override
	public void save(StudentEntity entity) {
		String sql = "INSERT INTO students(name, age, score, dob) VALUES (?, ?, ?, ?)";
		Connection connection = getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, entity.getName());
			prepareStatement.setInt(2, entity.getAge());
			prepareStatement.setFloat(3, entity.getScore());
			prepareStatement.setString(4, entity.getDoB());
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AplicationException("Kết nối db thất bại");
		}
	}

	@Override
	public List<StudentEntity> getStudents() {
		String sql = "SELECT name, age, score, dob, id FROM students";
		Connection connection = getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
			ResultSet resultSet = prepareStatement.getResultSet();
			List<StudentEntity> entities = new ArrayList<>();
			while(resultSet.next()) {
				StudentEntity studentEntity = new StudentEntity();
				
				studentEntity.setId(resultSet.getLong("id"));
				studentEntity.setName(resultSet.getString("name"));
				studentEntity.setAge(resultSet.getInt("age"));
				studentEntity.setScore(resultSet.getFloat("score"));
				studentEntity.setDoB(resultSet.getString("dob"));

				entities.add(studentEntity);
			}
			return entities;
		} catch (SQLException e) {
			throw new AplicationException("Kết nối db thất bại");
		}
	}

	@Override
	public void deleteStudentById(Long id) {
		String sql = "DELETE FROM students WHERE id = ?";
		Connection connection = getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, id);
		
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AplicationException("Kết nối db thất bại");
		}
	}
}
