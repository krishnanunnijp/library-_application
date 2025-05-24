package com.university.library.dto;

import com.university.library.entity.Book;

public class BookWithLoanCount {
    private Book book;
    private long activeLoanCount;

    public BookWithLoanCount(Book book, long activeLoanCount) {
        this.book = book;
        this.activeLoanCount = activeLoanCount;
    }

    public Book getBook() {
        return book;
    }

    public long getActiveLoanCount() {
        return activeLoanCount;
    }
}
