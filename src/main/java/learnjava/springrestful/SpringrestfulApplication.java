package learnjava.springrestful;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "Student api",version = "1.0.0",description = "student details"),
servers = @Server(url = "http://localhost:8080/api/v1",description = "student details")
		)
@SpringBootApplication
public class SpringrestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestfulApplication.class, args);
	}
	
		@Bean
	    public ModelMapper getModelMapper() {
	        return new ModelMapper();
	    }

}
