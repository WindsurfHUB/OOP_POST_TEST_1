package com.library.lab03;

public class PhysicalBook extends LibraryItem {
    private String shelfLocation;

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn, price, "Available");
        this.shelfLocation = shelfLocation;
    }

    @Override
    public void displayDetails() {
        System.out.println("PHYSICAL BOOK");
        super.displayDetails();
        System.out.println("Shelf Location: " + shelfLocation);
        System.out.println("Status: " + getStatus());
        System.out.println("Return Due Date: " + (getReturnDueDate() == null ? "N/A (Book is available)" : getReturnDueDate()));
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 5.0;
    }

    @Override
    public void printSummary() {
        System.out.println("PhysicalBook [Title='" + getTitle() + "', Location='" + shelfLocation + "', Status='" + getStatus() + "']");
    }
}