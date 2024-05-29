package learnjava.springrestful.dto;


import jakarta.validation.constraints.NotNull;
import learnjava.springrestful.entities.Address;
import lombok.Data;
@Data
public class StudentDto {
	
	private int rollNo;
	@NotNull(message = "Name can not be blank")
	private String name;
	@NotNull(message = "Age can not be blank")
	private int age;
	private Address address;	

}
