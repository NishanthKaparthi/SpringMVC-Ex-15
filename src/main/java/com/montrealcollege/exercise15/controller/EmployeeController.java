package com.montrealcollege.exercise15.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.montrealcollege.exercise15.model.Employee;

@Controller
public class EmployeeController {

	@GetMapping("/value")
	private String getForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeForm";
	}

	@PostMapping("/createEmployee")
	private String createEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult br, Model model) throws SQLException {
		if (br.hasErrors()) {
			return "employeeForm";
		} else {
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/t?useSSL=false", "root",
						"root");
				PreparedStatement stmt = con.prepareStatement("insert into employees values(?,?, ?, ?)");
				stmt.setInt(1, employee.getId());
				stmt.setString(2, employee.getFirstName());
				stmt.setString(3, employee.getLastName());
				stmt.setString(4, employee.getEmail());
				int i = stmt.executeUpdate();
				System.out.println(i + " records inserted");
				model.addAttribute("message", i + " records inserted");
				
//			ResultSet rs=stmt.executeQuery("select * from employees");  
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));  
//				con.close();
			} catch (Exception e) {
				System.out.println(e);
				model.addAttribute("message", "id "+employee.getId()+ " already exist");
			}
			finally {
				con.close();
			}
			return "result";
			
		}
//		else {
//			model.addAttribute("id", employee.getId());
//			model.addAttribute("name", employee.getFirstName()+" "+employee.getLastName());
//			model.addAttribute("email", employee.getEmail());
//			return "result";
//		}
	}
}
