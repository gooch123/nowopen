package yu.nowopen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import yu.nowopen.dto.ErrorResult;
import yu.nowopen.exception.DuplicateMemberIdException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<ErrorResult> duplicateIdExceptionHandler(DuplicateMemberIdException e) {
        ErrorResult errorResult = new ErrorResult("DuplicateId");
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

}
