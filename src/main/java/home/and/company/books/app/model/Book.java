package home.and.company.books.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book {

	@JsonIgnore
	private long bookId; //Primary key. Restricted to end user
	private String isbn; //Unique. Not null
	private String title; //Not null
	private String authour;//Not null
	private String price;
	private BookDetails details;
		
	public Book() {
		//Default. Spring is happy
	}

	public Book(final long bookId, 
				final String isbn, 
				final String title, 
				final String authour, 
				final String price,
				final BookDetails details) {

		this.bookId = bookId;
		this.isbn = isbn;
		this.title = title;
		this.authour = authour;
		this.price = price;
		this.details = details;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthour() {
		return authour;
	}

	public void setAuthour(String authour) {
		this.authour = authour;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public BookDetails getDetails() {
		return details;
	}

	public void setDetails(BookDetails details) {
		this.details = details;
	}

	@Override
	public String toString() {
		
		return "Book [ISBN = " + isbn + ", Title = " + title + ", Author = " + authour + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authour == null) ? 0 : authour.hashCode());
		result = prime * result + (int) (bookId ^ (bookId >>> 32));
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authour == null) {
			if (other.authour != null)
				return false;
		} else if (!authour.equals(other.authour))
			return false;
		if (bookId != other.bookId)
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
}
