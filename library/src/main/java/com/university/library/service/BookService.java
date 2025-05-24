package com.university.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.university.library.dto.BookSearchResponseDto;
import com.university.library.dto.BookWithLoanCount;
import com.university.library.dto.AuthorDto;
import com.university.library.entity.Book;
import com.university.library.model.Genre;
import com.university.library.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Page<BookSearchResponseDto> searchBooks(
            String isbn,
            String title,
            String authorName,
            Genre genre,
            Integer publicationYearFrom,
            Integer publicationYearTo,
            String publisher,
            Boolean isAvailable,
            String loanedByMemberId,
            String reservedByMemberId,
            Pageable pageable) {

        Page<BookWithLoanCount> booksWithCounts = bookRepository.searchWithFilters(
                isbn, title, authorName, genre,
                publicationYearFrom, publicationYearTo, publisher,
                loanedByMemberId, reservedByMemberId, pageable
        );

        return booksWithCounts.map(bwl -> {
            Book book = bwl.getBook();
            long activeLoans = bwl.getActiveLoanCount();
            int availableCopies = book.getTotalCopies() - (int) activeLoans;

            AuthorDto authorDto = new AuthorDto();
            authorDto.setId(book.getAuthor().getId());
            authorDto.setName(book.getAuthor().getName());
            authorDto.setBirthDate(book.getAuthor().getBirthDate());

            BookSearchResponseDto dto = new BookSearchResponseDto();
            dto.setId(book.getId());
            dto.setIsbn(book.getIsbn());
            dto.setTitle(book.getTitle());
            dto.setGenre(book.getGenre().name());
            dto.setPublicationYear(book.getPublicationYear());
            dto.setPublisher(book.getPublisher());
            dto.setTotalCopies(book.getTotalCopies());
            dto.setAvailableCopies(availableCopies);
            dto.setAuthor(authorDto);

            return dto;
        });
    }

}
