package com.example.demo.persistence;

import com.example.demo.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorsRepositoryAdapter implements CrudRepository<Author, Long> {
    private final AuthorsRepository authorsRepository;

    public AuthorsRepositoryAdapter(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public Author save(Author author) {
        return authorsRepository.save(author);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorsRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        authorsRepository.deleteById(id);
    }
}
