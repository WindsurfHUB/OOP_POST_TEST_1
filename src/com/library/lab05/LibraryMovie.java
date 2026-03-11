package com.library.lab05;

public class LibraryMovie implements DigitalContent {
    private String title;
    private String director;
    private String streamingUrl;
    private int durationMinutes;
    private int year;
    private String genre;
    private double price;

    public LibraryMovie(String title, String director, String streamingUrl, int durationMinutes, int year, String genre, double price) {
        this.title = title;
        this.director = director;
        this.streamingUrl = streamingUrl;
        this.durationMinutes = durationMinutes;
        this.year = year;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void streamOnline() {
        System.out.println("Streaming '" + title + "' from URL: " + streamingUrl);
        System.out.println("    Starting online stream... connected!");
        System.out.println("    You can now watch the movie online without downloading.");
    }

    @Override
    public void download() {
        System.out.println("Downloading '" + title + "' from URL: " + streamingUrl);
        System.out.println("    Downloading file... (1024.00 MB)");
        System.out.println("    Download complete! File saved to your device.");
        System.out.println("    You can now watch the movie offline.");
    }
}
