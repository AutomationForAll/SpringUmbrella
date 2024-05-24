package learnjava.springrestful.dto;

import java.util.List;

import learnjava.springrestful.entities.Address;
import learnjava.springrestful.entities.Student;
import lombok.Data;
@Data
public class StudentDto {
	
	private int rollNo;
	private String name;
	private int age;
	private Address address;
	private List<Student> student;
	
	
	
	

}
