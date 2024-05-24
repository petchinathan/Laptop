package com.lap.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lap.exception.NotEnoughRaMException;
import com.lap.exception.oldModelException;

@RestControllerAdvice
public class GlobalException {
@ExceptionHandler(NotEnoughRaMException.class)
public ResponseEntity<Object> handle(NotEnoughRaMException n) {
	return new ResponseEntity<Object>("Ram is less than 4",HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(oldModelException.class)
public ResponseEntity<Object> handle1(oldModelException n) {
	return new ResponseEntity<Object>("model is not upto date",HttpStatus.BAD_REQUEST);
}
}
