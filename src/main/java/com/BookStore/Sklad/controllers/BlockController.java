package com.BookStore.Sklad.controllers;

import com.BookStore.Sklad.models.Books;
import com.BookStore.Sklad.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;

@Controller
public class BlockController {

    @Autowired
    private BooksRepository booksRepository;

    @GetMapping("/block")
    public String blockMain(Model model)
    {
        Iterable<Books> book = booksRepository.findAll();
        model.addAttribute("book", book);
        return "tovar_block";
    }

    @GetMapping("/block/add")
    public String blockAdd(Model model)
    {return "block_add";}


    @PostMapping("/block/add")
    public String blockPostAdd(@RequestParam String book_Name,
                               @RequestParam String author_Name,
                               @RequestParam int count,
                               @RequestParam int price,Model model)
    {
        Books books = new Books(book_Name,author_Name,count,price);
        booksRepository.save(books);
        return "redirect:/block";
    }
}
