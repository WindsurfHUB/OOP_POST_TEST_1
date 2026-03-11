package com.library.lab05;

public class PhysicalBook extends LibraryItem implements Taxable {
    private String shelfLocation;

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn, price, "Available");
        this.shelfLocation = shelfLocation;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.07; // 7% tax for physical items
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
    public double calculateLateFee(int days) {
        return days * 5.0;
    }

    @Override
    public void printSummary() {
        System.out.println("PhysicalBook [Title='" + getTitle() + "', Location='" + shelfLocation + "', Status='" + getStatus() + "']");
    }
}
