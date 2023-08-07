package nils.springframework.spring5webapp.bootstrap;

import nils.springframework.spring5webapp.domain.Author;
import nils.springframework.spring5webapp.domain.Book;
import nils.springframework.spring5webapp.domain.Publisher;
import nils.springframework.spring5webapp.repositories.AuthorRepository;
import nils.springframework.spring5webapp.repositories.BookRepository;

import nils.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petrsburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        System.out.println("Start in Botstrap");

        System.out.println("Publisher Count : "+publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book ("Domain Drivean Design","123123");
        eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Deevlopment without EJB","3939459459");
        rod.getBook().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Numbar of Books" +bookRepository.count());
        System.out.println("publisher Number of books : "+publisher.getBooks().size());
    }
}
