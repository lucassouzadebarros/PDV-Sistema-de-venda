package com.pdv.venda;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
@ControllerAdvice
public class ControlerExcecoes extends ResponseEntityExceptionHandler{

	/* Interceptar erro mais comuns no projeto*/
	@ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class})
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		String msg = "";
		
		if(ex instanceof MethodArgumentNotValidException) {
			List<ObjectError> list = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors();
			
			for (ObjectError objecterror: list) {
				
				msg += objecterror.getDefaultMessage() + "\n";
			}
		}else {
			
			msg = ex.getMessage();
		}
		
		ObjetoErro ojerro = new ObjetoErro();
		ojerro.setError(msg);
		ojerro.setCode(status.value() + "==>"+ status.getReasonPhrase());
		return new ResponseEntity<>(ojerro,headers,status);
	}
	
	
	/* Erro a nivel de banco de dados*/
	@ExceptionHandler({DataIntegrityViolationException.class, ConstraintViolationException.class,
	SQLException.class})
	protected ResponseEntity<Object> handleExcpetionDataIntegry(Exception ex){
		
		String msg ="";
		
		if(ex instanceof DataIntegrityViolationException) {
			
			msg = ((DataIntegrityViolationException) ex).getCause().getCause().getMessage();
		}
		
		else if (ex instanceof ConstraintViolationException) {
			
			msg =  ((ConstraintViolationException) ex).getCause().getCause().getMessage();
		}
		
		else {
			
			msg = ex.getMessage();/*Outras msg de erro */
		}
		
		ObjetoErro objecterro = new ObjetoErro();
		objecterro.setError(msg);
		objecterro.setCode(HttpStatus.INTERNAL_SERVER_ERROR + "==>" + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		
		return new ResponseEntity<>(objecterro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
