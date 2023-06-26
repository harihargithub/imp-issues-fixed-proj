package com.glearning.lms.service;

import java.util.List;

import com.glearning.lms.model.Book;

public interface BookService {
	
	Book save(Book book);
	
	List<Book> findAll();
	
	Book findBookById(int id);
	
	void deleteBoodById(int id);
	

}
