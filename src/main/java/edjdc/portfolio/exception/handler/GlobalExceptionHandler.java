package edjdc.portfolio.exception.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edjdc.portfolio.exception.RemoverProjetoComStatusAprovadoException;
import edjdc.portfolio.exception.response.ExceptionResponse;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = RemoverProjetoComStatusAprovadoException.class)
	public ResponseEntity<ExceptionResponse> handlerRemoverProjetoComStatusAprovadoException(HttpServletRequest req,
			RemoverProjetoComStatusAprovadoException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage("Não é possível remover um projeto com status aprovado");
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handlerMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();

		List<String> validErrors = new ArrayList<String>();
		for (FieldError fieldError : result.getFieldErrors()) {
			validErrors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
		}

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage("Validation Error");
		response.setErrors(validErrors);

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = Exception.class)
	public void handleException(Exception ex) {

	}

}
