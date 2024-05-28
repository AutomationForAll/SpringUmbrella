package learnjava.springrestful.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class AddressDto {
	@JsonIgnore
	private int aId;
	private String lane;
	private String state;
	private int pincode;

}
