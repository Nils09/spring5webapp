package nils.springframework.spring5webapp.controllers;

import nils.springframework.spring5webapp.domain.Author;
import nils.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @RequestMapping("/author")
    public String getAuthor(Model model)
    {
        model.addAttribute("Author",authorRepository.findAll());
        return "Author/list";
    }
}
