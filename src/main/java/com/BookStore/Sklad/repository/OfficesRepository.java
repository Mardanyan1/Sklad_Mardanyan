package com.BookStore.Sklad.repository;

import com.BookStore.Sklad.models.Offices;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OfficesRepository extends CrudRepository<Offices, Long> {
    Optional<Offices> findAllById(long id);
}
