package app.prog.service;

import app.prog.controller.mapper.AuthorMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.model.Author;
import app.prog.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;
    private AuthorMapper mapper;

    public List<Author> getAuthors(){ return authorRepository.findAll();}

    @Transactional
    public List<Author> createAuthors(List<Author> toCreate){
        return authorRepository.saveAll(toCreate);
    }

    @Transactional
    public List<Author> updateAuthors(List<Author> toUpdate){
        return authorRepository.saveAll((toUpdate));
    }

    public ResponseEntity<AuthorResponse> deleteAuthor(int AuthorId){
        Optional<Author> optional=authorRepository.findById(Integer.valueOf(AuthorId));
        if(optional.isPresent()){
            authorRepository.delete(optional.get());
            return ResponseEntity.status(200).body(mapper.toRest(optional.get()));
        }else{
            return ResponseEntity.status(404)
                    .header("Author."+ AuthorId +"not found")
                    .body(null);
        }
    }


}
