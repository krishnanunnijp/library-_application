package com.university.library.controller;

import com.university.library.dto.BookSearchResponseDto;
import com.university.library.model.Genre;
import com.university.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public ResponseEntity<Page<BookSearchResponseDto>> searchBooks(
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String authorName,
            @RequestParam(required = false) Genre genre,
            @RequestParam(required = false) Integer publicationYearFrom,
            @RequestParam(required = false) Integer publicationYearTo,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) Boolean isAvailable,
            @RequestParam(required = false) String loanedByMemberId,
            @RequestParam(required = false) String reservedByMemberId,
            @PageableDefault(page = 0, size = 20) Pageable pageable
    ) {
        Page<BookSearchResponseDto> results = bookService.searchBooks(
                isbn, title, authorName, genre,
                publicationYearFrom, publicationYearTo, publisher,
                isAvailable, loanedByMemberId, reservedByMemberId,
                pageable
        );

        return ResponseEntity.ok(results);
    }
}

