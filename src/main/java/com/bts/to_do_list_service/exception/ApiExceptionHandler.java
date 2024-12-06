package com.bts.to_do_list_service.exception;

import com.bts.to_do_list_service.exception.custom.BadRequestException;
import com.bts.to_do_list_service.exception.custom.ForbiddenException;
import com.bts.to_do_list_service.exception.custom.NotFoundException;
import com.bts.to_do_list_service.exception.custom.UnauthorizedException;
import com.bts.to_do_list_service.response.DataResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    private String error = "Validation Error";

    @ExceptionHandler(value = DuplicateKeyException.class)
    public ResponseEntity<Object> handleAlreadyExistsException(DuplicateKeyException e) {
        HttpStatus status = HttpStatus.CONFLICT;
        DataResponse<Object> response = new DataResponse<>(status.value(), error, e.getMessage(), null);
        return new ResponseEntity<>(response, new HttpHeaders(), status);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        DataResponse<Object> response = new DataResponse<>(status.value(), error, e.getMessage(), null);
        return new ResponseEntity<>(response, new HttpHeaders(), status);
    }

    @ExceptionHandler(value = ForbiddenException.class)
    public ResponseEntity<Object> handleForbidden(ForbiddenException e) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        DataResponse<Object> response = new DataResponse<>(status.value(), error, e.getMessage(), null);
        return new ResponseEntity<>(response, new HttpHeaders(), status);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException e) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        DataResponse<Object> response = new DataResponse<>(status.value(), error, e.getMessage(), null);
        return new ResponseEntity<>(response, new HttpHeaders(), status);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        DataResponse<Object> response = new DataResponse<>(status.value(), error, e.getMessage(), null);
        return new ResponseEntity<>(response, new HttpHeaders(),status);
    }
}
