package edu.java.assignment1.repositories;

import edu.java.assignment1.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
