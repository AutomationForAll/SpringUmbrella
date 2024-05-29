package learnjava.springrestful.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressDto {
	@JsonIgnore
	private int aId;
	@NotNull(message = "Lane cannot be blank")
	private String lane;
	private String state;
	private int pincode;

}
