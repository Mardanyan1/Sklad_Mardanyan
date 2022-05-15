package com.BookStore.Sklad.repository;

import com.BookStore.Sklad.models.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BooksRepository extends CrudRepository<Books, Long>{
    Optional<Books> findAllById(long id);
}
