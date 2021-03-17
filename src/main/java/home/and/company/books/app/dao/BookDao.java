package home.and.company.books.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.and.company.books.app.model.Book;
import home.and.company.books.app.persistent.BookStore;

@Repository
public class BookDao<T extends Book> {

	@Autowired
	private BookStore bookStore;

	@SuppressWarnings("unchecked")
	public Optional<T> findBookById(String isbn) {

		return Optional.ofNullable((T)bookStore.getBooks().get(isbn));
		
	}

	/**
	 * Persist the new 'Book' entity into database.
	 * 
	 * @param newBook
	 * @return new Id if successes. -1 if failed.
	 */
	public long persist(final T newBook) {
		return bookStore.persist(newBook);

	}

	public List<T> findAllBooks() {
		
		return (List<T>) bookStore.getAll();
	}

}
