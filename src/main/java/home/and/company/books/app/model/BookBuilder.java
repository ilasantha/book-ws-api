package home.and.company.books.app.model;

//Builder for 'Book' object. Note: Ideally this can be generated with 'Lambok'
public class BookBuilder {

	private long bookId; // Restricted to end user
	private String isbn;
	private String title;
	private String authour;
	private String price;
	private BookDetails details;

	public BookBuilder withBookId(long bookId) {
		this.bookId = bookId;
		return this;
	}

	public BookBuilder withIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public BookBuilder withTitle(String title) {
		this.title = title;
		return this;
	}

	public BookBuilder withAuthour(String authour) {
		this.authour = authour;
		return this;
	}

	public BookBuilder withPrice(String price) {
		this.price = price;
		return this;
	}

	public BookBuilder withBookDetails(BookDetails details) {
		details.setBookId(bookId);
		this.details = details;
		return this;

	}

	public Book create() {
		return new Book(bookId, isbn, title, authour, price, details);
	}

}
