package learnjava.springrestful.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import learnjava.springrestful.dao.StudentDao;
import learnjava.springrestful.dto.StudentDto;

import learnjava.springrestful.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;
	@Autowired
	ModelMapper modelMapper;

	public StudentDto addStudent(StudentDto studentDto) {

		/*
		 * Student mappedDtoToStudent = studentMapper.mappedDtoToStudent(studentDto);
		 * Student student = studentDao.save(mappedDtoToStudent); return
		 * studentMapper.mappedStudentToDto(student);
		 */
		Student student = this.modelMapper.map(studentDto, Student.class);
		return this.modelMapper.map(studentDao.save(student), StudentDto.class);

	}

	public List<StudentDto> fetchStudnet(int id) {

		List<Student> student = studentDao.findById(id);
		List<StudentDto> sDto = student.stream().map(st -> this.modelMapper.map(st, StudentDto.class))
				.collect(Collectors.toList());
		return sDto;

	}

	public List<StudentDto> allStudents(List<StudentDto> studentDto) {
		List<Student> studentList = studentDto.stream().map(dto -> this.modelMapper.map(dto, Student.class))
				.collect(Collectors.toList());
		studentList = studentDao.saveAll(studentList);
		List<StudentDto> sDto = studentList.stream().map(st -> this.modelMapper.map(st, StudentDto.class))
				.collect(Collectors.toList());

		return sDto;
	}

	public StudentDto updateStudent(StudentDto studentDto, int id) {
		Student student = this.modelMapper.map(studentDto, Student.class);
		student.setRollNo(id);
		student = studentDao.save(student);
		StudentDto dto = this.modelMapper.map(student, StudentDto.class);
		return dto;
	}

	public List<StudentDto> findByName(String s) {

		List<Student> byName = studentDao.findByName(s);

		return byName.stream().map(name -> this.modelMapper.map(name, StudentDto.class)).collect(Collectors.toList());

	}

	public List<StudentDto> findByAge(int age1, int age2) {
		List<Student> byAge = studentDao.findByAgeBetween(age1, age2);
		return byAge.stream().map(age -> this.modelMapper.map(age, StudentDto.class)).collect(Collectors.toList());

	}

	public List<StudentDto> fetchPage(int pageNumber, int pageSize) {

		Page<Student> page = studentDao.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(Direction.DESC, "age")));
		return page.stream().map(p -> this.modelMapper.map(p, StudentDto.class)).collect(Collectors.toList());

	}

}
