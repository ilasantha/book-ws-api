package home.and.company.books.app.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.and.company.books.app.exception.BookCreationException;
import home.and.company.books.app.exception.BookNotFoundException;
import home.and.company.books.app.model.Book;
import home.and.company.books.app.response.SuccessMessage;
import home.and.company.books.app.services.BookService;

@RestController
@RequestMapping("/book-app/v1")
public class BookResource {
	
	@Autowired
	private BookService<Book> bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		
		return bookService.getAllBooks();
	}
	

	@GetMapping("/books/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable final String isbn) {
		
		Optional<Book> book = bookService.getBookByIsbn(isbn);
		if(book == null) 
		{
			throw new BookNotFoundException("No book found for ISBN: " + isbn);
		}
		
		return book.map(response -> ResponseEntity.ok().body(response))
	            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/books")
	public SuccessMessage saveBook(@RequestBody final Book newBook) 
	{
		long newId = bookService.persist(newBook);
		
		if(newId < 0) {
			throw new BookCreationException("Error in creating book wiht ISBN: " + newBook.getIsbn());
		}
		return new SuccessMessage("SAVE","New Book is saved with ISBN: " + newBook.getIsbn());
	}

}
