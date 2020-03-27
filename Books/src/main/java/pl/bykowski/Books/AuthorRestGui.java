package pl.bykowski.Books;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bykowski.Books.repo.AuthorDto;
import pl.bykowski.Books.repo.AuthorRepo;

import java.util.ArrayList;
import java.util.List;

@Route
public class AuthorRestGui extends VerticalLayout {

    private AuthorRepo authorRepo;

    @Autowired
    public AuthorRestGui(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;

        List<AuthorDto> personList = authorRepo.getCategoryCount(); // tworzymy liste obiektó tore będą [pobierane z bazy danych
        Grid<AuthorDto> grid = new Grid<>(AuthorDto.class); // te elementy będziemy wyświetlać
        grid.setItems(personList);
        add(grid);
    }
}
