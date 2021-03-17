package home.and.company.books.app.persistent;

import static java.util.stream.Collectors.toList;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import home.and.company.books.app.exception.DuplicateBookException;
import home.and.company.books.app.model.Book;
import home.and.company.books.app.model.BookDetails;

@Component
public class BookStore extends Inventory {
	
	
	//Very primitive DB to holds 'Book' entities against 'ISBN' No
	private static final Map<String, Book> BOOKS = Stream.of(
            new SimpleEntry<>(BOOK1.getIsbn(), BOOK1),
            new SimpleEntry<>(BOOK2.getIsbn(), BOOK2))
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));
	
	
	public Map<String, Book> getBooks() {
		return BOOKS;
	}


	public long persist(Book newBook) {
		
		//Unique constraint violation
		if(BOOKS.containsKey(newBook.getIsbn())) {

			throw new DuplicateBookException("Book already exist for ISBN[" + newBook.getIsbn() + "] = " + newBook.toString());
		}
		
		newBook.setBookId(ID++); //Primary key. Auto increment
		BookDetails details = newBook.getDetails();
		if(details != null) {
			details.setBookId(newBook.getBookId()); //Foreign key
		}
		BOOKS.put(newBook.getIsbn(), newBook);
		return newBook.getBookId();
	}


	public List<Book> getAll() {
		
		return BOOKS.values().stream().collect(toList());
	}
}
