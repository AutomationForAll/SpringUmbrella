package learnjava.springrestful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import learnjava.springrestful.dao.StudentDao;
import learnjava.springrestful.entities.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;

	public Student addStudent(Student s) {
		Student student = studentDao.save(s);
		return student;

	}

	public Optional<Student> fetchStudnet(int id) {
		Optional<Student> byId = studentDao.findById(id);
		return byId;

	}

	public List<Student> allStudents(List<Student> s) {
		List<Student> saveAll = studentDao.saveAll(s);
		return saveAll;
	}

	public Student updateStudent(Student s) {
		Student save = studentDao.save(s);
		return save;
	}

	public List<Student> findByName(String s) {

		List<Student> byName = studentDao.findByName(s);
		return byName;

	}
	
	public List<Student> findByAge(int age1,int age2){
		List<Student> byAge = studentDao.findByAgeBetween(age1, age2);
		return byAge;
	}
	
	public List<Student> fetchPage(int pageNumber,int pageSize ){
		
		Page<Student> page = studentDao.findAll(PageRequest.of(pageNumber, pageSize,Sort.by(Direction.DESC, "age")));
		return page.toList();
			
	}
	
	
}
