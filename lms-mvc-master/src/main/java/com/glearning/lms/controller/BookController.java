package com.glearning.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.lms.model.Book;
import com.glearning.lms.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/list")
	public String listBooks(Model model) {
		List<Book> books = this.bookService.findAll();
		model.addAttribute("books", books);
		return "books/list-books";
	}

	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book book) {
		this.bookService.save(book);
		return "redirect:/books/list";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		// create model attribute to bind form data
		Book book = new Book();

		model.addAttribute("book", book);

		return "books/book-form";
	}

	@PostMapping("/delete")
	public String deleteBook(@RequestParam("id") int id) {
		this.bookService.deleteBoodById(id);
		return "redirect:/books/list";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {

		// get the book from the service
		Book theBook = bookService.findBookById(id);

		// set book as a model attribute to pre-populate the form
		model.addAttribute("book", theBook);

		return "books/book-form";
	}

}
