package home.and.company.books.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import home.and.company.books.app.model.Book;
import home.and.company.books.app.services.BookService;

@Controller
@RequestMapping("/mvc")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ModelAndView getBook(@RequestParam String isbn) {

		Book book = (Book) bookService.getBookByIsbn(isbn).get();
		System.out.println(book.getTitle());
		ModelAndView bookModelView = new ModelAndView("bookInfo", "book", book);

		return bookModelView;
	}

	@GetMapping("/addBook")
	public ModelAndView addBook() {

		ModelAndView bookModelView = new ModelAndView("bookForm", "book", new Book());

		return bookModelView;
	}

	@PostMapping("/do.addBook")
	public ModelAndView doAddBook(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return new ModelAndView("error", "error_model", null);
		}

		long bookId = bookService.persist(book);
		System.out.println("New book ID: " + bookId);
		Book savedBook = (Book) bookService.getAllBooks().stream().findAny().get();

		ModelAndView bookModelView = new ModelAndView("bookInfo", "book", savedBook);

		return bookModelView;
	}

}
