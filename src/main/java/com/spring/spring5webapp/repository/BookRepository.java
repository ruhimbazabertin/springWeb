package com.spring.spring5webapp.repository;

import com.spring.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Integer>{
}
