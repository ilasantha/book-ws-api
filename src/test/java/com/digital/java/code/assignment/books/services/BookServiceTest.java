package com.digital.java.code.assignment.books.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import home.and.company.books.app.dao.BookDao;
import home.and.company.books.app.model.Book;
import home.and.company.books.app.services.BookService;

@RunWith(SpringRunner.class)
public class BookServiceTest {

	@Mock
	private BookDao bookDao;

	@MockBean
	private Book bookMock;

	@InjectMocks
	private BookService bookService;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		when(bookDao.persist(bookMock)).thenReturn(2L); // Mocking the BookDao methods

		// Mocking the Mandatory field of Book
		when(bookMock.getIsbn()).thenReturn("Mock_ISBN");
		when(bookMock.getTitle()).thenReturn("Mock_Title");
		when(bookMock.getAuthour()).thenReturn("Mock_Author");
	}

	@Test(expected = IllegalArgumentException.class)
	public void persistBookWithOutMandatryFieldIsbn_thenExceptionTest() {

		when(bookMock.getIsbn()).thenReturn(null); // Missing Mandatory, ISBN
		bookService.persist(bookMock);
		verify(bookDao).persist(bookMock);
		verify(bookMock).getIsbn();
	}

	@Test(expected = IllegalArgumentException.class)
	public void persistBookWithEmptyMandatryFieldIsbn_thenExceptionTest() {

		when(bookMock.getIsbn()).thenReturn(""); // Empty Mandatory, ISBN
		bookService.persist(bookMock);
		verify(bookDao).persist(bookMock);
		verify(bookMock).getIsbn();
	}

	@Test(expected = IllegalArgumentException.class)
	public void persistBookWithOutMandatryFieldTitle_thenExceptionTest() {

		when(bookMock.getTitle()).thenReturn(null); // Missing Mandatory, Title
		bookService.persist(bookMock);
		verify(bookDao).persist(bookMock);
		verify(bookMock).getTitle();
	}

	@Test(expected = IllegalArgumentException.class)
	public void persistBookWithEmptyMandatryFieldTitle_thenExceptionTest() {

		when(bookMock.getTitle()).thenReturn(""); // Empty Mandatory, Title
		bookService.persist(bookMock);
		verify(bookDao).persist(bookMock);
		verify(bookMock).getTitle();
	}

	@Test(expected = IllegalArgumentException.class)
	public void persistBookWithOutMandatryFieldAuthor_thenExceptionTest() {

		when(bookMock.getAuthour()).thenReturn(null); // Missing Mandatory, Author
		bookService.persist(bookMock);
		verify(bookDao).persist(bookMock);
		verify(bookMock).getAuthour();
	}

	@Test(expected = IllegalArgumentException.class)
	public void persistBookWithEmptyMandatryFieldAuthor_thenExceptionTest() {

		when(bookMock.getAuthour()).thenReturn(""); // Empty Mandatory, Author
		bookService.persist(bookMock);
		verify(bookDao).persist(bookMock);
		verify(bookMock).getAuthour();
	}

	@Test
	public void persistBookWithAllMandatryFielField_thenSucessTest() {

		long result = bookService.persist(bookMock);
		verify(bookDao).persist(bookMock);
		verify(bookMock).getAuthour();
		assertTrue("ID should be positive", result > 0);
	}

}
