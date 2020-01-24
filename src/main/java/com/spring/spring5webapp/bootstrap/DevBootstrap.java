package com.spring.spring5webapp.bootstrap;

import com.spring.spring5webapp.model.Author;
import com.spring.spring5webapp.model.Book;
import com.spring.spring5webapp.model.Publisher;
import com.spring.spring5webapp.repository.AuthorRepository;
import com.spring.spring5webapp.repository.BookRepository;
import com.spring.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

      private AuthorRepository authorRepository;
      private BookRepository bookRepository;
      private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    private void initData() {

        //Publisher
        Publisher publisher = new Publisher();
        publisher.setName("BNB");
        publisher.setAddress("Kabuga");

        //save data

        publisherRepository.save(publisher);

        //Bertin
        Author bertin = new Author("Ruhimbaza", "Bertin");
        Book java = new Book("design pattern","1223", publisher);
        bertin.getBooks().add(java);
        java.getAuthors().add(bertin);

        //save data
        authorRepository.save(bertin);
        bookRepository.save(java);


        //Bad
        Author bad = new Author("Rama", "Bad");
        Book math = new Book("development", "564", publisher);
        bad.getBooks().add(math);
        math.getAuthors().add(bad);

        //save data
        authorRepository.save(bad);
        bookRepository.save(math);

    }


}