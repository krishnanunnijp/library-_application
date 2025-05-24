package com.university.library.dto;

import com.university.library.model.Genre;
import lombok.Data;

@Data
public class BookSearchRequestDto {
    private String isbn;
    private String title;
    private String authorName;
    private Genre genre;
    private Integer publicationYearFrom;
    private Integer publicationYearTo;
    private String publisher;
    private Boolean isAvailable;
    private String loanedByMemberId;
    private String reservedByMemberId;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Integer getPublicationYearFrom() {
		return publicationYearFrom;
	}
	public void setPublicationYearFrom(Integer publicationYearFrom) {
		this.publicationYearFrom = publicationYearFrom;
	}
	public Integer getPublicationYearTo() {
		return publicationYearTo;
	}
	public void setPublicationYearTo(Integer publicationYearTo) {
		this.publicationYearTo = publicationYearTo;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getLoanedByMemberId() {
		return loanedByMemberId;
	}
	public void setLoanedByMemberId(String loanedByMemberId) {
		this.loanedByMemberId = loanedByMemberId;
	}
	public String getReservedByMemberId() {
		return reservedByMemberId;
	}
	public void setReservedByMemberId(String reservedByMemberId) {
		this.reservedByMemberId = reservedByMemberId;
	}
    
    
}
