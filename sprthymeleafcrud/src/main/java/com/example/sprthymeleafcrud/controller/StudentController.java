package com.example.sprthymeleafcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sprthymeleafcrud.entity.Student;
import com.example.sprthymeleafcrud.repository.StudentRepository;

@Controller
@RequestMapping("/students/")
public class StudentController {

	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentController (StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@GetMapping("signup")
	public String showSignUpForm(Student student) {
		return "add-student";
	}
	
	@GetMapping("list")
	public String showUpdateForm (Model model) {
		model.addAttribute("students", studentRepository.findAll());
		
		return "index";
	}
	
	@PostMapping("add")
	public String addStudent(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}
		
		studentRepository.save(student);
		
		return "redirect:list";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Student student = studentRepository.findById(id)
							.orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id)); 
		model.addAttribute("student", student);
		return "update-student";
	}
	
	@PostMapping("update/{id}")
	public String updateStudent (@PathVariable("id") long id,
								 @Valid Student student,
								 BindingResult result,
								 Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}
		
		studentRepository.save(student);
		model.addAttribute("students", studentRepository.findAll());
		
		return "index";
	}
	
	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id,
								Model model) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Estudante inválido ID: " + id));
		
		studentRepository.delete(student);
		model.addAttribute("studant", studentRepository.findAll());
		
		return "index";
	}
}
