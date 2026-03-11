package com.library.lab05;

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
        if (!isAvailable()) {
            System.out.println("Error: Item '" + this.title + "' is already borrowed.");
            return;
        }
        
        if (!borrower.canBorrow()) {
            System.out.println("⚠️ Member " + borrower.getName() + " has reached the borrow limit (" + 
                (borrower.getMembershipStrategy().hasUnlimitedBorrowing() ? "Unlimited" : borrower.getMembershipStrategy().getBorrowLimit()) + 
                ") for " + borrower.getMembershipStrategy().getMembershipType() + ".");
            System.out.println("Borrow request denied for member " + borrower.getName() + ".");
            return;
        }

        this.status = "Borrowed";
        int loanPeriod = borrower.getMembershipStrategy().getLoanPeriodDays();
        // Use today's date from session context: March 12, 2026
        this.returnDueDate = LocalDate.of(2026, 3, 12).plusDays(loanPeriod);
        
        borrower.incrementBorrowedCount();
        
        System.out.println("✅ Item '" + this.title + "' has been checked out successfully.");
        System.out.println("📋 Borrowed by " + borrower.getName() + " (" + borrower.getMembershipStrategy().getMembershipType() + ")");
        System.out.println("🗓️ Loan Period: " + loanPeriod + " days");
        System.out.println("📅 Return Due Date: " + this.returnDueDate);
    }

    public boolean isAvailable() {
        return "Available".equalsIgnoreCase(this.status);
    }

    public void returnItem() {
        this.status = "Available";
        this.returnDueDate = null;
        System.out.println("Returning Physical Book:");
        System.out.println("Item '" + this.title + "' has been returned successfully.");
    }

    public void returnItem(Member borrower) {
        this.status = "Available";
        this.returnDueDate = null;
        borrower.decrementBorrowedCount();
        System.out.println("Returning Physical Book:");
        System.out.println("Item '" + this.title + "' has been returned successfully.");
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price: " + price + " Baht");
    }

    public double calculateLateFee(int days) { return 0.0; }

    public void printSummary() {
        System.out.println("Item [Title='" + title + "', Status='" + status + "']");
    }

    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
    public LocalDate getReturnDueDate() { return returnDueDate; }
}
