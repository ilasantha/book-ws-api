package home.and.company.books.app.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import home.and.company.books.app.response.ErrorMessage;

@ControllerAdvice
public class BookExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { DuplicateBookException.class })
	protected ResponseEntity<Object> handleDuplicateEntry(final DuplicateBookException ex, final WebRequest request) {
		ErrorMessage error = new ErrorMessage(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.name(), ex.getMessage());
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { IllegalArgumentException.class })
	protected ResponseEntity<Object> handleIllegalArgument(final IllegalArgumentException ex,
			final WebRequest request) {
		ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				ex.getMessage());
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { BookNotFoundException.class })
	protected ResponseEntity<Object> objectNotFound(final BookNotFoundException ex, final WebRequest request) {
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				ex.getMessage());
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleAny(final Exception ex, final WebRequest request) {
		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage());
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
