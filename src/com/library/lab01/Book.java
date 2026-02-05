package com.library.lab01;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private Double price;
    private String status;
    private LocalDate returnDueDate;


    public Book(String title, String author, String isbn, Double price, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.status = status;
        this.returnDueDate = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayDetails() {
        System.out.println("- Title: " + title);
        System.out.println("- Author: " + author);
        System.out.println("- Isbn: " + isbn);
        System.out.println("- Price: " + price);
        System.out.println("- Status" + status);
        if ("Available".equalsIgnoreCase(status)) {
                System.out.println("Return Due Date: N/A (Book is available)");
            } else {
            System.out.println("- Return Due Date: " + returnDueDate);
        }
    }

    public void checkOut() {
        if ("Borrowed".equalsIgnoreCase(this.status)) {
            System.out.println("Error: Book "+ this.title + " is already borrow and can not be checked out again");
            return;
        }
        this.status = "Borrowed";
        this.returnDueDate = LocalDate.now().plusDays(14);
        System.out.println("Book: " + this.title + " has been checked out successfully.");
        System.out.println("Return Due Date: "+ this.returnDueDate);
    }

    public void returnBook() {
        this.status= "Available";
        this.returnDueDate = null;
        System.out.println("Book " + this.title + " has been returned successfully");
    }
}
