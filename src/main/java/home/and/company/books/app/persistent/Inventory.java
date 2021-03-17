package home.and.company.books.app.persistent;

import java.time.LocalDate;
import java.time.Month;

import home.and.company.books.app.model.Book;
import home.and.company.books.app.model.BookBuilder;
import home.and.company.books.app.model.BookDetails;
import home.and.company.books.app.model.BookDetailsBuilder;

public class Inventory {
	
	static int ID = 1;

	static final BookDetails DETAILS = new BookDetailsBuilder().withDescription("Des").withLanuage("English")
			.withNoOfPages((short) 345).withPublisher("O'really")
			.withPublishedDate(LocalDate.of(2011, Month.FEBRUARY, 7).toString()).create();

	// Sample Book1
	static final Book BOOK1 = new BookBuilder().withBookId(ID++).withIsbn("45-124").withAuthour("Sam Newman")
			.withTitle(" Building Microservices").withPrice("$32.77").withBookDetails(DETAILS).create();

	// Sample Book2
	static final Book BOOK2 = new BookBuilder().withBookId(ID++).withIsbn("67-8656").withAuthour("Sam Newman")
			.withTitle(" Head First Design Pattern").withPrice("$32.77").create();

}
