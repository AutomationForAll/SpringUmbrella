package learnjava.springrestful.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		Map<String, Object> multivalue= new HashMap<String, Object>();
		multivalue.put("TimeStamp",LocalDate.now() );
		multivalue.put("StatusCode", HttpStatus.BAD_REQUEST);
		multivalue.put("ErrorMessage", ex.getFieldErrors().stream().map(e->e.getDefaultMessage()).collect(Collectors.toList()));
		return new ResponseEntity(multivalue,HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler({ ConstraintViolationException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity handleConstraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity(e.getConstraintViolations().stream().map(ex->ex.getMessage()).collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ HttpMessageNotReadableException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity handleConstraintViolationException(HttpMessageNotReadableException e) {
		return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
