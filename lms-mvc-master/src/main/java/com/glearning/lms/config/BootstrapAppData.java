package com.glearning.lms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.glearning.lms.model.Book;
import com.glearning.lms.repository.BookJpaRepository;

@Configuration
public class BootstrapAppData {

	@Autowired
	private BookJpaRepository bookRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void onReady(ApplicationReadyEvent event) {

		Book java = new Book();
		java.setName("Java");
		java.setAuthor("James Gosling");
		java.setCategory("programming");

		Book python = new Book();
		python.setName("Python");
		python.setAuthor("James");
		python.setCategory("programming");

		Book atomicHabbits = new Book();
		atomicHabbits.setName("Java");
		atomicHabbits.setAuthor("John Doe");
		atomicHabbits.setCategory("Personality Development");

		Book sanskrit = new Book();
		sanskrit.setName("Sanskrit for beginners");
		sanskrit.setAuthor("Purushottam");
		sanskrit.setCategory("language");

		this.bookRepository.save(java);
		this.bookRepository.save(python);

		this.bookRepository.save(atomicHabbits);
		this.bookRepository.save(sanskrit);

	}

}
