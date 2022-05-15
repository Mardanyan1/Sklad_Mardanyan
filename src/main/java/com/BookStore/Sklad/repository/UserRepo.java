package com.BookStore.Sklad.repository;

import com.BookStore.Sklad.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {User findByUsername(String username);}
