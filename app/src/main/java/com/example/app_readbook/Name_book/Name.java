package com.example.app_readbook.Name_book;

import com.example.app_readbook.Name_book.book.book;

import java.util.List;

public class Name {
    private String name ;
    private String sl;
    private String all;
    private List<book> nameBook;

    public Name(String name, String sl, String all, List<book> nameBook) {
        this.name = name;
        this.sl = sl;
        this.all = all;
        this.nameBook = nameBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public List<book> getNameBook() {
        return nameBook;
    }

    public void setNameBook(List<book> nameBook) {
        this.nameBook = nameBook;
    }
}
