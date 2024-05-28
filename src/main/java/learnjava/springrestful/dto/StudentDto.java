package learnjava.springrestful.dto;


import jakarta.validation.constraints.NotNull;
import learnjava.springrestful.entities.Address;
import lombok.Data;
@Data
public class StudentDto {
	
	private int rollNo;
	@NotNull(message = "Name can not be blank")
	private String name;
	private int age;
	private Address address;	

}
