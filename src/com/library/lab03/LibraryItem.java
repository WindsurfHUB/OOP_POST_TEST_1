package com.library.lab03;

import java.time.LocalDate;

public class LibraryItem {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String status;
    private LocalDate returnDueDate;

    public LibraryItem(String title, String author, String isbn, double price, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.status = status;
        this.returnDueDate = null;
    }

    public void checkOut(Member borrower) {
        if ("Borrowed".equalsIgnoreCase(this.status)) {
            System.out.println("Error: Item '" + this.title + "' is already borrowed and cannot be checked out again.");
            return;
        }

        if (!borrower.canBorrow()) {
            System.out.println("Member " + borrower.getName() + " has reached the borrow limit.");
            return;
        }

        this.status = "Borrowed";
        this.returnDueDate = LocalDate.now().plusDays(14);
        borrower.incrementBorrowedCount();

        System.out.println("Item '" + this.title + "' has been checked out successfully.");
        System.out.println("Item '" + this.title + "' has been borrowed by " + borrower.getName() + ".");
        System.out.println("Return Due Date: " + this.returnDueDate);
    }

    public void returnItem() {
        this.status = "Available";
        this.returnDueDate = null;
        System.out.println("Item '" + this.title + "' has been returned successfully.");
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price: " + price + " Baht");
    }

    public double calculateLateFee(int daysLate) {
        return 0.0;
    }

    public void printSummary() {
        System.out.println("Item [Title='" + title + "', Status='" + status + "']");
    }

    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public LocalDate getReturnDueDate() { return returnDueDate; }
}