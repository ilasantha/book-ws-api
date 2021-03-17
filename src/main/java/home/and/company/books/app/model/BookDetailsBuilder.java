package home.and.company.books.app.model;

//Builder for 'BookDetails' object. Note: Ideally this can be generated with 'Lambok'
public class BookDetailsBuilder {

	private long bookId; // Foreign key (Primary key of 'Book' entity). Restricted to end user
	private String description;
	private String publishedDate;
	private String lanuage;
	private short noOfPages;
	private String publisher;

	public BookDetailsBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public BookDetailsBuilder withPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
		return this;
	}

	public BookDetailsBuilder withLanuage(String lanuage) {
		this.lanuage = lanuage;
		return this;
	}

	public BookDetailsBuilder withNoOfPages(short noOfPages) {
		this.noOfPages = noOfPages;
		return this;
	}
	
	public BookDetailsBuilder withPublisher(String publisher) {
		this.publisher = publisher;
		return this;
	}

	public BookDetails create() {
		return new BookDetails(bookId, description, publishedDate, lanuage, noOfPages, publisher);
	}

}
