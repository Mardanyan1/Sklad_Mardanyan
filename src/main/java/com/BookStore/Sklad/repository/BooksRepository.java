package com.BookStore.Sklad.repository;

import com.BookStore.Sklad.models.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Long>{
}
