package com.ra.project_module5_reactjs.advice;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.dto.response.CustomResponseEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ApplicationHandler {

	/**
	 * @param ex MethodArgumentNotValidException
	 * @apiNote handle valid request
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errors);
	}

	/**
	 * @param ex CustomException
	 * @apiNote handle custom exception
	 */
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> handleCustomException(CustomException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("error", ex.getMessage());
		return new ResponseEntity<>(errors, ex.getStatus());
	}

	/**
	 * @param ex Exception
	 * @apiNote handle internal server error
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex, WebRequest request) {
		CustomResponseEntity<?> response = CustomResponseEntity.builder()
				.statusCode(INTERNAL_SERVER_ERROR.value())
				.status(INTERNAL_SERVER_ERROR)
				.message("Internal Server Error")
				.data(ex.getMessage())
				.build();
		return new ResponseEntity<>(response, INTERNAL_SERVER_ERROR);
	}

	/**
	 * @param ex HttpRequestMethodNotSupportedException
	 * @apiNote handle method not allowed
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, WebRequest request) {
		CustomResponseEntity<?> response = CustomResponseEntity.builder()
				.statusCode(HttpStatus.METHOD_NOT_ALLOWED.value())
				.status(HttpStatus.METHOD_NOT_ALLOWED)
				.message("Request method not supported")
				.data(ex.getMessage())
				.build();
		return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
	}


}
