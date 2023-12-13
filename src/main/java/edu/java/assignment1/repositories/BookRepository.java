package edu.java.assignment1.repositories;

import edu.java.assignment1.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
