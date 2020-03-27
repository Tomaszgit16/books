package pl.bykowski.Books.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.bykowski.Books.entity.Author;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, Long> {
// bez aliasów nie zozumiało te nazwy author.name musza być takie same jak sa w interfejsie ponieważ to wszywtko jest rozsrzygane an podatwie refleksji
    @Query(value = "SELECT AUTHOR.NAME as Author, COUNT(AUTHOR.NAME) as CategoryCount, BOOK.BOOK_CATEGORY as BookCategory\n" +
            "FROM AUTHOR, BOOK\n" +
            "GROUP BY BOOK_CATEGORY", nativeQuery = true)
    List<AuthorDto> getCategoryCount(); // Trzeba utworzyć data transfer object ktore bedzie maila te 3 kollumny ktorych nie mamy w bazie
}
