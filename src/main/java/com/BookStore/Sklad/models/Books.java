package com.BookStore.Sklad.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author_Name, book_Name;

    private int count, price;

    public Books(String book_name, String author_name, int count, int price) {
        this.book_Name=book_name;
        this.author_Name=author_name;
        this.count=count;
        this.price=price;
    }

    public Books() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor_Name() {
        return author_Name;
    }

    public void setAuthor_Name(String author_Name) {
        this.author_Name = author_Name;
    }

    public String getBook_Name() {
        return book_Name;
    }

    public void setBook_Name(String book_Name) {
        this.book_Name = book_Name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
