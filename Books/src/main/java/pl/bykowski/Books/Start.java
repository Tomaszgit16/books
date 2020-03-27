package pl.bykowski.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bykowski.Books.entity.Author;
import pl.bykowski.Books.entity.Book;
import pl.bykowski.Books.entity.BookCategory;
import pl.bykowski.Books.repo.AuthorRepo;
import pl.bykowski.Books.repo.BookRepo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Start {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    @Autowired
    public Start(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;



        Book book1 = new Book(); // kolejność najpierw tworzymy książkę później autora
        book1.setBookCategory(BookCategory.HORROR);
        book1.setTitle("Książka Spring boot 2");
        book1.setIsbn("2dwa2-111222333");
        // klucz obcy jest po stronie wiele wiec ksiażek jest wiele. Najpierw zapisujemy author repo save

        Book book2 = new Book(); // kolejność najpierw tworzymy książkę później autora
        book2.setBookCategory(BookCategory.HORROR);
        book2.setTitle("Aplikacje Internetowe Spring boot 2");
        book2.setIsbn("2dwa3-22333");

        Book book3 = new Book(); // kolejność najpierw tworzymy książkę później autora
        book3.setBookCategory(BookCategory.MEMOIR);
        book3.setTitle("Bolek i Lolek");
        book3.setIsbn("2dw2333");


        Author author = new Author();
        author.setName("Przemek");
        author.setSurname("Bykowski");
        author.setBookSet(Stream.of(book1, book2, book3).collect(Collectors.toSet())); // przerobić stream


        bookRepo.save(book1);
        bookRepo.save(book2);
        bookRepo.save(book3);
        authorRepo.save(author); // uwaga na kolejność bo to nie zaladziałałi gdy authorRepo pierwszy zapisał
    }


}
