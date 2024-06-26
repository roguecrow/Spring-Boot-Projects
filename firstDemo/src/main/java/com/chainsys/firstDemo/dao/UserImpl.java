package com.chainsys.firstDemo.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.chainsys.firstDemo.model.UserDetails;
import com.chainsys.firstDemo.mapper.UserDetailsMapper;


@Configuration
public class UserImpl {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addNewUser(UserDetails details) throws ClassNotFoundException, SQLException {
		String addUser = "insert into user_details (name, age) values (?, ?)";
		Object[] userDetailObj = { details.getName(), details.getAge() };
		int noOfRows = jdbcTemplate.update(addUser, userDetailObj);
		System.out.println("in DAO - save :" + noOfRows);
	}
	
	public List<UserDetails> getAllUserDetails() throws SQLException {
        String sql = "SELECT id,name,age FROM user_details where is_active = true";
        return jdbcTemplate.query(sql, new UserDetailsMapper());
    }
	
	public void deleteUser(UserDetails details) throws ClassNotFoundException, SQLException {
		String removeUser = "update user_details set is_active = ? where id = ?";
		Object[] userRemovObj = {false, details.getId()};
		int noOfRows = jdbcTemplate.update(removeUser, userRemovObj);
		System.out.println("updated row -" + noOfRows);
	}
	
	public void updateUser(UserDetails details) throws ClassNotFoundException, SQLException {
		String updateUser = "update user_details set name = ?, age = ? where id = ?";
		Object[] userUpdateObj = {details.getName(), details.getAge(), details.getId()};
		int noOfRows = jdbcTemplate.update(updateUser, userUpdateObj);
		System.out.println("updated row -" + noOfRows);
	}

}
