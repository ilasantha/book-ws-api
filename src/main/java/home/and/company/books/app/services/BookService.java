package home.and.company.books.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.and.company.books.app.dao.BookDao;
import home.and.company.books.app.model.Book;

@Service
public class BookService<T extends Book> {

	@Autowired
	private BookDao<T> bookDao;

	public Optional<T> getBookByIsbn(final String isbn) {
		
		assertNotNullAndNotEmpty("ISBN", isbn);
		return bookDao.findBookById(isbn);
	}

	/**
	 * Persist the new 'Book' entity into database.
	 * 
	 * @param newBook
	 *            Book to persist
	 * @return new Id if successes. -1 if failed.
	 */
	public long persist(T book) {

		validateMandatory(book);
		return bookDao.persist(book);
		
	}

	private void validateMandatory(final Book book) {
		assertNotNullAndNotEmpty("ISBN", book.getIsbn());
		assertNotNullAndNotEmpty("Title", book.getTitle());
		assertNotNullAndNotEmpty("Author", book.getAuthour());

	}

	private void assertNotNullAndNotEmpty(final String propertyName, final String value) {
		if (value == null) {
			throw new IllegalArgumentException(propertyName + " must be not null");
		}
		
		if(value.isEmpty()) {
			throw new IllegalArgumentException(propertyName + " must be not empty");
		}
	}
	
	public List<T> getAllBooks() {
		
		return bookDao.findAllBooks();
	}

	public void setBookDao(BookDao bookDao) { //To inject MockDao
		this.bookDao = bookDao;
	}
}
