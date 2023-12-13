package edu.java.assignment1.bootstrap;

import edu.java.assignment1.domain.Author;
import edu.java.assignment1.domain.Book;
import edu.java.assignment1.domain.Publisher;
import edu.java.assignment1.repositories.AuthorRepository;
import edu.java.assignment1.repositories.BookRepository;
import edu.java.assignment1.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author jonathan = new Author("Jonathan", "Edwin");
        Book webProgramming = new Book("Web Programming", "04867389523");
        jonathan.getBooks().add(webProgramming);
        webProgramming.getAuthors().add(jonathan);
        authorRepository.save(jonathan);
        bookRepository.save(webProgramming);

        Author brendan = new Author("Brendan", "Eich");
        Book javascript = new Book("Javascript Basics", "7569084556");
        brendan.getBooks().add(javascript);
        javascript.getAuthors().add(brendan);
        authorRepository.save(brendan);
        bookRepository.save(javascript);

        Publisher marcus = new Publisher("Marcus", "9 Claydon Grove", "Truganina", "Victoria", "3029");
        publisherRepository.save(marcus);
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
        webProgramming.setPublisher(marcus);
        marcus.getBooks().add(webProgramming);
        publisherRepository.save(marcus);
        System.out.println("Publisher Number of Books: " + marcus.getBooks().size());
    }
}
