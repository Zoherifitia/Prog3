package app.prog.controller;

import app.prog.controller.mapper.AuthorMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthorResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.model.Author;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @GetMapping("/authors")
    public List<AuthorResponse> getAuthors(){
        return authorService.getAuthors().stream()
                .map(authorMapper::toRest)
                .toList();
    }

    @PostMapping("/authors")
    public List<AuthorResponse> createAuthors(@RequestBody List<CreateAuthorResponse> toCreate){
        List<Author> domain =toCreate.stream()
                .map(authorMapper::toDomain)
                .toList();
        return authorService.createAuthors(domain).stream()
                .map(authorMapper::toRest)
                .toList();
    }

    @PutMapping("/books")
    public List<AuthorResponse> updateAuthors(@RequestBody List<CreateAuthorResponse> toUpdate){
        List<Author> domain =toUpdate.stream()
                .map(authorMapper::toDomain)
                .toList();
        return authorService.updateAuthors(domain).stream()
                .map(authorMapper::toRest)
                .toList();
    }

    @DeleteMapping("/books/{id}")
    public AuthorResponse deleteAuthor(@PathVariable Integer authorId){
        return authorMapper.toRest(authorService.deleteAuthor(authorId));
    }

}
