package am.smartcode.sandshipgames.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleEntityNotFoundException(HttpServletRequest request, EntityNotFoundException exception) {
        return buildResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException exception) {
        return buildResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), request.getRequestURI());
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleRuntimeException(HttpServletRequest request, RuntimeException exception) {
        return buildResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), request.getRequestURI());
    }

    @Override
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HttpServletRequest req = ((ServletWebRequest) request).getRequest();
        logError(req, ex);
        var errors = ex.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        fieldError -> isNull(fieldError.getDefaultMessage()) ? "wrong value type" : fieldError.getDefaultMessage()));

        return ResponseEntity.badRequest().body(new ApiError(HttpStatus.BAD_REQUEST.value(), req.getRequestURI(), errors));
    }

    @Override
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleHandlerMethodValidationException(HandlerMethodValidationException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        HttpServletRequest req = ((ServletWebRequest) request).getRequest();
        logError(req, ex);
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), req.getRequestURI());
    }


    private ResponseEntity<Object> buildResponse(HttpStatus httpCode, String message, String requestURI) {
        var errors = new HashMap<String, String>();
        errors.put("message", message);
        var apiError = new ApiError(httpCode.value(), requestURI, errors);
        return ResponseEntity.status(httpCode).body(apiError);
    }

    private void logError(HttpServletRequest req, Exception e) {
        log.error(e.getMessage());
        log.error("RequestURI {}", req.getRequestURI());
        e.printStackTrace();
    }

}