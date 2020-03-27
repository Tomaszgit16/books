package pl.bykowski.Books.repo;

public interface AuthorDto {

    String getAuthor(); // żeby zwrócić pierwsza kolumnę
    int getCategoryCount();
    String getBookCategory();

}
