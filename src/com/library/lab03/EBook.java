package com.library.lab03;

public class EBook extends LibraryItem {
    private String downloadUrl;
    private double fileSizeMB;

    public EBook(String title, String author, String isbn, String downloadUrl, double fileSizeMB) {
        super(title, author, isbn, 0.0, "Available");
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public void displayDetails() {
        System.out.println("E-BOOK");
        super.displayDetails();
        System.out.println("Download URL: " + downloadUrl);
        System.out.println("File Size: " + fileSizeMB + " MB");
        System.out.println("Status: " + getStatus());
        System.out.println("Return Due Date: " + (getReturnDueDate() == null ? "N/A (E-book is available)" : getReturnDueDate()));
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0;
    }
}