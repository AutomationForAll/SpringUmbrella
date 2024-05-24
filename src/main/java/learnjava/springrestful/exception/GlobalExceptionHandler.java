package learnjava.springrestful.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	/*
	 * @ExceptionHandler(value = { IllegalArgumentException.class,
	 * IllegalStateException.class })
	 * 
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatusCode status, WebRequest request) {
	 * 
	 * Map<String,Object> body= new HashMap<String, Object>(); body.put("timeStamp",
	 * System.currentTimeMillis()); body.put("status", status.value()); List<String>
	 * error =
	 * ex.getFieldErrors().stream().map(e->e.getDefaultMessage()).collect(Collectors
	 * .toList()); body.put("errors", error);
	 * 
	 * return new ResponseEntity<Object>(body, status);
	 * 
	 * 
	 * 
	 * }
	 */

}
