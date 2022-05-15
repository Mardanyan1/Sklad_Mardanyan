package com.BookStore.Sklad.controllers;

import com.BookStore.Sklad.models.Books;
import com.BookStore.Sklad.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BooksRepository booksRepository;

    @GetMapping("/book")
    public String blockMain(Model model)
    {
        Iterable<Books> book = booksRepository.findAll();
        model.addAttribute("book", book);
        return "book_block";
    }

    @GetMapping("/book/add")
    public String blockAdd(Model model)
    {return "book_add";}


    @PostMapping("/book/add")
    public String blockPostAdd(@RequestParam String book_Name,
                               @RequestParam String author_Name,
                               @RequestParam int count,
                               @RequestParam int price,Model model)
    {
        Books books = new Books(book_Name,author_Name,count,price);
        booksRepository.save(books);
        return "redirect:/";
    }

    @GetMapping("/book/{id}")
    public String bookDetails(@PathVariable(value = "id") long id, Model model)
    {
        if(!booksRepository.existsById(id))
        {
            return "redirect:/";
        }
        Optional<Books> book = booksRepository.findAllById(id);
        ArrayList<Books> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "book_details";
    }

    @GetMapping("/book/{id}/edit")
    public String bookEdit(@PathVariable(value = "id") long id, Model model)
    {
        if(!booksRepository.existsById(id))
        {
            return "redirect:/";
        }
        Optional<Books> book = booksRepository.findAllById(id);
        ArrayList<Books> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "book_edit";
    }

    @PostMapping("/book/{id}/edit")
    public String bookPostEdit(@PathVariable(value = "id") long id,
                               @RequestParam String book_Name,
                               @RequestParam String author_Name,
                               @RequestParam int count,
                               @RequestParam int price, Model model)
    {
        Books books = booksRepository.findAllById(id).orElseThrow();
        books.setBook_Name(book_Name);
        books.setAuthor_Name(author_Name);
        books.setCount(count);
        books.setPrice(price);
        booksRepository.save(books);
        return "redirect:/book";
    }


    @PostMapping("/book/{id}/remove")
    public String blockPostDelete(@PathVariable(value = "id") long id, Model model)
    {
        Books books = booksRepository.findAllById(id).orElseThrow();
        booksRepository.delete(books);
        return "redirect:/book";
    }
}
