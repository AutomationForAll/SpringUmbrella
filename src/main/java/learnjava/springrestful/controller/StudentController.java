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

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import learnjava.springrestful.dto.StudentDto;
import learnjava.springrestful.entities.Student;
import learnjava.springrestful.service.StudentServiceImpl;

@RestController

public class StudentController {

	@Autowired
	StudentServiceImpl studentService;

	@PostMapping(path = { "/studnet" })
	public StudentDto insertStudent(@Valid @RequestBody StudentDto studentDto) {

		StudentDto student = studentService.addStudent(studentDto);
		return studentDto;

	}

	@GetMapping("/test")
	public String getTest() {

		return "this is the first";
	}

	@GetMapping("/student/{id}")
	public List<StudentDto> getStudent(@PathVariable(value = "id") int id) {

		return studentService.fetchStudnet(id);

	}

	@PostMapping(path = { "/students" })
	public List<StudentDto> addStudents(@Valid @RequestBody List<StudentDto> s) {

		return studentService.allStudents(s);
	}

	@PutMapping(path = { "/student" })
	public StudentDto updateStudent(@RequestParam(name = "rollNo") int id, @RequestBody StudentDto s) {

		return studentService.updateStudent(s, id);
	}

	@GetMapping("/studentbyName/{name}")
	public List<StudentDto> findByName(@PathVariable(value = "name") String s) {
		return studentService.findByName(s);
	}

	@GetMapping("/studentbyName")
	public List<StudentDto> findByAge(@RequestParam(name = "age1") int age1, @RequestParam(name = "age2") int age2) {

		return studentService.findByAge(age1, age2);

	}

	@GetMapping(path = { "/student" }, produces = { MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.ALL_VALUE)
	public List<StudentDto> fetchPage(@RequestParam(name = "pageNumber") int pageNumber,
			@RequestParam(name = "pageSize") int pageSize) {

		return studentService.fetchPage(pageNumber, pageSize);
	}
}
//@JacksonXmlRootElement --> for json response