package com.library.lab05;

public class EBook extends LibraryItem implements DigitalContent, Taxable {
    private String downloadUrl;
    private double fileSizeMB;

    public EBook(String title, String author, String isbn, String downloadUrl, double fileSizeMB) {
        super(title, author, isbn, 99.0, "Available");
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public void displayDetails() {
        System.out.println("E-BOOK");
        super.displayDetails();
        System.out.println("Download URL: " + downloadUrl);
        System.out.printf("File Size: %.2f MB\n", fileSizeMB);
        System.out.println("Status: " + getStatus());
        System.out.println("Return Due Date: " + (getReturnDueDate() == null ? "N/A (Item is available)" : getReturnDueDate()));
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0;
    }

    @Override
    public void streamOnline() {
        System.out.println("Streaming '" + getTitle() + "' from URL: " + downloadUrl);
        System.out.println("    Starting online stream... connected!");
        System.out.println("    You can now read the book online without downloading.");
    }

    @Override
    public void download() {
        System.out.println("Downloading '" + getTitle() + "' from URL: " + downloadUrl);
        System.out.printf("    Downloading file... (%.2f MB)\n", fileSizeMB);
        System.out.println("    Download complete! File saved to your device.");
        System.out.println("    You can now read the book offline.");
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax for digital items
    }

    @Override
    public void printSummary() {
        System.out.printf("EBook [Title='%s', Size='%.2f MB', Status='%s']\n", getTitle(), fileSizeMB, getStatus());
    }
}
