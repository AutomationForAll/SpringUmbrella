package learnjava.springrestful.service;

import java.util.List;
import java.util.Optional;

import learnjava.springrestful.dto.StudentDto;
import learnjava.springrestful.entities.Student;

public interface StudentService {
	
	public StudentDto addStudent(StudentDto studentDto);
	public List<StudentDto> fetchStudnet(int id);
	public List<StudentDto> allStudents(List<StudentDto> studentDto);
	public StudentDto updateStudent(StudentDto studentDto ,int id);
	public List<StudentDto> findByName(String s);
	public List<StudentDto> findByAge(int age1,int age2);
	public List<StudentDto> fetchPage(int pageNumber,int pageSize );
}
