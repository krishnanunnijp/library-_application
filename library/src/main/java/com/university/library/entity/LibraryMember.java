package com.university.library.entity;

import java.time.LocalDate;
import java.util.List;

import com.university.library.model.MemberStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "library_members")
public class LibraryMember {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "MEM-[A-Z0-9]{6}")
    @Column(unique = true, nullable = false)
    private String memberId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    private LocalDate membershipDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private MemberStatus status;
    
    @OneToMany(mappedBy = "member")
    private List<BookLoan> loans;
    
    @OneToMany(mappedBy = "member")
    private List<Reservation> reservation;

    // getters and setters
}