package home.and.company.books.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Builder for 'BookDetails' object. Note: Ideally this can be generated with 'Lambok'
public class BookDetails {

	@JsonIgnore
	private long bookId; // Restricted to user
	private String description;
	private String publishedDate;
	private String lanuage;
	private int noOfPages;
	private String publisher;
	
	public BookDetails()
	{
		//Default. Spring is happy
	}
	
	public BookDetails(final long bookId, 
			final String description, 
			final String publishedDate, 
			final String lanuage, 
			final int noOfPages,
			final String publisher) {

		this.bookId = bookId;
		this.description = description;
		this.publishedDate = publishedDate;
		this.lanuage = lanuage;
		this.noOfPages = noOfPages;
		this.publisher = publisher;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getLanuage() {
		return lanuage;
	}

	public void setLanuage(String lanuage) {
		this.lanuage = lanuage;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
