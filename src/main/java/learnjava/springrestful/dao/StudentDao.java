package learnjava.springrestful.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import learnjava.springrestful.entities.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

	public List<Student> findByName(String Name);
	//@Query(":from student where age between=:age1 And :age2")
	public List<Student> findByAgeBetween(int age1,int age2);
	public List<Student> findById(int id);
	//public List<Student> findByAgeBetween(List<Integer> age);
	//public List<Student> fetchPage(int startPage,int endPage);
}
