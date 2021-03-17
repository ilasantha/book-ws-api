package com.digital.java.code.assignment.books.rest.resource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import home.and.company.books.app.model.Book;
import home.and.company.books.app.services.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BookResourceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookService bookService;
	
	@Mock
	private Book dummykBook;
	
	@Before
	public void setup() {
		//dummykBook = new Book(); //As Jackson not like Mocks 
		MockitoAnnotations.initMocks(this);
		when(dummykBook.getIsbn()).thenReturn("6354");
		//dummykBook.setIsbn("6354");
	}
	
	
	@Test
    public void findBookByValidId_ThenSucessTest() throws Exception {
        when(bookService.getBookByIsbn(anyString()).get()).thenReturn(dummykBook); //Mocking the service call
        
        this.mockMvc.perform(get("/books/" + dummykBook.getIsbn()))
        			.andExpect(status().isOk())
        			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        			.andExpect(jsonPath("$.isbn").value(dummykBook.getIsbn()));
        verify(bookService).getBookByIsbn(anyString());
      }
	
	@Test
    public void findBookByInValidId_ThenExceptionHandleTest() throws Exception {
        when(bookService.getBookByIsbn(anyString())).thenReturn(null); //Mocking the service call. null obj found
        
        this.mockMvc.perform(get("/books/" + "invalidId"))
        			.andExpect(status().isNotFound())
        			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
      }
	
	
	@Test
    public void saveBookWithMmandatoryParamsFilled_ThenSucessTest() throws Exception {
		//dummykBook.setTitle("Spring Boot");
		//dummykBook.setAuthour("Tim");
		
		when(dummykBook.getTitle()).thenReturn("Spring Boot");
		when(dummykBook.getAuthour()).thenReturn("Tim");
		
	    when(bookService.persist(any(Book.class))).thenReturn(1L); //Mocking the service call
        
        
        this.mockMvc.perform(post("/books")
        			.contentType(MediaType.APPLICATION_JSON_VALUE)
        			.content(getJasonStringFor(dummykBook)))
        			.andExpect(status().isOk())
        			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        			.andExpect(jsonPath("$.operation").value("SAVE"))
        			;
        verify(bookService).persist(dummykBook);
      }
	
	private String getJasonStringFor(final Object object) throws JsonProcessingException {
		ObjectMapper jasonMapper = new ObjectMapper();
		return jasonMapper.writeValueAsString(object);
	}
}
