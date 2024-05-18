package learnjava.springrestful.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.websocket.server.PathParam;
import learnjava.springrestful.entities.Student;
import learnjava.springrestful.service.StudentService;

@RestController

public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping(path = {"/studnet"})
	public Student insertStudent(@RequestBody Student s) {

		Student student = studentService.addStudent(s);
		return student;

	}
	
	@GetMapping("/test")
	public String getTest() {
		
		return "this is the first";
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable(value = "id") int id) {
		
		Optional<Student> fetchStudnet = studentService.fetchStudnet(id);
		return fetchStudnet;
		
	}
		
	@PostMapping(path = {"/students"})
	public List<Student> addStudents(@RequestBody List<Student> s){
		
		List<Student> allStudents = studentService.allStudents(s);
		return allStudents;
	}
	@PutMapping(path= {"/student"})
	public Student updateStudent(@RequestBody Student s) {
		
		Student updateStudent = studentService.updateStudent(s);
		return updateStudent;
	}
	@GetMapping("/studentbyName/{name}")
	public List<Student> findByName(@PathVariable(value = "name") String s){
		List<Student> byName = studentService.findByName(s);
		return byName;
	}
	/*
	 * @GetMapping("/studentbyName") public List<Student>
	 * findByAge(@RequestParam(name = "age1") int age1,@RequestParam(name = "age2")
	 * int age2){ List<Student> byAge = studentService.findByAge(age1, age2); return
	 * byAge;
	 * 
	 * }
	 */
	
	@GetMapping("/studentbyName")
	public List<Student> findByAge(@RequestParam(name = "age1") int age1,@RequestParam(name = "age2") int age2){
		List<Student> byAge = studentService.findByAge(age1, age2);
		return byAge;
		
	}
	@GetMapping(path = {"/student"},produces = {MediaType.APPLICATION_XML_VALUE},consumes = MediaType.ALL_VALUE)
	public List<Student> fetchPage(@RequestParam(name = "pageNumber") int pageNumber,@RequestParam(name = "pageSize") int pageSize){
		List<Student> fetchPage = studentService.fetchPage(pageNumber,pageSize);
		return fetchPage;
	}
}
//@JacksonXmlRootElement --> for json response