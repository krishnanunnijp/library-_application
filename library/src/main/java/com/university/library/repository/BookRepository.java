package com.university.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.university.library.dto.BookWithLoanCount;
import com.university.library.entity.Book;
import com.university.library.model.Genre;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("""
		    SELECT new com.university.library.dto.BookWithLoanCount(
		        b,
		        COUNT(CASE WHEN bl.returnDate IS NULL THEN bl.id ELSE NULL END)
		    )
		    FROM Book b
		    LEFT JOIN b.author a
		    LEFT JOIN BookLoan bl ON bl.book = b
		    LEFT JOIN bl.member m
		    WHERE
		        (:isbn IS NULL OR b.isbn = :isbn)
		        AND (:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%')))
		        AND (:authorName IS NULL OR LOWER(a.name) LIKE LOWER(CONCAT('%', :authorName, '%')))
		        AND (:genre IS NULL OR b.genre = :genre)
		        AND (:publicationYearFrom IS NULL OR b.publicationYear >= :publicationYearFrom)
		        AND (:publicationYearTo IS NULL OR b.publicationYear <= :publicationYearTo)
		        AND (:publisher IS NULL OR LOWER(b.publisher) LIKE LOWER(CONCAT('%', :publisher, '%')))
		        AND (:loanedByMemberId IS NULL OR m.memberId = :loanedByMemberId)
		        AND (:reservedByMemberId IS NULL OR EXISTS (
		            SELECT 1 FROM Reservation r WHERE r.book = b AND r.member.memberId = :reservedByMemberId
		        ))
		    GROUP BY b
		""")
		Page<BookWithLoanCount> searchWithFilters(
		    @Param("isbn") String isbn,
		    @Param("title") String title,
		    @Param("authorName") String authorName,
		    @Param("genre") Genre genre,
		    @Param("publicationYearFrom") Integer publicationYearFrom,
		    @Param("publicationYearTo") Integer publicationYearTo,
		    @Param("publisher") String publisher,
		    @Param("loanedByMemberId") String loanedByMemberId,
		    @Param("reservedByMemberId") String reservedByMemberId,
		    Pageable pageable
		);




}


