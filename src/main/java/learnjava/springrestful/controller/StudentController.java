package learnjava.springrestful.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<StudentDto> insertStudent(@Valid @RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentService.addStudent(studentDto), HttpStatus.CREATED);

	}

	@GetMapping("/student/{id}")
	public ResponseEntity<List<StudentDto>> getStudent(@PathVariable(value = "id") int id) {
		return new ResponseEntity<List<StudentDto>>(studentService.fetchStudnet(id), HttpStatus.OK);

	}

	@PostMapping(path = { "/students" })
	public ResponseEntity<List<StudentDto>> addStudents(@Valid @RequestBody List<StudentDto> s) {
		return new ResponseEntity<List<StudentDto>>(studentService.allStudents(s), HttpStatus.CREATED);

	}

	@PutMapping(path = { "/student" })
	public ResponseEntity<StudentDto> updateStudent(@RequestParam(name = "rollNo") int id, @RequestBody StudentDto s) {
		return new ResponseEntity<StudentDto>(studentService.updateStudent(s, id), HttpStatus.ACCEPTED);

	}

	@GetMapping("/studentbyName/{name}")
	public ResponseEntity<List<StudentDto>> findByName(@PathVariable(value = "name") String s) {
		return new ResponseEntity<List<StudentDto>>(studentService.findByName(s), HttpStatus.OK);

	}

	@GetMapping("/studentbyName")
	public ResponseEntity<List<StudentDto>> findByAge(@RequestParam(name = "age1") int age1,
			@RequestParam(name = "age2") int age2) {
		return new ResponseEntity<List<StudentDto>>(studentService.findByAge(age1, age2), HttpStatus.OK);

	}

	@GetMapping(path = { "/student" }, produces = { MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<List<StudentDto>> fetchPage(@RequestParam(name = "pageNumber") int pageNumber,
			@RequestParam(name = "pageSize") int pageSize) {
		return new ResponseEntity<List<StudentDto>>(studentService.fetchPage(pageNumber, pageSize), HttpStatus.OK);

	}

	@DeleteMapping(path = { "/student" })
	public ResponseEntity<String> deleteStudentById(@RequestParam(name = "id") int id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Record deleted ", HttpStatus.NO_CONTENT);
	}
}
//@JacksonXmlRootElement --> for json response