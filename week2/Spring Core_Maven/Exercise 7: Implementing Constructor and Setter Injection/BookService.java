package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository constructorRepo;
    private BookRepository setterRepo;

    public BookService(BookRepository constructorRepo) {
        this.constructorRepo = constructorRepo;
    }

    public void setSetterRepo(BookRepository setterRepo) {
        this.setterRepo = setterRepo;
    }

    public void display() {
        System.out.println("Constructor Injection:");
        constructorRepo.display();

        System.out.println("Setter Injection:");
        setterRepo.display();
    }
}
