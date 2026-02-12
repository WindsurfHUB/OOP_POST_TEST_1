package com.library.lab01;
//Lab 02
public class Member {
    private String memberId;
    private String name;
    private int currentBorrowedCount; // Track limit for challenge
    private static final int MAX_BORROW_LIMIT = 3;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.currentBorrowedCount = 0;
    }

    public boolean canBorrow() {
        return currentBorrowedCount < MAX_BORROW_LIMIT;
    }

    public void incrementBorrowedCount() {
        currentBorrowedCount++;
    }

    public void decrementBorrowedCount() {
        if (currentBorrowedCount > 0) currentBorrowedCount--;
    }

    // Getters
    public String getName() { return name; }
    public String getMemberId() { return memberId; }
}