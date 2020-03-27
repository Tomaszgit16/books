package pl.bykowski.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bykowski.Books.repo.AuthorDto;
import pl.bykowski.Books.repo.AuthorRepo;

import java.util.List;

@RestController
public class AuthorRestApi {

    private AuthorRepo authorRepo;

    @Autowired
    public AuthorRestApi(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("/getAuthorInfo")
    public List<AuthorDto> get(){ // zorbiliśmy z tego listę authorówdto
        return authorRepo.getCategoryCount();
    }
}
