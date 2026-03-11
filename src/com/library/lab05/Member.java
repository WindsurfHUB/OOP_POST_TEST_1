package com.library.lab05;

public class Member {
    private String memberId;
    private String name;
    private int currentBorrowedCount;
    private MembershipStrategy membershipStrategy;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.currentBorrowedCount = 0;
        // Default strategy
        this.membershipStrategy = new BasicMembershipStrategy();
    }

    public Member(String memberId, String name, MembershipStrategy strategy) {
        this.memberId = memberId;
        this.name = name;
        this.currentBorrowedCount = 0;
        this.membershipStrategy = strategy;
    }

    public boolean canBorrow() {
        if (membershipStrategy.hasUnlimitedBorrowing()) {
            return true;
        }
        return currentBorrowedCount < membershipStrategy.getBorrowLimit();
    }

    public void incrementBorrowedCount() {
        currentBorrowedCount++;
    }

    public void decrementBorrowedCount() {
        if (currentBorrowedCount > 0) currentBorrowedCount--;
    }

    public void setMembershipStrategy(MembershipStrategy strategy) {
        this.membershipStrategy = strategy;
    }

    public MembershipStrategy getMembershipStrategy() {
        return membershipStrategy;
    }

    public double calculateLateFee(double baseFee) {
        return membershipStrategy.applyLateFeeDiscount(baseFee);
    }

    public void displayMemberInfo() {
        System.out.println("\n--- MEMBER INFORMATION ---");
        System.out.println("ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Membership Type: " + membershipStrategy.getMembershipType());
        System.out.println("Membership Cost: " + membershipStrategy.getMembershipCost() + " Baht");
        System.out.println("Borrow Limit: " + (membershipStrategy.hasUnlimitedBorrowing() ? "Unlimited" : membershipStrategy.getBorrowLimit()));
        System.out.println("Currently Borrowed: " + currentBorrowedCount);
        System.out.println("Loan Period: " + membershipStrategy.getLoanPeriodDays() + " days");
    }

    // Getters
    public String getName() { return name; }
    public String getMemberId() { return memberId; }
}