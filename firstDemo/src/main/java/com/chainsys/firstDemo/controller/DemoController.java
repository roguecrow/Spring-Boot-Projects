package com.chainsys.firstDemo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.firstDemo.dao.UserImpl;
import com.chainsys.firstDemo.model.UserDetails;

@Controller
public class DemoController {
	
	@Autowired
	UserImpl userImpl;
	
 @RequestMapping ("/")
 public String home() {
	 System.out.println("in home");
	 return "index.jsp";
 }
 
 
	@PostMapping("/register")
	public String registerUser(@RequestParam("name") String name, @RequestParam("age") Integer age, Model model)
			throws ClassNotFoundException, SQLException {
		System.out.println("In register handler");
		UserDetails details = new UserDetails();
		details.setName(name);
		details.setAge(age);
		System.out.println(details.getName() + details.getAge());
		userImpl.addNewUser(details);
		 return viewUser(model);
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestParam("id") Integer id, Model model)
			throws ClassNotFoundException, SQLException {
		System.out.println("In Delete handler");
		UserDetails details = new UserDetails();
		details.setId(id);
		System.out.println("delete id = "+ details.getId());
		userImpl.deleteUser(details);
		 return viewUser(model);
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("age") Integer age, Model model)
			throws ClassNotFoundException, SQLException {
		System.out.println("In Update handler");
		UserDetails details = new UserDetails();
		details.setId(id);
		details.setName(name);
		details.setAge(age);
		System.out.println("update id = "+ details.getId());
		userImpl.updateUser(details);
		 return viewUser(model);
		
	}
	
	public String viewUser(Model model) throws SQLException {
		List<UserDetails> userList = userImpl.getAllUserDetails();
        model.addAttribute("users", userList);
		return "viewUserDetails.jsp";
	}
}
