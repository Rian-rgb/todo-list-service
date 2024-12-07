package com.bts.to_do_list_service.exception;

import com.bts.to_do_list_service.exception.custom.BadRequestException;
import com.bts.to_do_list_service.exception.custom.ForbiddenException;
import com.bts.to_do_list_service.exception.custom.NotFoundException;
import com.bts.to_do_list_service.exception.custom.UnauthorizedException;
import com.bts.to_do_list_service.response.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
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
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody DataResponse<Object> handleBadRequestException(BadRequestException e) {
       log.error(e.getMessage());
        return DataResponse.builder()
               .statusCode(HttpStatus.BAD_REQUEST.value())
               .message(error)
               .errorMessage(e.getMessage())
               .data(null)
               .build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody DataResponse<Object> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(
                objectError -> {
                    String fieldName = ((FieldError) objectError).getField();
                    String errorMessage = objectError.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                }
        );
        return DataResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(error)
                .errorMessage(errors.toString())
                .data(null)
                .build();
    }
}
