package pl.bykowski.Books.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bykowski.Books.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
}
